/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entities.ChiTietHoaDon;
import entities.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DonHangChiTietModel;
import model.DonHangModel;
import model.GioHangModel;

/**
 *
 * @author Heartnet
 */
@WebServlet(name = "GioHangServlet", urlPatterns = {"/GioHangServlet"})
public class GioHangServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    GioHangModel giohang_model = new GioHangModel();///HashMap

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String page = "";
            String message = "";
            String yeucau = request.getParameter("yeucau");
            String masp = request.getParameter("txtmasp");
            HttpSession session = request.getSession();
            if (yeucau.equals("muasp")) {
                giohang_model.addSanPham(Integer.parseInt(masp));

            } else if (yeucau.equals("xoa")) {
                giohang_model.remove(Integer.parseInt(masp));
            } else if (yeucau.equals("xoahet")) {
                giohang_model.removeAll();
            } else if (yeucau.equals("thanhtoan")) {
                //lấy ngày hiện tại.
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();
                String ngayHD = dateFormat.format(cal.getTime());

                //insert đơn hàng mới.
                DonHangModel donHangModel = new DonHangModel();
                donHangModel.insertHoaDon(ngayHD, 1);//tạm mã kh 1.

                //lấy mã hóa đơn.
                int maHD = donHangModel.getMaHD();

                //insert đơn hàng chi tiết.
                ArrayList<Item> listItems = giohang_model.getListItems();
                for (Item item : listItems) {
                    ChiTietHoaDon cTDH = new ChiTietHoaDon(maHD,
                            item.getSanpham().getMaSP(),
                            item.getSanpham().getDonGia(), item.getSoluong());

                    int kq = new DonHangChiTietModel().insertHoaDonChiTiet(cTDH);

                }

                //xóa giỏ hàng.
                giohang_model.removeAll();
                page = "thongbao.jsp";
                message = "Mã đơn hàng quý khách đặt có mã " + maHD + " đã đặt thành công.";
                request.setAttribute("thongbao", message);
                request.getRequestDispatcher(page).forward(request, response);
                return;

            }
            session.setAttribute("giohang", giohang_model.getListItems());
            request.setAttribute("total", giohang_model.getTongTien());
            page = "giohang.jsp";
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
