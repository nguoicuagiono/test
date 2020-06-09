/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.KhachHang;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.KhachHangModel;

/**
 *
 * @author Heartnet
 */
@WebServlet(name = "LoginKhachHangServlet", urlPatterns = {"/LoginKhachHangServlet"})
public class LoginKhachHangServlet extends HttpServlet {

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
        String message = "";
        String page = "";
        String yeucau = request.getParameter("yeucau");
        String sdt = request.getParameter("txtsodienthoai");
        String password = request.getParameter("txtpassword");
        HttpSession session = request.getSession();
        KhachHang kh = new KhachHangModel().getKhachHang(sdt);

        if (yeucau.equals("dangnhap")) {
            if (sdt.equals("")) {
                message = "Chưa nhập số điện thoại";
                page = "Error.jsp";
            } else {
                if (kh == null) {
                    message = "Sai số điện thoại đăng nhập.";
                    page = "Error.jsp";
                } else if (!password.equals(kh.getMatKhau())) {
                    message = "Sai mật khẩu.";
                    page = "Error.jsp";
                } else if (password.equals(kh.getMatKhau())) {
                    session.setAttribute("user", kh);
                    page = "index.jsp";
                }
            }
        }
        if (yeucau.equals("dangxuat")) {
            session.setAttribute("user", null);
            page = "index.jsp";
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
