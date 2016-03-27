<%-- 
    Document   : ErrorPage
    Created on : Oct 10, 2014, 8:33:17 PM
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
        <h1><%=request.getParameter("message") %></h1>
    </body>
</html>
