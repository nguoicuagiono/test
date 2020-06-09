<%-- 
    Document   : quanly
    Created on : Oct 29, 2019, 1:04:24 PM
    Author     : trung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <center>
        <a href="loginadmin.jsp">dang xuat</a>
        </center>   
        <h1>Danh sach khach hang</h1>
       
            <form action="AccountServlet2?yeucau=Search" method="post">
                UserName: <input type="txt" name="txtname" value="">
                <input type="submit" value="Tìm kiếm"/>     
            </form>
        
        <form action="AccountServlet2?yeucau=xoanhieu" method="post">
            <table border="1">
                <tr>
                    <td>Chon</td>
                    <td>UserName</td>
                    <td>PassWord</td>
                    <td>hoten</td>
                    <td>gioitinh</td>
                    <td>email</td>
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
                    <td><%=acc.getHoten()%></td>
                    <td><%=acc.isGioitinh()? "nam" : "nu" %></td>
                    <td><%=acc.getEmail()%></td>
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
                      <h3><a href="insertaccount.jsp" >Them khach hang  </a></h3>
            </table>                   
        </form>
  



</html>
