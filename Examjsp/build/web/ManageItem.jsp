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

        <table>
            <tbody>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12"><h2> Manage Item </h2></div>

                    </td>
                </tr>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./AddItem.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;" > Add Item  </a>
                        </div> 
                    </td>
                </tr>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./UpdateItem.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;" > Update Item </a>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./DeleteItem.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;" > Delete Item </a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./SearchItem.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;">Search Item </a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./OrderForm.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;"> Place Order </a>
                        </div>
                    </td>
                </tr>
            </tbody> 
        </table>





    </body>
</html>

