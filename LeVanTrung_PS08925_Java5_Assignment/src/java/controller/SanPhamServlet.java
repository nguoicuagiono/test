/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.SanPhamModel;
import model.UploadModel;

/**
 *
 * @author Heartnet
 */
@WebServlet(name = "SanPhamServlet", urlPatterns = {"/SanPhamServlet"})
public class SanPhamServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        String yeucau = request.getParameter("yeucau");
        String page = "";
        String message = "";
        HttpSession session = request.getSession(); ///biến đối tượng .

        Part filehinh = null;
        String tenhinh = "";
        SanPhamModel sanPhamModel = new SanPhamModel();
        SanPham sanPham = null;
        try {
            String tensp = request.getParameter("txttensp");
            String gia = request.getParameter("txtgia");
            String soluong = request.getParameter("txtsoluong");
            //  String hinh = request.getParameter("txthinh");
            String maloai = request.getParameter("ddListSP");
            filehinh = request.getPart("txthinh");
            //String tenhinh = filehinh.getSubmittedFileName();
            tenhinh = new UploadModel().getTenHinh(filehinh);
            sanPham = new SanPham(tensp, Integer.parseInt(gia), Integer.parseInt(soluong),
                    tenhinh, Integer.parseInt(maloai));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (yeucau.equals("insert")) {
            /*
                o request.getServletContext().getRealPath(“/Images”) : 
                đường dẫn đến thư mục “Images” trên server ( nơi Client sẽ upload file lên)
             */
            String uploadRootPath = request.getServletContext().getRealPath("/images");
            boolean kqupload = new UploadModel().uploadFile(tenhinh, filehinh, uploadRootPath);
            if (!kqupload) {
                message = "Upload hình thất bại";
                page = page = "Error.jsp";
            }
            int a = sanPhamModel.insertSanPham(sanPham);
            switch (a) {
                case -1:
                    message = "Lỗi kết nối dữ liệu.";
                    page = "Error.jsp";
                    break;
                case 0:
                    message = "Thêm sản phẩm không thành công.";
                    page = "Error.jsp";
                    break;
                case 1:
                    page = "quanly.jsp";
                    break;
                default:
                    break;
            }
        } else if (yeucau.equals("laythongtin")) {
            String masanpham = request.getParameter("txtmasp");
            int msp = Integer.parseInt(masanpham);
            SanPham sp = sanPhamModel.getSanPhamByMaSP(msp);
            if (sp != null) {
                session.setAttribute("sanpham", sp);
                page = "updateSanPham.jsp";

            } else {
                message = "Không tìm thấy sản phẩm";
                page = "Error.jsp";
            }
        } else if (yeucau.equals("timkiem")) {
            String ten = request.getParameter("tensp");
            List<SanPham> listSP = sanPhamModel.getList(ten);
            session.setAttribute("listsp", listSP);
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
