/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPhamModel;

/**
 *
 * @author Heartnet
 */
@WebServlet(name = "DeleteSPServlet", urlPatterns = {"/DeleteSPServlet"})
public class DeleteSPServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mmh = request.getParameter("txtmasp");
        String yeucau = request.getParameter("yeucau");
        String page = "";
        String message = "";
        SanPhamModel sanPhamModel = new SanPhamModel();
        if (yeucau.equals("xoa")) {
            int kq = sanPhamModel.deleteSanPham(mmh);
            if (kq == -1) {
                message = "Lỗi kết nối dữ liệu";
                page = "Error.jsp";
            } else if (kq == 0) {
                message = "Xóa không thành công.";
                page = "Error.jsp";
            } else if (kq > 0) {
                page = "quanly.jsp";
            }
        }

        if (yeucau.equals("xoanhieu")) {
            String[] listMaSP = request.getParameterValues("chon");
            if (listMaSP == null) {
                message = "Bạn chưa chọn sản phẩm nào.";
                page = "Error.jsp";
            } else {
                for (String sp : listMaSP) {
                    int kq = sanPhamModel.deleteSanPham(sp);
                    if (kq == -1) {
                        message = "Lỗi kết nối dữ liệu.";
                        page = "Error.jsp";
                    } else if (kq == 0) { ///tồn tại dữ liệu ko xóa được
                        message = "Dữ liệu không xóa được.";
                        page = "Error.jsp";
                    } else if (kq > 0) {
                        page = "quanly.jsp";
                    }
                }
            }

        }
        request.setAttribute("thongbao", message);
        request.getRequestDispatcher(page).forward(request, response);

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
