$(document).ready(()=>{
	$.get("removeDish",{init:true},(data)=>{
		$("#dishList").append(data);
		[...document.getElementsByClassName("dishBtn")].forEach((dish)=>{
			dish.addEventListener("click",(event)=>{
				if(confirm("Remove this dish?")){
					// Click on okay
					$.get("removeDish",{dishName:dish.innerHTML},function(data){
						console.log(data);
						$(event.target).remove();
					})
				}
			})
		});
	});
	
});