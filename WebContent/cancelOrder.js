$(document).ready(()=>{
    $.get("cancelOrder",{init:true},(data)=>{
        $("#cancelTable").append(data);
    })
});