"use strict";
$(document).ready(
		
		$("form").submit((event)=>{
			var dishname = document.forms["regform"]["dishname"].value;
			var dishprice = document.forms["regform"]["dishprice"].value;
			var dishinventory = document.forms["regform"]["dishinventory"].value;
			event.preventDefault();
			$.post("addDish",{submit:"addDish",dishname,dishinventory,dishprice},()=>{
				alert("Add dish successfully!");
				window.location.href ="modifyDish.jsp"
			})
			
		})
		
);