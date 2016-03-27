/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function numbersValidation (val){
   var qty=$("#"+name+"").val();
    var carrtId=document.getElementById(""+name+"");
    console.log("Carrat    "+carrtId.selectionEnd);
    var position=carrtId.selectionEnd;
    console.log(qty);
    if(!(qty.match('[0-9]') && !qty.match('[A-Za-z]'))){
        carrtId.value=qty.substring(0,position-1)+qty.substring(position);
    }else if(position>=3){
        carrtId.value=qty.substring(0,position-1)+qty.substring(position);
    }
}

function discountValidate(name){
    var qty=$("#"+name+"").val();
    var carrtId=document.getElementById(""+name+"");
    console.log("Carrat    "+carrtId.selectionEnd);
    var position=carrtId.selectionEnd;
    console.log(qty);
    if(!(qty.match('[0-9]') && !qty.match('[A-Za-z]'))){
        carrtId.value=qty.substring(0,position-1)+qty.substring(position);
    }else if(position>=3){
        carrtId.value=qty.substring(0,position-1)+qty.substring(position);
    }
}

function setPrice(){

}

function TextValidation (name){
    var qty=$("#"+name+"").val();
    var carrtId=document.getElementById(""+name+"");
    console.log("Carrat    "+carrtId.selectionEnd);
    var position=carrtId.selectionEnd;
    console.log(qty);
    if(!(!qty.match('[0-9]') && qty.match('[A-Za-z]'))){
        carrtId.value=qty.substring(0,position-1)+qty.substring(position);
    }
}
