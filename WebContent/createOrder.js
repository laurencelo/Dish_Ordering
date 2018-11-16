$(document).ready(()=>{
	    $("#checkoutOrder").hide();
        [...document.getElementsByClassName("addDish")].forEach((dish)=>{
            dish.addEventListener("click",()=>{
                $.get("createOrder",{addDish:true,dishName:dish.innerHTML},(data,status)=>{
                    $("#orderTable").empty().append(data);
                });
                $("#checkoutOrder").show();
            })
        });
        
        $("#checkoutOrder").click(()=>{
        	if(document.getElementById("#rowTotal")==null){
	        	$.post("createOrder",(data)=>{
	        		$("#orderTable").append("<tr id=\"rowTotal\"><td>Total:</td><td>"+data+"</td></tr>");
	            });
        	}
        	else{
        		//show
        		$("#rowTotal").toggle();
        	}
        	//hide
            $("#checkoutOrder").toggle();
            $("#menuTable").toggle();
            $("#returnBtn").toggle();
            //show
            $("#swipeCard").toggle();
    		$("#backBtn").toggle();
        });
        
        $("#swipeCard").click(()=>{
            $.get("createOrder",{swipeCreditCard:true},(data,status)=>{
                alert(data);
                window.location.href = "index.jsp";
            })
        });
        
        $("#backBtn").click(()=>{
        	//show
        	$("#checkoutOrder").toggle();
            $("#menuTable").toggle();
            $("#returnBtn").toggle();
            //hide
            $("#rowTotal").toggle();
    		$("#swipeCard").toggle();
    		$("#backBtn").toggle();
        })
        
        $("#returnBtn").click(()=>{
        	$.get("createOrder",{resetOrder:true},()=>{
                window.location.href = "index.jsp";
            })
        })
        
        $("#swipeCard").display = "none";
        $("#backBtn").display = "none";
        
    // setTimeout(()=>{console.log([...document.getElementsByClassName("addDish")]);},1000)
    
    // [0].innerHTML
});