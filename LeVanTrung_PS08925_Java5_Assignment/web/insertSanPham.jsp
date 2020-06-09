<%-- 
    Document   : insertSanPham
    Created on : Dec 27, 2019, 11:10:35 PM
    Author     : trung
--%>

<%@page import="model.DanhMucModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.DanhMuc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thêm Giao Dịch</h1>
        <% ArrayList list = new DanhMucModel().getList();%>
        <%--
        enctype="": để cho phép chuyển dữ liệu dạg File đến server.
       
        --%>
        <form action="SanPhamServlet?yeucau=insert" method="post" enctype="multipart/form-data">
            <table border="1">
                <tbody>
                    <tr>
                        <td>TênSP: </td>
                        <td><input type="text" name="txttensp" value="" /> </td>
                    </tr>
                    <tr>
                        <td>GiáSP: </td>
                        <td><input type="text" name="txtgia" value="" /></td>
                    </tr>
                    <tr>
                        <td>SốLượng: </td>
                        <td><input type="text" name="txtsoluong" value="" /></td>
                    </tr>
                    <tr>
                        <td>HìnhSP: </td>
                        <td><%--<input type="text" name="txthinh" value="" />--%>
                            <input type="file" name="txthinh" value="" /></td>

                    </tr>
                    <tr>
                        <td>MãSP: </td>
                        <td>
                            <select name ="ddListSP">
                                <c:forEach var="loai" items="<%=list%>">

                                    <option value="${loai.getMaLoai()}">${loai.getTenLoai()}</option>
                                </c:forEach>                                  
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><input type="submit" value="Insert" /></td> 
                    </tr>  
                <input type="submit" value="Check" />
                </tbody>
            </table>
        </form>
    </body>
</html>
