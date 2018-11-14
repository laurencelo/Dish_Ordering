$(document).ready(()=>{
        [...document.getElementsByClassName("addDish")].forEach((dish)=>{
            dish.addEventListener("click",()=>{
                $.get("createOrder",{addDish:true,dishName:dish.innerHTML},(data,status)=>{
                    console.log(data)
                    $("#orderTable").append(data);
                })
            })
        });
        
        $("#checkoutOrder").click(()=>{
        	$.post("createOrder",(data)=>{
                console.log(data);
                $("#orderTable").append("<tr><td>Total:</td><td>"+data+"</td></tr>");
                $("#checkoutOrder").remove();
                $("#menuTable").remove();
            });
            $("body").append("<div><button id=\"swipeCard\">Swipe Credit Card</button></div>");
            $("#swipeCard").click(()=>{
                $.get("createOrder",{swipeCreditCard:true},(data,status)=>{
                    alert(data);
                    window.location.href = "index.jsp";
                })
            });
        });
        
    // setTimeout(()=>{console.log([...document.getElementsByClassName("addDish")]);},1000)
    
    // [0].innerHTML
});