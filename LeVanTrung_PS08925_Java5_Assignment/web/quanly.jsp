<%-- 
    Document   : quanly
    Created on : Dec 27, 2019, 11:10:56 PM
    Author     : trung
--%>
<%@page import="model.DanhMucModel"%>
<%@page import="entities.DanhMuc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.SanPhamModel"%>
<%@page import="entities.SanPham"%>
<%@page import="java.util.List"%>
<%@page import="entities.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/table.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.jsp">Quay về trang chủ</a>
        <h1>Danh Sách Account</h1>
        <div style="float: right;">
            <form action="AccountServlet2?yeucau=Search" method="post">
                UserName: <input type="txt" name="txtname" value="">
                <input type="submit" value="Tìm kiếm"/>     
            </form>
        </div>
        <form action="AccountServlet2?yeucau=xoanhieu" method="post">
            <table border="1">
                <tr>
                    <td>Chọn</td>
                    <td>UserName</td>
                    <td>PassWord</td>
                    <td>Delete</td>
                    <td>Sửa</td>

                </tr>
                <%
                    ArrayList<Account> list = (ArrayList) session.getAttribute("accountList");
                    for (Account acc : list) {
                %>
                <tr>
                    <td><input type="checkbox" name="chon" value="<%=acc.getUsername()%>"</td>
                    <td><%=acc.getUsername()%></td>
                    <td><%=acc.getPassword()%></td>
                    <td><a href="AccountServlet2?yeucau=delete&txtname=<%= acc.getUsername()%>">
                            Delete</a></td>
                    <td><a href="AccountServlet2?yeucau=laythongtin&txtname=<%= acc.getUsername()%>">
                            Update</a></td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td><input type="submit" value="Xóa nhiều">   </td> 
                </tr>
            </table>                   
        </form>
        <h3><a href="insertaccount.jsp" style="color: orange; float: right;">Thêm nhân viên</a></h3>



        <h1 style="margin-top: 50px;">Quản lý sản phẩm.</h1> 
        <form action="DeleteSPServlet?yeucau=xoanhieu" method="post">
            <table border="1">
                <thead>
                    <tr>
                        <th>Chọn</th>
                        <th>MaSP</th>
                        <th>TenSP</th>
                        <th>DonGia</th>
                        <th>SoLuong</th>
                        <th>Hinh</th>
                        <th>MaLoai</th>
                        <th></th>
                        <th></th>

                    </tr>
                </thead>
                <tbody>                        
                    <% ArrayList<SanPham> listSP = new SanPhamModel().getList("");%>
                    <c:forEach items="<%=listSP%>" var="sp">
                        <tr>
                            <td><input  type="checkbox" name="chon" value="${sp.getMaSP()}" ></td>
                            <td>${sp.getMaSP()}</td>
                            <td>${sp.getTenSP()}</td>
                            <td>${sp.getDonGia()}</td>
                            <td>${sp.getSoLuong()}</td>
                            <td><img src="images/${sp.getHinh()}" width="80px" height="100px"/></td>
                            <td>${sp.getMaLoai()}</td>
                            <td><a href="DeleteSPServlet?yeucau=xoa&txtmasp=${sp.getMaSP()}">Delete</a></td>
                            <td><a href="SanPhamServlet?yeucau=laythongtin&txtmasp=${sp.getMaSP()}">Update</a></td>
                        </tr>

                    </c:forEach>
                    <tr>
                        <td><input type="submit" style="background-color: orange;" value="Xóa nhiều"> </td>
                        <td><a href="insertSanPham.jsp">Thêm Sản Phẩm</a></td>
                    </tr>
                </tbody>
            </table>              
            <h3><a href="insertSanPham.jsp" style="color: orange; float: right;">Thêm sản phẩm</a></h3>
        </form>
    </body>

    <h1 style="margin-top: 50px;">Quản lý danh mục sản phẩm.</h1> 

    <table border="1">
        <thead>
            <tr>
                <th>Chon</th>
                <th>MaDM</th>
                <th>TenDM</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <%
                List<DanhMuc> listDM = new DanhMucModel().getList();
            %>
            <c:forEach items="<%=listDM%>" var="dm">
                <tr>
                    <td><input type="checkbox" name="chon" value=""</td>
                    <td>${dm.getMaLoai()}</td>
                    <td>${dm.getTenLoai()}</td>
                    <td><a href="DanhMucServlet?yeucau=delete&txtmaloai=${dm.getMaLoai()}">Delete</a></td>
                    <td><a href="DanhMucServlet?yeucau=laythongtin&txtmaloai=${dm.getMaLoai()}">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</center
</html>
