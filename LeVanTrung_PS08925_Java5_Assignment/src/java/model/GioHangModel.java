package model;

import entities.Item;
import entities.SanPham;
import java.util.ArrayList;
import java.util.HashMap;

public class GioHangModel {

    HashMap<Integer, Item> cart; // chứa<msp,item>

    public GioHangModel() {
        cart = new HashMap<>();
    }

    public void addSanPham(Integer msp) {
        //nếu sản phẩm đã tồn tại trong giỏ hàng -> tăng số lượng.
        if (cart.containsKey(msp)) {
            Item item = cart.get(msp);   //lấy item ở Key(Integer) = msp;
            int count = item.getSoluong(); ///lấy sl
            count = count + 1;              /// tăng 1 đv
            item.setSoluong(count);         //gán số lượng vào giỏ hàng.

        } else {
            ///nếu sản phẩm chưa có trong giỏ hàng-> thêm sản phẩm vào giỏ hàng.
            SanPham sanPham = new SanPhamModel().getSanPhamByMaSP(msp);
            Item item = new Item(sanPham, 1);
            cart.put(msp, item);  ///add vào hashmap.

        }
    }

    public ArrayList<Item> getListItems() {
        ArrayList<Item> listItem = new ArrayList<>();
        for (Item item : cart.values()) {
            listItem.add(item);
        }
        return listItem;
    }

    public void remove(Integer msp) {
        cart.remove(msp);
    }

    public void removeAll() {
        cart.clear();
    }

    public int getTongTien() {
        int total = 0;
        for (Item i : cart.values()) {
            total = total + i.getSoluong() * i.getSanpham().getDonGia();
        }
        return total;
    }
}
