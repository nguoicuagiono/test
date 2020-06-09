package entities;

public class Item {

    private SanPham sanpham;
    private int soluong;

    public Item(SanPham sanpham, int soluong) {
        this.sanpham = sanpham;
        this.soluong = soluong;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

}
