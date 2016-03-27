<%-- 
    Document   : AddCustomer
    Created on : Sep 27, 2014, 8:28:46 AM
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
        <script type="text/javascript" src="./static/js/JQ.js" ></script>
        <script type="text/javascript" src="./static/js/Js.js" ></script>
        <form>
            <div id="mainDiv" class="row col-md-6  "  style="margin-left: 100px; margin-top:80px ">
                <div id="header" class="col-md-12 col-md-offset-4 form-group">
                    <h1>Add Customer</h1>
                </div>
                <div id="idDiv" class="col-md-12">
                    <div id="idLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Customer ID</label>
                    </div>
                    <div id="idText" class="col-md-4">
                        <input class="form-control" type="text" name="customerId" id="idTf"/>
                    </div>
                </div>
                <div id="nameDiv" class="col-md-12">
                    <div id="nameLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Customer Name</label>
                    </div>
                    <div id="nameText" class="col-md-6">
                        <input id="nameTf" class="form-control" onkeyup="TextValidation(id)" type="text" name="customerName"/>
                    </div>
                </div>
                <div id="emailDiv" class="col-md-12">
                    <div id="emailLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Customer Email</label>
                    </div>
                    <div id="emailText" class="col-md-6">
                        <input id="emailTf" class="form-control" type="text" name="customerEmail"/>
                    </div>
                </div>
                <div id="passwordDiv" class="col-md-12">
                    <div id="passwordLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Customer Password</label>
                    </div>
                    <div id="passwordText" class="col-md-6">
                        <input id="passwordTf" class="form-control" type="password" name="customerPassword"/>
                    </div>
                </div>
                <div id="phoneNoDiv" class="col-md-12">
                    <div id="phoneNoLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Customer PhoneNo</label>
                    </div>
                    <div id="phoneNoText" class="col-md-6">
                        <input id="phoneNoTf" class="form-control" type="text" name="customerPhoneNo"/>
                    </div>
                </div>
                <div id="addressDiv" class="col-md-12">
                    <div id="addressLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Customer Address</label>
                    </div>
                    <div id="addressText" class="col-md-6">
                        <input class="form-control" type="text" name="customerAddress" id="addressTf"/>
                    </div>
                </div>
                   <div id="regDateDiv" class="col-md-12">
                    <div id="regDateLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Customer RegDate</label>
                    </div>
                    <div id="regDateText" class="col-md-6">
                        <input id="regDateTf" class="form-control" type="text" name="customerRegDate"/>
                    </div>
                </div>
                <div id="buttonDiv" class="col-md-11 col-md-push-7 form-group">

                    <input type="button" value="Save" class="btn  btn-success buttonSize" onclick="addCustomer()"/>
                    <input type="button" value="Cancel" class="btn btn-danger buttonSize"/>
                </div>
            </div>
        </form>

        <script type="text/javascript">
            function addCustomer() {

                var xmlrequest;
                if (window.XMLHttpRequest) {
                    
                    xmlrequest = new XMLHttpRequest();

                } else {
                    xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
                }

                xmlrequest.onreadystatechange = function () {
                    if (xmlrequest.readyState == 4 && xmlrequest.status == 200) {
                      //  alert("a");
                        if (xmlrequest.responseText) {
                       //     alert("aa");
                            var res = parseInt(xmlrequest.responseText);
                            if (res === 1) {
                       //         alert("aaaa");
                                alert("Customer Added");
                                document.getElementById("idTf").valu0 = "";
                                document.getElementById("nameTf").value = "";
                                document.getElementById("emailTf").value = "";
                                document.getElementById("passwordTf").value = "";
                                document.getElementById("phoneNoTf").value = "";
                                document.getElementById("addressTf").value = "";
                                document.getElementById("regDateTf").value = "";
                            } else {
                                alert("Customer Not Add");
                            }
                        }

                    }

                };

                var id = document.getElementById("idTf").value;
                var name = document.getElementById("nameTf").value;
                var email = document.getElementById("emilTf").value;
                var password = document.getElementById("passwordTf").value;
                var phoneNo = document.getElementById("phoneNoTf").value;
                var address = document.getElementById("addressTf").value;
                var regDate = document.getElementById("regDateTf").value;
                
                //console.log(id+"-"+name+"-"+address)
                xmlrequest.open("POST", "Customer", true);
                xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlrequest.send("nic=" + id + "&fullName=" + name + "&email=" + email + "&password=" + password+"&phoneNo="+phoneNo+"&address="+address+"&regDate="+regDate);





            }
            ;

        </script>
    </body>
</html>
