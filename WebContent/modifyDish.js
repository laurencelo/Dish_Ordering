$(document).ready(function() {

//	$(".modifyDish").click(()=>{
//    	var dishname = $('#dishName').text();
//        var dishPrice = $('#dishPrice').text();
//        var dishInventory = $('#dishInventory').text();   
////        alert(dishname);
//        $.get("modifyDish",{dname: dishname, dprice: dishPrice, dInventory: dishInventory},(data,status)=>{
//            console.log(data)
//            window.location.href = "modifyDish.jsp";
//        })
//
//    });
	var dishname = $('#dishName').text();
  var dishPrice = $('#dishPrice').text();
  var dishInventory = $('#dishInventory').text(); 
	[...document.getElementsByClassName("modifyDish")].forEach((dish)=>{
        dish.addEventListener("click",()=>{
        	$.get("modifyDish",{dname: dishname, dprice: dishPrice, dInventory: dishInventory},(data,status)=>{
                console.log(data)
                window.location.href = "modifyDish.jsp";
            })
        })
    });
    // setTimeout(()=>{console.log([...document.getElementsByClassName("addDish")]);},1000)
    
    // [0].innerHTML
});