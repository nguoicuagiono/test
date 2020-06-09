/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.DanhMuc;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DanhMucModel;

/**
 *
 * @author Heartnet
 */
@WebServlet(name = "DanhMucServlet", urlPatterns = {"/DanhMucServlet"})
public class DanhMucServlet extends HttpServlet {

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
        String page = "";
        String message = "";
        String maloai = request.getParameter("txtmaloai");
        String yeucau = request.getParameter("yeucau");
        DanhMucModel dmMD = new DanhMucModel();
        HttpSession session = request.getSession();
        if (yeucau.equals("delete")) {
            int kq = dmMD.deleteDanhMuc(maloai);
            if (kq == 1) {
                // delete thành công.
                page = "quanly.jsp";
            } else if (kq == 0) {
                //insert ko thành công.
                message = "delete thất bại";
                page = "Error.jsp";
            } else if (kq == -1) {
                message = "kết nối database thất bại";
                page = "Error.jsp";
            }
        } else if (yeucau.equals("laythongtin")) {
            DanhMuc danhMuc = dmMD.getDanhMucByMaDM(maloai);
            if (danhMuc != null) {
                System.out.println("1123123");
                session.setAttribute("danhmuc", danhMuc);
                page = "updatedanhmuc.jsp";
            } else {
                message = "Không kết nối dc";
                page = "Error.jsp";
            }
        } else if (yeucau.equals("update")) {
            int kq = dmMD.updateDanhMuc(maloai);
            if (kq == 1) {
                page = "quanly.jsp";
            } else {
                message = "Không kết nối được";
                page = "Error.jsp";
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
