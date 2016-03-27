<%-- 
    Document   : SearchCustomer
    Created on : Sep 27, 2014, 8:35:37 AM
    Author     : Demo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="./static/css/bootstrap.css" rel="stylesheet"/>
        <link href="./static/css/bootstrap-theme.css" rel="stylesheet"/>
        <link href="./static/css/MyStyleSheet.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="mainDiv" class="row col-md-6  " style="margin-left: 100px; margin-top:80px ">
            <div id="header" class="col-md-12 col-md-offset-4 form-group">
                <h1>Search Customer</h1>
            </div>
            <div id="idDiv" class="col-md-12">
                <div id="idLable" class="col-md-6 col-md-push-2">
                    <label class="lead">Customer ID</label>
                </div>
                <div id="idText" class="col-md-4">
                    <input class="form-control" type="text" id="idTf"/>
                </div>
            </div>
            <div id="nameDiv" class="col-md-12">
                <div id="nameLable" class="col-md-6 col-md-push-2">
                    <label class="lead">Customer Name</label>
                </div>
                <div id="nameText" class="col-md-6">
                    <input class="form-control" type="text" id="nameTf"/>
                </div>
            </div>
            <div id="addressDiv" class="col-md-12">
                <div id="addressLable" class="col-md-6 col-md-push-2">
                    <label class="lead">Customer Address</label>
                </div>
                <div id="addressText" class="col-md-6">
                    <input class="form-control" type="text" id="addressTf"/>
                </div>
            </div>
            <div id="salaryDiv" class="col-md-12">
                <div id="salaryLable" class="col-md-6 col-md-push-2">
                    <label class="lead">Customer Salary</label>
                </div>
                <div id="salaryText" class="col-md-4">
                    <input class="form-control" type="text" id="salaryTf"/>
                </div>
            </div>
            <div id="buttonDiv" class="col-md-11 col-md-push-7 form-group">
                <input type="button" value="Search" class="btn btn-success buttonSize" onclick="searchCustomer()"/>
                <input type="button" value="Cancel" class="btn btn-danger buttonSize"/>
            </div>
        </div>


        <script type="text/javascript">
            function searchCustomer() {

                if (document.getElementById("idTf").value) {
                    var xmlrequest;
                    if (window.XMLHttpRequest) {
                        xmlrequest = new XMLHttpRequest();
                    } else {
                        xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
                    }

                    xmlrequest.onreadystatechange = function() {
                        if (xmlrequest.readyState == 4 && xmlrequest.status == 200) {
                            var xmlDoc = xmlrequest.responseXML;
                            if (xmlDoc) {
                                var detailTag = xmlDoc.getElementsByTagName("detail");
                                var idTag = xmlDoc.getElementsByTagName("id");
                                var nameTag = xmlDoc.getElementsByTagName("name");
                                var addressTag = xmlDoc.getElementsByTagName("address");
                                var salaryTag = xmlDoc.getElementsByTagName("salary");

                                //document.getElementById("idTf").valu0 = idTag[0].childNodes[0].nodeValue;
                                document.getElementById("nameTf").value = nameTag[0].childNodes[0].nodeValue;
                                document.getElementById("addressTf").value = addressTag[0].childNodes[0].nodeValue;
                                document.getElementById("salaryTf").value = salaryTag[0].childNodes[0].nodeValue;
                            } else {
                                alert("No Such Customer");
                                document.getElementById("nameTf").value = "";
                                document.getElementById("addressTf").value = "";
                                document.getElementById("salaryTf").value = "";
                            }
                        }

                    };
                    var id = document.getElementById("idTf").value;
                    //console.log(id+"-"+name+"-"+address)
                    xmlrequest.open("GET", "Customer?id=" + id, true);
                    //xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    xmlrequest.send();

                } else {
                    alert("Please Enter The Id you want to delete ");
                }

            }
            ;
        </script>
    </body>
</html>

