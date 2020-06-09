<%-- 
    Document   : loginadmin
    Created on : Oct 29, 2019, 1:03:44 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
     

    </head>
    <body>
    <center>    <h3>
                <!-- Login Form -->
                <form action="LoginServlet" method="post">
                    <input type="text"  id="login" class="fadeIn second" name="txtusername" placeholder="ten dang nhap">
                    <input type="text" id="password" class="fadeIn third" name="txtpassword" placeholder="mat khau">
                    <input type="submit" class="fadeIn fourth"  name="Action" value="Log In">
                </form>
                </h3>
</center>
    </body>
</html>
