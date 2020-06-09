/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Heartnet
 */
public class Account {

    private String username;
    private String password;
    private String hoten;
    private boolean gioitinh;
    private String email;

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getHoten() {
        return hoten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }
    
    public Account(){
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Account() {
//        this.username = "";
//        this.password = "";
//    }

    public Account(String username, String password,String hoten,boolean gioitinh, String email) {
        this.username = username;
        this.password = password;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.email=email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
