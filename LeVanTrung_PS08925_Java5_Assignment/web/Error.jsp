<%-- 
    Document   : Error
    Created on : Dec 27, 2019, 9:40:47 PM
    Author     : trung
--%>

<%@page import="entities.SanPham"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1 style="color: red;">Error Page!</h1>    
        <h3><%=request.getAttribute("thongbao")%> Please Refresh Page!</h3>
        </center>
        <%

            List<SanPham> list = (List) session.getAttribute("listsp");

        %>
        <c:forEach items="<%=list%>" var="abc">
            <a>${abc.getTenSP()}</a>
        </c:forEach>
    </body>
</html>
