/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Item(itemCode, description, qtyOnHand, unitPrice) {
    this.itemCode = itemCode;
    this.description = description;
    this.qtyOnHand = qtyOnHand;
    this.unitPrice = unitPrice;
}
Item.prototype.setItemCode = function(itemCode) {
    Item.itemCode = itemCode;
};
Item.prototype.getItemCode = function() {
    return itemCode;
};
Item.prototype.setDescription = function(description) {
    Item.description = description;
};
Item.prototype.getDescriptio = function() {
    return Item.description;
};
Item.prototype.setQtyOnHand = function(qtyOnHand) {
    Item.qtyOnHand = qtyOnHand;
};
Item.prototype.getQtyOnHand = function() {
    return Item.qtyOnHand;
};
Item.prototype.setUnitPrice = function(unitPrice) {
    Item.unitPrice = unitPrice;
};
Item.prototype.getUnitPrice = function() {
    return Item.unitPrice;
};



function Customer(customerId, name, address, salary) {
    this.customerId = customerId;
    this.name = name;
    this.adress = address;
    this.salary = salary;
}

Customer.prototype.setCustomerId = function(customerId) {
    Customer.customerId = customerId;
};
Customer.prototype.getCustomerId = function() {
    return Customer.customerId;
};
Customer.prototype.setName = function(name) {
    Customer.name = name;
};
Customer.prototype.getName = function() {
    return Customer.name;
};
Customer.prototype.setAddress = function(address) {
    Customer.address = address;
};
Customer.prototype.getAddress = function() {
    return Customer.address;
};
Customer.prototype.setSalary = function(salary) {
    Customer.salary = salary;
};
Customer.prototype.getSalary = function() {
    return Customer.salary;
};



function Order(orderId, customerId, date) {
    this.orderId = orderId;
    this.customerId = customerId;
    this.date = date;
}

Order.prototype.setOrderId = function(OrderId) {
    Order.orderId = OrderId;
};
Order.prototype.getOrderId = function() {
    return Order.orderId;
};
Order.prototype.setCustomerId = function(customerId) {
    Order.customerId = customerId;
};
Order.prototype.getCustomerId = function() {
    return Order.customerId;
};
Order.prototype.setDate = function(date) {
    Order.date = date;
};
Order.prototype.getDate = function() {
    return Order.date;
};


function OrderDetail(orderId, itemCode, qty, unitPrice, discount) {
    this.orderId = orderId;
    this.itemCode = itemCode;
    this.qty = qty;
    this.unitPrice = unitPrice;
    this.discount = discount;
}

OrderDetail.prototype.setOrderId = function(OrderId) {
    OrderDetail.orderId = OrderId;
};

OrderDetail.prototype.getOrderId = function() {
    return OrderDetail.orderId;
};

OrderDetail.prototype.setItemCode = function(itemCode) {
    OrderDetail.itemCode = itemCode;
};

OrderDetail.prototype.getItemCode = function() {
    return OrderDetail.itemCode;
};

OrderDetail.prototype.setQty = function(qty) {
    OrderDetail.qty = qty;
};

OrderDetail.prototype.getQty = function() {
    return OrderDetail.qty;
};

OrderDetail.prototype.setUnitPrice = function(unitPrice) {
    OrderDetail.unitPrice = unitPrice;
};

OrderDetail.prototype.getUnitPrice = function() {
    return OrderDetail.unitPrice;
};

OrderDetail.prototype.setDiscount = function(discount) {
    OrderDetail.discount = discount;
};

OrderDetail.prototype.getDiscount = function() {
    return OrderDetail.discount;

};



