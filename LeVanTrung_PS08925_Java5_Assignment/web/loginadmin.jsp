<%-- 
    Document   : loginadmin
    Created on : Dec 27, 2019, 10:29:14 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">

                <div class="fadeIn first">
                    <img src="images/iconlogin0.png"  id="icon" alt="User Icon" />
                </div>

                <!-- Login Form -->
                <form action="LoginServlet" method="post">
                    <input type="text" id="login" class="fadeIn second" name="txtusername" placeholder="Login Please!">
                    <input type="text" id="password" class="fadeIn third" name="txtpassword" placeholder="Password Please!">
                    <input type="submit" class="fadeIn fourth"  name="Action" value="Log In">
                </form>

                <!-- Remind Passowrd -->
                <div id="formFooter">
                    <a class="underlineHover" href="#">Forget?!?</a>
                </div>

            </div>
        </div>
    </body>
</html>
