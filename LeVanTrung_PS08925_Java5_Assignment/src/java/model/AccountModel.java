package model;

import entities.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Heartnet
 */
public class AccountModel {

    public AccountModel() {

    }

    public int loginAccount(Account a) {
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;  // kết nối không thành công.
        }
        try {
            String sql = "select * from admin where username = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                if (rs.getString(2).equals(a.getPassword())) {
                    return 1; //login thành công
                } else {
                    return 2; // sai mật khẩu.
                }
            } else {
                return 3; // username không tồn tại.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // login thất bại.
    }

    public ArrayList getList() {
        ArrayList<Account> list = new ArrayList();

        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return null;
        }
        try {
            String sql = "select * from Admin";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getString(1), rs.getString(2));
                list.add(acc);
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // kq = 0 insert thất bại.
    // 1 thành công.
    //-1 lỗi kết nối
    public int insertAccount(Account a) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;//kết nối thất bại.
        }
        try {
            String sql = "insert into admin values(?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            return kq = ps.executeUpdate(); ///trả về 1 insert thành công.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int deleteAccount(Account a) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;//kết nối thất bại.
        }
        try {
            String sql = "delete from admin where username=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            kq = ps.executeUpdate(); ///trả về số dòng tác động thành công.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public Account getAccountByUser(String username) {
        Account account = null;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            ///không kết nối dc
            return null;
        }
        try {
            String sql = "select * from admin where username=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public int updateAccount(Account a) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;//kết nối thất bại.
        }
        try {
            String sql = "update admin set password= ? where username= ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, a.getPassword());
            ps.setString(2, a.getUsername());
            return kq = ps.executeUpdate(); ///trả về 1 insert thành công.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public ArrayList getList(String username) {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return null;
        }
        try {
            String sql = "select * from Admin where username like '" + username + "%'";
            PreparedStatement ps = cn.prepareStatement(sql);
            // ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getString(1), rs.getString(2));
                list.add(acc);
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
