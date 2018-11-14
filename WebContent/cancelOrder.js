let listenToButtons=()=>{
    [...document.querySelectorAll("button.cancelButton")].forEach((button)=>{
        button.addEventListener("click",(event)=>{
            if(confirm("Are you sure to delete Order "+parseInt(event.target.parentNode.parentNode.innerText)+"?")){
            $.get("cancelOrder",{orderID:parseInt(event.target.parentNode.parentNode.innerText)},(data)=>{
                $("#cancelTable").empty().append(data).ready(()=>{
                listenToButtons();
                alert("Order cancelled Successfully!");
                });
                            })}
        });
    });
}

let init=()=>{ 
    $.get("cancelOrder",{init:true},(data)=>{
    $("#cancelTable").empty().append(data);
    listenToButtons();
});}


$(document).ready(()=>{
    init();
 
});