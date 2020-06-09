/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountModel;

/**
 *
 * @author Heartnet
 */
@WebServlet(name = "AccountServlet2", urlPatterns = {"/AccountServlet2"})
public class AccountServlet2 extends HttpServlet {

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

        String yeucau = request.getParameter("yeucau");///biến ?yeucau=insert.

        String username = request.getParameter("txtname");
        String password = request.getParameter("txtpass");
        String hoten = request.getParameter("txthoten");
        boolean gioitinh = Boolean.parseBoolean(request.getParameter("txtgioitinh")); 
        String email = request.getParameter("txtemail");
        
        String page = "";
        String message = "";
        HttpSession session = request.getSession(); ///biến đối tượng .

        Account acc = new Account(username, password,hoten,gioitinh, email);
        AccountModel acc_model = new AccountModel();

        if (yeucau.equals("insert")) {
            int kq = acc_model.insertAccount(acc);
            if (kq == 1) {
                // insert thành công.
                page = "quanly.jsp";
                AccountModel model = new AccountModel();
                session.setAttribute("accountList", model.getList());
            } else if (kq == 0) {
                //insert ko thành công.
                message = "insert thất bại";
                page = "Error.jsp";
            } else if (kq == -1) {
                message = "kết nối database thất bại";
                page = "Error.jsp";
            }
        } else if (yeucau.equals("delete")) {
            int kq = acc_model.deleteAccount(acc);
            if (kq == 1) {
                // delete thành công.
                page = "quanly.jsp";
                AccountModel model = new AccountModel();
                session.setAttribute("accountList", model.getList());
            } else if (kq == 0) {
                //insert ko thành công.
                message = "delete thất bại";
                page = "Error.jsp";
            } else if (kq == -1) {
                message = "kết nối database thất bại";
                page = "Error.jsp";
            }
        } else if (yeucau.equals("laythongtin")) {
            Account account = acc_model.getAccountByUser(username);
            if (account != null) {
                session.setAttribute("acc", account);
                page = "updateaccount.jsp";
            } else {
                message = "Không kết nối dc";
                page = "Error.jsp";
            }
        } else if (yeucau.equals("Update")) {
            int kq = acc_model.updateAccount(acc);
            if (kq == 1) {
                session.setAttribute("accountList", acc_model.getList());
                page = "quanly.jsp";
            } else {
                message = "Không kết nối được";
                page = "Error.jsp";
            }
        } else if (yeucau.equals("xoanhieu")) {

            String[] listUserName = request.getParameterValues("chon");
            System.out.println(listUserName);
            int kq = 1;
            if (listUserName == null) {
                message = "Chưa chọn dữ liệu cần xóa";
                page = "error.jsp";
            } else {
                for (String us : listUserName) {
                    Account ac = new Account(us, "","",gioitinh,"");
                    kq = acc_model.deleteAccount(ac);
                }
                if (kq == 0) {//tồn tại dữ liệu không xóa được
                    message = "Không xóa hết được dữ liệu.";
                    page = "error.jsp";
                } else {
                    session.setAttribute("accountList", acc_model.getList());
                    page = "quanly.jsp";

                }
            }
        } else if (yeucau.equals("Search")) {
            session.setAttribute("accountList", acc_model.getList(username));
            page = "quanly.jsp";
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
