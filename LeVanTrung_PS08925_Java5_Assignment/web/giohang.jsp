<%-- 
    Document   : giohang
    Created on : Dec 27, 2019, 8:45:42 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/table.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ hàng</title>
    </head>
    <body>
        <h1>Cart</h1>
        <section>             
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>MãSP</th>
                            <th>TênSP</th>
                            <th>HìnhSP</th>
                            <th>GiáSP</th>
                            <th>SốLượng</th>
                            <th>TotalSP</th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                        <c:forEach var="i" items="${giohang}">
                            <tr>
                                <td>${i.sanpham.maSP}</td>
                                <td>${i.sanpham.tenSP}</td>
                                <td><img src="images/${i.sanpham.hinh}" height="80" width="60"/></td>
                                <td>${i.sanpham.donGia}</td>
                                <td>${i.soluong}</td>
                                <td>${i.sanpham.donGia*i.soluong}</td>
                                <td><a href="GioHangServlet?yeucau=xoa&txtmasp=${i.sanpham.maSP}">Hủy</a></td>

                            </tr>                   
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>

    <center>
        <form action="index.jsp">
            Tổng Tiền:
            <p>${total}</p>
            <a href="GioHangServlet?yeucau=xoahet">Hủy Giao Dịch</a>
            <input type="submit" value="Mua Tiếp"/>
        </form>
        <form action="GioHangServlet?yeucau=thanhtoan" method="post">
            <input type="submit" value="Thanh Toán Thành Tiền"/>
        </form> 
    </center>
</body>
</html>
