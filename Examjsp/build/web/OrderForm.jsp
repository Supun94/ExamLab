<%-- 
    Document   : OrderForm
    Created on : Sep 27, 2014, 8:48:59 AM
    Author     : Demo
--%>



<%@page import="com.thogakade.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>

        <link href="./static/css/bootstrap.css" rel="stylesheet"/>
        <link href="./static/css/bootstrap-theme.css" rel="stylesheet"/>
        <link rel="stylesheet" href='./static/css/MyStyleSheet.css'/>
    </head>
    <body >
        <script type="text/javascript" src="./static/js/JQ.js" >

        </script>
        <script type="text/javascript" src="./static/js/models.js" >

        </script>
        <script type="text/javascript" src="./static/js/Js.js" ></script>
        <form>
            <div id='maindiv' class="row col-md-12 " style="width: 100%">
                <div id="titleDiv" class="col-md-12  col-md-offset-3 ">
                    <h1>Order Forme</h1>
                </div>
                <div id="idDiv" class=" form-group col-md-12">
                    <div id="orderIdDiv" class="col-md-2  col-md-offset-1  ">
                        <label>OrderId</label> 
                        <input type="text" id="orderIdText" name="orderId" class="form-control"/>
                    </div>
                    <div id="paymentIdDiv" class="col-md-2 col-md-offset-1">
                        <label> PaymentId </label>
                        <input type="text" class="form-control" />
                    </div>
                    <div id="dateDiv"  class="col-md-2 col-md-offset-1 ">
                        <label>Date</label>
                        <input type="date" name="date" id="dateText"  class="form-control" />
                    </div>
                </div>
                <div id="customerDiv" class="form-group col-md-12">
                    <div id="selectCustomerDiv" class="col-md-6 col-sm-offset-1">
                        <div id="fonts"><label  class="col-md-5">Select Customer</label></div>
                        <div class="col-md-7 " >
                            <select id ='customer' onchange="selectCustomer()" class="form-control" >

                            </select>
                        </div>

                        <input type="hidden" name="customerId" id="custId"/>
                    </div>
                </div>
                <div id="itemdiv" class="form-group col-md-12 ">
                    <div id="selectItemDiv" class="col-md-6 col-md-offset-1">
                        <div id="fonts"><label class="col-md-5">Select Item</label></div id="fonts">
                        <div class="col-md-7" >
                            <select id ='item' onchange="selectItem()"class="form-control" ></select>
                        </div>

                    </div>
                    <div id="priceDiv" class="col-md-5 allignLeft">
                        <label id="fonts"   class="col-md-4">Item Price</label>
                        <div class="col-md-5">
                            <input type="text" id="priceText" class="form-control"/>
                        </div>
                        <input type="hidden" id="prices" name="priceList" />
                    </div>

                </div>
                <div id="qtyDiv" class="form-group col-md-12 ">
                    <div id="sellingQtyDiv" class="col-md-6 col-md-offset-1">
                        <label id="fonts" class="col-md-5">Qty</label>
                        <div class="col-md-7">
                            <input id="qtyText" onkeyup="numbersValidation(id)" type="text" class="form-control"/>
                        </div>
                        <input id="qtyCount" type="hidden" name="qtyList"/>
                    </div>
                    <div id="availableQtydiv"   class="col-md-4 allignLeft ">
                        <label id="fonts" class="allignRight col-md-6" >Available Qty</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" id="availableQtyText"/>
                        </div>
                    </div>
                </div>
                <div id="discDiv" class="form-group col-md-12">
                    <div id="discountDiv" class="col-md-6 col-md-offset-1">
                        <label id="fonts" class="col-md-5">Discount</label>
                        <div class="col-md-7">
                            <input id="discountText" type="text" onkeyup="discountValidate(id)" class="form-control"/>
                        </div>
                    </div>
                </div>
                <div id="buttonDiv" class="form-group col-md-6 allignRight">
                    <input  type="hidden" name="itemCode" id="itemCodes"/>
                    <input type="button" value=" Add " class="btn btn-info" onclick="addOrderDetail()"/>
                    <input type="button" value="Remove" class="btn btn-danger"/>
                </div>
                <div id="tableDiv" class="form-group  col-md-8 col-md-offset-1 color2">
                    <table class="table table-bordered col-md-12 marginTop" id="table">
                        <tbody>
                            <tr class="active " >
                                <td class="col-md-2 allignCenter" id="itemCode">
                                    Item Code
                                </td>
                                <td class="allignCenter" >
                                    Description
                                </td>
                                <td class="allignCenter">
                                    Price
                                </td>
                                <td class="allignCenter">
                                    Qty
                                </td>
                                <td class="allignCenter">
                                    Discount
                                </td>

                            </tr>

                        </tbody>
                    </table>
                </div>
                <div id="paymentDiv" class="col-md-12 ">
                    <div id="totalDiv" class="form-group col-md-10 allignRight">
                        Total Amount
                        <input type="text" id="totalText" />
                    </div>
                    <div id="receavedDiv"  class="form-group col-md-10 allignRight">
                        Received Amount
                        <input id="receivedText" type="text" onkeyup="numbersValidation(id)"/>
                    </div>
                    <div id="balanceDiv"   class="form-group col-md-10 allignRight">
                        Balance Amount
                        <input type="text" readonly="readonly" id="balanceText"/>
                    </div>
                </div>
                <div id="butBottom" class="col-md-12 col-md-offset-9">
                    <input class="btn btn-success" type="button" value="Save" onclick="saveOrder()" />
                    <input class="btn btn-danger" type="button" value="Cancel"/>
                </div>
            </div>
        </form>
        <script type="text/javascript">

            window.onload = loadCustomer(), loadItem();
            var itemList = [];
            var customerList = [];
            function loadItem() {
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
                            var qtyTag = xmlDoc.getElementsByTagName("qty");
                            var unitPriceTag = xmlDoc.getElementsByTagName("unitPrice");


                            //document.getElementById("idTf").valu0 = idTag[0].childNodes[0].nodeValue;


                            for (i = 0; i < detailTag.length; i++) {
                                document.getElementById("item").innerHTML += "<option>" + idTag[i].childNodes[0].nodeValue + "-" + nameTag[i].childNodes[0].nodeValue + "</option>";
                                var a = new Item(idTag[i].childNodes[0].nodeValue, nameTag[i].childNodes[0].nodeValue, qtyTag[i].childNodes[0].nodeValue, unitPriceTag[i].childNodes[0].nodeValue);
                                itemList.push(a);
                            }



                            // document.getElementById("addressTf").value = addressTag[0].childNodes[0].nodeValue;
                            // document.getElementById("salaryTf").value = salaryTag[0].childNodes[0].nodeValue;
                        } else {
//                            alert("No Such Customer");
//                            document.getElementById("nameTf").value = "";
//                            document.getElementById("addressTf").value = "";
//                            document.getElementById("salaryTf").value = "";
                        }
                    }

                }
                ;

                //console.log(id+"-"+name+"-"+address)
                xmlrequest.open("GET", "Item", true);
                //xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlrequest.send();

            }
            ;


            function loadCustomer() {
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
                            for (i = 0; i < detailTag.length; i++) {
                                document.getElementById("customer").innerHTML += "<option>" + idTag[i].childNodes[0].nodeValue + "-" + nameTag[i].childNodes[0].nodeValue + "</option>";
                                var customer = new Customer(idTag[i].childNodes[0].nodeValue, nameTag[i].childNodes[0].nodeValue, addressTag[i].childNodes[0].nodeValue, salaryTag[i].childNodes[0].nodeValue);
                                customerList.push(customer)
                            }

                            // document.getElementById("addressTf").value = addressTag[0].childNodes[0].nodeValue;
                            // document.getElementById("salaryTf").value = salaryTag[0].childNodes[0].nodeValue;
                        } else {
//                            alert("No Such Customer");
//                            document.getElementById("nameTf").value = "";
//                            document.getElementById("addressTf").value = "";
//                            document.getElementById("salaryTf").value = "";
                        }
                    }

                }
                ;

                //console.log(id+"-"+name+"-"+address)
                xmlrequest.open("GET", "Customer", true);
                //xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlrequest.send();


            }
            ;

            function selectItem() {
                var selectItem = document.getElementById("item").value.split("-")[0];
                for (i = 0; i < itemList.length; i++) {
                    if (selectItem === itemList[i].itemCode) {
                        document.getElementById("priceText").value = itemList[i].unitPrice;
                        document.getElementById("availableQtyText").value = itemList[i].qtyOnHand;
                    }
                }

            }
            ;


            function addOrderDetail() {
                var isExist = false;

                var table = document.getElementById("table");



                var selectItemCode = document.getElementById("item").value.split("-")[0];
                var selectItemName = document.getElementById("item").value.split("-")[1];

                for (i = 1; i < table.rows.length; i++) {
                    var code = table.rows[i].cells[0].innerHTML;

                    if (selectItemCode === code.substring(1)) {
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {
                    document.getElementById('table').innerHTML += "<tr class='active' ><td class=col-md-2 allignCenter > " + selectItemCode + "</td> <td class=col-md-2 allignCenter> " + selectItemName + "</td> <td class=col-md-2 allignCenter> " + document.getElementById('priceText').value + "</td> <td class=col-md-2 allignCenter> " + document.getElementById('qtyText').value + "</td> <td class=col-md-2 allignCenter> " + document.getElementById('discountText').value + "</td>  </tr>";
                    for (i = 0; i < itemList.length; i++) {
                        if (selectItemCode === itemList[i].itemCode) {
                            var newQty = itemList[i].qtyOnHand - parseInt(document.getElementById("qtyText").value);
                            itemList[i].qtyOnHand = newQty;
                            document.getElementById("availableQtyText").value = newQty;
                            break;

                        }
                    }
                    var total=document.getElementById("totalText").value;
                    if(total){
                      document.getElementById("totalText").value=parseFloat(document.getElementById("totalText").value)+ (parseInt(document.getElementById("qtyText").value)*parseFloat(document.getElementById("priceText").value));  
                    }else{
                       document.getElementById("totalText").value= parseInt(document.getElementById("qtyText").value)*parseFloat(document.getElementById("priceText").value)
                    }
                    document.getElementById("qtyText").value = "";
                    document.getElementById("discountText").value = "";

                } else {
                    alert("Item Already Exist");
                }




                // document.getElementById("qtyCount").value += document.getElementById("qtyText").value + ",";
                // document.getElementById("prices").value += document.getElementById("priceText").value + ",";
            }
            ;

            function saveOrder() {

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
                                alert("Order Saved");
                                var table = document.getElementById('tableDiv');
                                table.innerHTML = "<table class='table table-bordered col-md-12 marginTop' id='table'>" +
                                        " <tbody>" +
                                        "<tr class='active ' >" +
                                        "<td class='col-md-2 allignCenter' id='itemCode'>" +
                                        "Item Code" +
                                        "</td>" +
                                        "<td class='allignCenter' >" +
                                        "Description" +
                                        "</td>" +
                                        "<td class='allignCenter'>" +
                                        "Price" +
                                        "</td>" +
                                        "<td class='allignCenter'>" +
                                        "Qty" +
                                        "</td>" +
                                        "<td class='allignCenter'>" +
                                        "Discount" +
                                        "</td>" +
                                        "</tr>" +
                                        "</tbody>" +
                                        "</table>";

                            } else {
                                alert("Order Not Save");
                            }
                        }

                    }

                };

                var table = document.getElementById('table');
                var orderId = document.getElementById("orderIdText").value;
                var customerId = document.getElementById("customer").value.split("-")[0];
                var date = document.getElementById("dateText").value;
                var itemCodes = "";
                var qty = "";
                var unitPrice = "";

                for (i = 1; i < table.rows.length; i++) {
                    itemCodes += table.rows[i].cells[0].innerHTML.substring(1) + "-";
                    qty += table.rows[i].cells[3].innerHTML.substring(1) + "-";
                    unitPrice += table.rows[i].cells[2].innerHTML.substring(1) + "-";
                }

                //console.log(id+"-"+name+"-"+address)
                xmlrequest.open("POST", "Order", true);
                xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlrequest.send("orderId=" + orderId + "&customerId=" + customerId + "&date=" + date + "&itemCode=" + itemCodes + "&unitPrice=" + unitPrice + "&qty=" + qty);





            }
            ;




        </script>
    </body>
</html>

