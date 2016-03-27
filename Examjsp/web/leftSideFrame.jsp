<%-- 
    Document   : leftSideFrame
    Created on : Oct 10, 2014, 2:55:53 PM
    Author     : Demo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./static/css/bootstrap.css" rel="stylesheet"/>
        <link href="./static/css/bootstrap-theme.css" rel="stylesheet"/>
        <link rel="stylesheet" href='./static/css/MyStyleSheet.css'/>
    </head>
    <body>
        
        <h2> Main Menu </h2>
        <div> 
            <a href="./AddItem.jsp" target="right" > <h5>Add Item</h5> </a>
        </div>
        <div> 
            <a href="./UpdateItem.jsp" target="right" > <h5>Update Item</h5> </a>
        </div>
        <div> 
            <a href="./DeleteItem.jsp" target="right" > <h5>Delete Item</h5> </a>
        </div>
        <div> 
            <a href="./SearchItem.jsp" target="right" > <h5>Search Item</h5> </a>
        </div>
        <div> 
            <a href="./OrderForm.jsp" target="right" > <h5>Place Order</h5> </a>
        </div>
    </body>
</html>

