<%-- 
    Document   : Login
    Created on : Oct 10, 2014, 3:36:10 PM
    Author     : Demo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./Login">
        <table>
            <tbody>
            <h1> Login </h1>
                <tr>
                    <td>User Name </td>
                    <td> <input type="text" name="userName" /></td>
                </tr>
                <tr>
                    <td>Password </td>
                    <td> <input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td> <input type="submit"value="Login" /></td>
                </tr>
            </tbody>
        </table>
        </form>
    </body>
</html>
