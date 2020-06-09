package model;

import entities.ChiTietHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DonHangChiTietModel {

    public int insertHoaDonChiTiet(ChiTietHoaDon dhct) {
        Connection cn = new MyConnect().getcn();
        int kq = 0;
        if (cn == null) {
            //lỗi kết nối csdl.
            return -1;
        } else {
            try {
                String sql = "insert into ChiTietDonHang values(?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, dhct.getMahd());
                pst.setInt(2, dhct.getMasp());
                pst.setInt(3, dhct.getSoluong());
                pst.setDouble(4, dhct.getDongia());
                kq = pst.executeUpdate();
                pst.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return kq; //insert thất bại.
    }
}
