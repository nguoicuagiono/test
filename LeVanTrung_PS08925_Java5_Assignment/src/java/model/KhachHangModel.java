package model;

import entities.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KhachHangModel {

    public KhachHang getKhachHang(String SoDT) {
        KhachHang kh = null;
        String sql = "Select * from KhachHang where DienThoai= ?";

        try {
            Connection cn = new MyConnect().getcn();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, SoDT);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getInt(1), rs.getString(2),
                        rs.getString(3),
                        Integer.parseInt(SoDT),
                        rs.getString(5));
            }
            cn.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kh;
    }
}
