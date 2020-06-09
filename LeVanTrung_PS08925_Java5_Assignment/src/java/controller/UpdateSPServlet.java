/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.SanPham;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.SanPhamModel;
import model.UploadModel;

/**
 *
 * @author Heartnet
 */
@WebServlet(name = "UpdateSPServlet", urlPatterns = {"/UpdateSPServlet"})
public class UpdateSPServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String yeucau = request.getParameter("yeucau");
        String masp = request.getParameter("txtmasp");
        String tensp = request.getParameter("txttensp");
        String gia = request.getParameter("txtgia");
        String soluong = request.getParameter("txtsoluong");
        String maloai = request.getParameter("ddListSP");
        Part filehinh = request.getPart("txthinh");
        String tenhinh = new UploadModel().getTenHinh(filehinh);

        String message = "";
        String page = "";
        if (yeucau.equals("update")) {

            if (tenhinh.equals("")) {//nếu ko chọn hình lấy hình củ.
                tenhinh = request.getParameter("txthinh_old");
            } else {
                ///upload hình mới lên server.
                String uploadRootPath = request.getServletContext().getRealPath("/images");
                boolean kqupload = new UploadModel().uploadFile(tenhinh, filehinh, uploadRootPath);
                if (!kqupload) {
                    request.setAttribute("thongbao", "Upload hình thất bại.");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                    return;
                }
            }

            SanPham sp = new SanPham(Integer.parseInt(masp), tensp, Integer.parseInt(gia),
                    Integer.parseInt(soluong),
                    tenhinh, Integer.parseInt(maloai));

            int kq = new SanPhamModel().updateSanPham(sp);
            if (kq == -1) {
                message = "Kết nối database thất bại.";
                page = "Error.jsp";
            } else if (kq == 0) {
                message = "Update thất bại.";
                page = "Error.jsp";
            } else if (kq == 1) {
                page = "quanly.jsp";
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
