<%-- 
    Document   : nav
    Created on : Nov 17, 2014, 8:37:26 AM
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

        <nav class="navbar navbar-inverse navbar-static" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Thogakade Menu</a>
                </div>
                <div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./ManageCustomer.jsp" target="left">Manage Customer</a>
                </div>
                <div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./ManageItem.jsp" target="left">ManageItem</a>
                </div>
                <div class="collapse navbar-collapse navHeaderCollapse" > 
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="./OrderForm.jsp" target="right" >Place Order</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    <ng-view>
        <script type="text/javascript" src="static/js/jquery-2.1.1.js"></script>
        <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="static/js/angular.min.js"></script>
        <script type="text/javascript" src="static/js/angular-route.min.js"></script>
        <!--<script type="text/javascript" src="static/js/main.js"></script>-->
    </ng-view>
</body>
</html>
