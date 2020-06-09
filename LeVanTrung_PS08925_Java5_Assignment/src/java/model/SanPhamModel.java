package model;

import entities.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamModel {

    public ArrayList getList(String tenSP) {
        ArrayList<SanPham> list = new ArrayList();
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            String sql = "select * from SanPham";
            if (!tenSP.equals("")) {
                sql = sql + " where TenSP like '%" + tenSP + "%'";
            }
            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    SanPham sp = new SanPham(rs.getInt(1), rs.getString(2), rs.getInt(3),
                            rs.getInt(4), rs.getString(5), rs.getInt(6));
                    list.add(sp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return list;
    }

    // kq = 0 insert thất bại.
    // 1 thành công.
    //-1 lỗi kết nối
    public int insertSanPham(SanPham a) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;//kết nối thất bại.
        }
        try {
            String sql = "insert into sanpham values(?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, a.getTenSP());
            ps.setInt(2, a.getDonGia());
            ps.setInt(3, a.getSoLuong());
            ps.setString(4, a.getHinh());
            ps.setInt(5, a.getMaLoai());
            return kq = ps.executeUpdate(); ///trả về 1 insert thành công.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    /*
    -1 kết nối thất bại.
    0 delete không thành công.
    >=1 xóa thành công.
     */
    public int deleteSanPham(String msp) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;//kết nối thất bại.
        }
        try {
            String sql = "delete from SanPham where MaSP=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, msp);
            kq = ps.executeUpdate(); ///trả về số dòng tác động thành công.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public SanPham getSanPhamByMaSP(int msp) {
        SanPham sp = null;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            ///không kết nối dc
            return null;
        }
        try {
            String sql = "select * from SanPham where MaSP=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, msp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp = new SanPham(rs.getInt("MaSP"), rs.getString("TenSP"), rs.getInt("DonGia"),
                        rs.getInt("SoLuong"), rs.getString("Hinh"), rs.getInt("MaDM"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public int updateSanPham(SanPham sp) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;//kết nối thất bại.
        }
        try {
            String sql = "update SanPham set TenSP=?, DonGia=?, SoLuong=?, Hinh=?, MaDM =? "
                    + "where MaSP=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setInt(2, sp.getDonGia());
            ps.setInt(3, sp.getSoLuong());
            ps.setString(4, sp.getHinh());
            ps.setInt(5, sp.getMaLoai());
            ps.setInt(6, sp.getMaSP());
            return kq = ps.executeUpdate(); ///trả về 1 insert thành công.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
}
