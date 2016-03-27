<%-- 
    Document   : DeleteItem
    Created on : Sep 27, 2014, 8:44:55 AM
    Author     : Demo
--%>

<%@page import="com.thogakade.model.Item"%>
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
                <h1>Update Item</h1>
            </div>
            <div id="idDiv" class="col-md-12">
                <div id="idLable" class="col-md-6 col-md-push-2">
                    <label class="lead">Item Code</label>
                </div>

                <div id="idText" class="col-md-4">
                    <input class="form-control" type="text" name="itemCode" id="itemCodeTf" onchange="searchItem()" />
                </div>

            </div>

            <input class="form-control" type="hidden" name="itemCode"/>
            <div id="discriptionDiv" class="col-md-12">
                <div id="discriptionLable" class="col-md-6 col-md-push-2">
                    <label class="lead">Description</label>
                </div>
                <div id="descriptionText" class="col-md-6">
                    <input class="form-control" type="text" id="descriptionTf"/>
                </div>
            </div>
            <div id="qtyDiv" class="col-md-12">
                <div id="qtyLable" class="col-md-6 col-md-push-2">
                    <label class="lead">Qty On Hand</label>
                </div>
                <div id="qtyText" class="col-md-6">
                    <input class="form-control" type="text" id="qtyTf"/>
                </div>
            </div>
            <div id="unitPriceDiv" class="col-md-12">
                <div id="unitPriceLable" class="col-md-6 col-md-push-2">
                    <label class="lead">Unit Price</label>
                </div>
                <div id="unitPriceText" class="col-md-4">
                    <input class="form-control" type="text" id="unitPriceTf" />
                </div>
            </div>
            <div id="buttonDiv" class="col-md-11 col-md-push-7 form-group">
                <input type="submit" value="Update" class="btn btn-success buttonSize" onclick="updateItem()" />
                <input type="button" value="Cancel" class="btn btn-danger buttonSize"/>
            </div>

        </div>

        <script type="text/javascript">
            function searchItem() {

                if (document.getElementById("itemCodeTf").value) {
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
                                var idTag = xmlDoc.getElementsByTagName("code");
                                var nameTag = xmlDoc.getElementsByTagName("description");
                                var addressTag = xmlDoc.getElementsByTagName("qty");
                                var salaryTag = xmlDoc.getElementsByTagName("unitPrice");

                                //document.getElementById("idTf").valu0 = idTag[0].childNodes[0].nodeValue;
                                document.getElementById("descriptionTf").value = nameTag[0].childNodes[0].nodeValue;
                                document.getElementById("qtyTf").value = addressTag[0].childNodes[0].nodeValue;
                                document.getElementById("unitPriceTf").value = salaryTag[0].childNodes[0].nodeValue;
                            } else {
                                alert("No Such Item");
                                document.getElementById("descriptionTf").value = "";
                                document.getElementById("qtyTf").value = "";
                                document.getElementById("unitPriceTf").value = "";
                            }
                        }

                    };
                    var id = document.getElementById("itemCodeTf").value;
                    //console.log(id+"-"+name+"-"+address)
                    xmlrequest.open("GET", "Item?itemCode=" + id, true);
                    //xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    xmlrequest.send();

                } else {
                    alert("Please Enter The ItemCode you want to delete ");
                }

            }
            ;
            
            function updateItem() {

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
                                alert("Item Updated");
                                document.getElementById("itemCodeTf").value = "";
                                document.getElementById("descriptionTf").value = "";
                                document.getElementById("qtyTf").value = "";
                                document.getElementById("unitPriceTf").value = "";
                            } else if(res===0) {
                                alert("Item Not Update");
                            }else{
                                alert(xmlrequest.responseText);
                            }
                        }

                    }

                };

                var itemCode = document.getElementById("itemCodeTf").value;
                var description = document.getElementById("descriptionTf").value;
                var qty = document.getElementById("qtyTf").value;
                var unitPrice = document.getElementById("unitPriceTf").value;
                //console.log(id+"-"+name+"-"+address)
                xmlrequest.open("PUT", "Item?itemCode=" + itemCode + "&description=" + description + "&qty=" + qty + "&unitPrice=" + unitPrice, true);
               // xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlrequest.send();





            }
            ;
        </script>
    </body>
</html>
