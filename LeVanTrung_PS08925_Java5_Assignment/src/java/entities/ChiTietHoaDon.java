package entities;

public class ChiTietHoaDon {

    private int mahd;
    private int masp;
    private int soluong;
    private double dongia;

    public ChiTietHoaDon(int mahd, int masp, int soluong, double dongia) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public int getMahd() {
        return mahd;
    }

    public int getMasp() {
        return masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

}
