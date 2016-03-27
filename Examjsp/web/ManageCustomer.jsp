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
                        <div class="col-md-12"><h3> Manage Customer </h3></div>

                    </td>
                </tr>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./AddCustomer.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;" > Add Customer  </a>
                        </div> 
                    </td>
                </tr>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./UpdateCustomer.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;" > Update Customer </a>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./DeleteCustomer.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;" > Delete Customer </a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./SearchCustomer.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;">Search Customer </a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="height: 80px">
                        <div class="col-md-12 "> 
                            <a href="./ViewAllCustomers.jsp" target="right" class="btn btn-primary" style="width: 200px; height: 60px;">View All Customer </a>
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

