<%-- 
    Document   : UpdateCustomer
    Created on : Sep 27, 2014, 8:34:47 AM
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
        <div id="mainDiv" class="row col-md-10  " style="margin-left: 100px; margin-top:80px ">
            <table class="table table-bordered col-md-6 marginTop" >
                <tbody>
                    <tr>
                        <td>
                            Customer ID
                        </td>
                        <td>
                            Customer Name
                        </td>
                        <td>
                            Customer Address
                        </td>
                        <td>
                            Customer Salary
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <script type="text/javascript">
            var ida;

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
                                ida = document.getElementById("idTf").value;
                            } else {
                                alert("No Such Customer");
                                document.getElementById("idTf").value = "";
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

            function updateCustomer() {

                var xmlrequest;
                if (window.XMLHttpRequest) {
                    xmlrequest = new XMLHttpRequest();
                } else {
                    xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
                }

                xmlrequest.onreadystatechange = function() {
                    if (xmlrequest.readyState == 4 && xmlrequest.status == 200) {
                        if (xmlrequest.responseText) {
                            var res = parseInt(xmlrequest.responseText);
                            if (res === 1) {
                                alert("Customer Updated");
                                document.getElementById("idTf").valu0 = "";
                                document.getElementById("nameTf").value = "";
                                document.getElementById("addressTf").value = "";
                                document.getElementById("salaryTf").value = "";
                            } else {
                                alert("Customer Not Update");
                            }
                        }

                    }

                };


                var name = document.getElementById("nameTf").value;
                var address = document.getElementById("addressTf").value;
                var salary = document.getElementById("salaryTf").value;
                //console.log(id+"-"+name+"-"+address)
                xmlrequest.open("PUT", "Customer?id=" + ida + "&name=" + name + "&address=" + address + "&salary=" + salary, true);
                // xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlrequest.send();





            }
            ;
        </script>
    </body>
</html>

