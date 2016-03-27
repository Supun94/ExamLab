<%-- 
    Document   : AddItem
    Created on : Sep 27, 2014, 8:36:57 AM
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
        <form action="./AddItem">
            <div id="mainDiv" class="row col-md-6  " style="margin-left: 100px; margin-top:80px ">
                <div id="header" class="col-md-12 col-md-offset-4 form-group">
                    <h1>Add Item</h1>
                </div>
                <div id="idDiv" class="col-md-12">
                    <div id="idLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Item Code</label>
                    </div>
                    <div id="idText" class="col-md-4">
                        <input class="form-control" type="text" name="itemCode" id="itemCodeTf"/>
                    </div>
                </div>
                <div id="discriptionDiv" class="col-md-12">
                    <div id="discriptionLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Description</label>
                    </div>
                    <div id="descriptionText" class="col-md-6">
                        <input class="form-control" type="text" name="description" id="decTf"/>
                    </div>
                </div>
                <div id="qtyDiv" class="col-md-12">
                    <div id="qtyLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Qty On Hand</label>
                    </div>
                    <div id="qtyText" class="col-md-6">
                        <input id="qtyTf" class="form-control" onkeyup="numbersValidation(id)" type="text" name="qty"/>
                    </div>
                </div>
                <div id="unitPriceDiv" class="col-md-12">
                    <div id="unitPriceLable" class="col-md-6 col-md-push-2">
                        <label class="lead">Unit Price</label>
                    </div>
                    <div id="unitPriceText" class="col-md-4">
                        <input id="unitPriceTf" class="form-control" onkeyup="numbersValidation(id)" type="text" name="unitPrice"/>
                    </div>
                </div>
                <div id="buttonDiv" class="col-md-11 col-md-push-7 form-group">
                    <input type="button" value="Save" class="btn btn-success buttonSize" onclick="addItem()"/>
                    <input type="button" value="Cancel" class="btn btn-danger buttonSize"/>
                </div>
            </div>
        </form>


        <script type="text/javascript">
            function addItem() {

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
                                alert("Item Added");
                                document.getElementById("itemCodeTf").value = "";
                                document.getElementById("decTf").value = "";
                                document.getElementById("qtyTf").value = "";
                                document.getElementById("unitPriceTf").value = "";
                            } else if(res===0) {
                                alert("Item Not Add");
                            }else{
                                alert(xmlrequest.responseText);
                            }
                        }

                    }

                };

                var itemCode = document.getElementById("itemCodeTf").value;
                var description = document.getElementById("decTf").value;
                var qty = document.getElementById("qtyTf").value;
                var unitPrice = document.getElementById("unitPriceTf").value;
                //console.log(id+"-"+name+"-"+address)
                xmlrequest.open("POST", "Item", true);
                xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlrequest.send("itemCode=" + itemCode + "&description=" + description + "&qty=" + qty + "&unitPrice=" + unitPrice);





            }
            ;

        </script>
    </body>
</html>
