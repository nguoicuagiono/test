<%-- 
    Document   : insertaccount.jsp
    Created on : Oct 29, 2019, 1:07:48 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        </style>
    <body>
        <h1>Insert Account</h1>
        <form action="AccountServlet2?yeucau=insert" method="post">
            <table border="0">
                <tbody>
                    <tr>
                        <td>UserName</td>
                        <td><input type="text" name="txtname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="txtpass" value="" /></td>
                    </tr>
                    <tr>
                        <td>hoten</td>
                        <td><input type="text" name="txthoten" value="" /></td>
                    </tr>
                    <tr>
                        <td>gioitinh</td>
                        <td><input type="radio" name="txtgioitinh" value="" /></td>
                    </tr>
                    <tr>
                        <td>email</td>
                        <td><input type="text" name="txtemail" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Insert" name="Action" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
