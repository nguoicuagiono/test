<%-- 
    Document   : updateSanpham
    Created on : Dec 27, 2019, 9:20:47 PM
    Author     : trung
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="entities.SanPham"%>
<%@page import="model.DanhMucModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>updateSP</title>
    </head>
    <body>
        <h1>Thêm sản phẩm</h1>
        <h1>Hello World!</h1>
        <%
            ArrayList list = new DanhMucModel().getList();
            SanPham sanPham = (SanPham) session.getAttribute("sanpham");

        %>

        <%--
        enctype="": để cho phép chuyển dữ liệu dạg File đến server.
       
        --%>
        <form action="UpdateSPServlet?yeucau=update" method="post" enctype="multipart/form-data">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Mã sản phẩm</td>
                        <td><input type="text" name="txtmasp" value="<%=sanPham.getMaSP()%>"/></td>
                    </tr>
                    <tr>
                        <td>Tên sản phẩm</td>
                        <td><input type="text" name="txttensp" value="<%=sanPham.getTenSP()%>" /> </td>
                    </tr>
                    <tr>
                        <td>Gía</td>
                        <td><input type="text" name="txtgia" value="<%=sanPham.getDonGia()%>"/></td>
                    </tr>
                    <tr>
                        <td>Số lượng</td>
                        <td><input type="text" name="txtsoluong" value="<%=sanPham.getSoLuong()%>" /></td>
                    </tr>
                    <tr>
                        <td>Hình</td>
                        <td><%--<input type="text" name="txthinh" value="" 
                            hindden ẩn.
                              />--%>
                            <img src="images/<%=sanPham.getHinh()%>" width="50px" height="70px"/>
                            <input type="hidden" name="txthinh_old" value="<%=sanPham.getHinh()%>"/>

                            <input type="file" name="txthinh" value="" />
                        </td>

                    </tr>
                    <tr>
                        <td>Mã loại</td>
                        <td>
                            <select name ="ddListSP">

                                <c:forEach var="loai" items="<%=list%>">
                                    <c:set var="maloai" value="<%=sanPham.getMaLoai()%>"/>
                                    <option value="${loai.getMaLoai()}"  ${loai.getMaLoai()==maloai?'selected':''}>${loai.getTenLoai()}</option>
                                </c:forEach>   

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><input type="submit" value="Update" /></td>
                    </tr>                   
                </tbody>
            </table>
        </form>
    </body>
</html>
