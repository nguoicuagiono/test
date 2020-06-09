/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author trung
 */
public class DanhMucModel {

    //return null select không thành công.
    public ArrayList getList() {
        ArrayList<DanhMuc> list = new ArrayList();
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            String sql = "select * from DanhMuc";
            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    DanhMuc lsp = new DanhMuc(rs.getInt(1), rs.getString(2));
                    list.add(lsp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return list;
    }

    public int deleteDanhMuc(String maLoai) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;//kết nối thất bại.
        }
        try {
            String sql = "delete from DanhMuc where MaDM=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, maLoai);
            kq = ps.executeUpdate(); ///trả về số dòng tác động thành công.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public DanhMuc getDanhMucByMaDM(String madm) {
        DanhMuc danhMuc = null;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            ///không kết nối dc
            return null;
        }
        try {
            String sql = "select * from DanhMuc where MaDM=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, madm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhMuc = new DanhMuc(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhMuc;
    }

    public int updateDanhMuc(DanhMuc a) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;//kết nối thất bại.
        }
        try {
            String sql = "update DanhMuc set MaDM= ? where TenDM= ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, a.getMaLoai());
            ps.setString(2, a.getTenLoai());
            return kq = ps.executeUpdate(); ///trả về 1 insert thành công.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int updateDanhMuc(String maloai) {
        return 1;
    }
}
