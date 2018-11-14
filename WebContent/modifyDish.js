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
		[...document.getElementsByClassName("modifyDish")].forEach((dish)=>{
	        dish.addEventListener("click",(event)=>{
	        	var dishname = event.target.parentNode.parentNode.childNodes[1].innerHTML;
	      	  	var dishPrice = event.target.parentNode.parentNode.childNodes[2].innerHTML;
	      	  	var dishInventory = event.target.parentNode.parentNode.childNodes[3].innerHTML; 
	        	console.log(dishname, dishPrice, dishInventory)
	        	$.get("modifyDish",{dname: dishname, dprice: dishPrice, dInventory: dishInventory},(data,status)=>{
//	                console.log(data)
	                window.location.href = "modifyDish.jsp";
	            })
	        })
	    });
    // setTimeout(()=>{console.log([...document.getElementsByClassName("addDish")]);},1000)
    
    // [0].innerHTML
});