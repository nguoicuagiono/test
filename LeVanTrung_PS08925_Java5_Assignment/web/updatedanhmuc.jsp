<%-- 
    Document   : updatedanhmuc
    Created on : Dec 27, 2019, 11:19:47 PM
    Author     : trung
--%>

<%@page import="entities.DanhMuc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpdateDM</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="DanhMucServlet?yeucau=update" method="post">
            <%
                DanhMuc danhMuc = (DanhMuc) session.getAttribute("danhmuc");
            %>
            <section> 
                <div class="tbl-content" width="500px">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <tr>
                                <td>Mã danh mục</td>
                                <td><input type="text" name="txtname" readonly value="<%=danhMuc.getMaLoai()%>" /></td> 
                            </tr>
                            <tr>
                                <td>Tên danh mục</td>
                                <td><input type="text" name="txtpass" value="<%=danhMuc.getTenLoai()%>" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Update" name="yeucau" /></td>
                            </tr>      

                        </tbody>
                    </table>
                </div>
            </section>

        </form>
    </body>
</html>
