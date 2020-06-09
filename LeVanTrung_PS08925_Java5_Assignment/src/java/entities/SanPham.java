package entities;

public class SanPham {

    private int maSP;
    private String tenSP;
    private int donGia;
    private int soLuong;
    private String hinh;
    private int maLoai;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, int donGia, int soLuong, String hinh, int maLoai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.hinh = hinh;
        this.maLoai = maLoai;
    }

    public SanPham(String tenSP, int donGia, int soLuong, String hinh, int maLoai) {
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.hinh = hinh;
        this.maLoai = maLoai;
    }

    public int getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getHinh() {
        return hinh;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

}
