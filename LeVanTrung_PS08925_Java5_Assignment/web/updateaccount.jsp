<%-- 
    Document   : updateaccount
    Created on : Dec 27, 2019, 8:26:37 PM
    Author     : trung
--%>

<%@page import="entities.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/table.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpdateSP</title>
    </head>
    <body>
        <h1>Update Account</h1>
        <form action="AccountServlet2?yeucau=Update" method="post">
            <%
                Account account = (Account) session.getAttribute("acc");
            %>
            <section> 
                <div class="tbl-content" width="500px">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <tr>
                                <td>UserName</td>
                                <td><input type="text" name="txtname" readonly value="<%=account.getUsername()%>" /></td> 
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="text" name="txtpass" value="<%=account.getPassword()%>" /></td>
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
