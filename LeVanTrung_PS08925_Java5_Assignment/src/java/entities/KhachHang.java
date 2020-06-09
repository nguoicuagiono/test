package entities;

public class KhachHang {

    int MaKH;
    String TenKH;
    String DiaChi;
    int DienThoai;
    String MatKhau;

    public KhachHang(int MaKH, String TenKH, String DiaChi, int DienThoai, String MatKhau) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.MatKhau = MatKhau;
    }

    public int getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public int getDienThoai() {
        return DienThoai;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setDienThoai(int DienThoai) {
        this.DienThoai = DienThoai;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

}
