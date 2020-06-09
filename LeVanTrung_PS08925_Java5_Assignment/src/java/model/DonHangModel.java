package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DonHangModel {

    public int insertHoaDon(String ngay, int makh) {
        Connection cn = new MyConnect().getcn();
        int kq = 0;
        if (cn == null) {
            //lỗi kết nối csdl.
            return kq = -1;
        } else {
            try {
                String sql = "insert into DonHang values(?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, ngay);
                pst.setInt(2, makh);
                kq = pst.executeUpdate();
                pst.close();
                cn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return kq; //insert thất bại.
    }

    public int getMaHD() {
        Connection cn = new MyConnect().getcn();
        int mahd = 0;
        if (cn == null) {
            return -1;
        } else {
            try {
                String sql = "select max(MaDH) from DonHang";
                Statement stm = cn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    mahd = rs.getInt(1);
                }
                stm.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mahd;
    }
}
