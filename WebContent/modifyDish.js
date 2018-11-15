let listenToButtons = () => {
  if (document.getElementsByTagName("tbody")[0] !== undefined) {
    document.getElementsByTagName("tbody")[0].childNodes.forEach(tr => {
      modifyObj.push({ originalName: tr.childNodes[0].firstChild.value });
    });
    [...document.getElementsByClassName("modifyButton")].forEach(dish => {
      dish.addEventListener("click", event => {
        document
          .getElementsByTagName("tbody")[0]
          .childNodes.forEach((tr, index) => {
            if (event.target.parentNode.parentNode === tr) {
              modifyObj[index]["modifiedName"] =
                tr.childNodes[0].childNodes[0].value;
              modifyObj[index]["modifiedInventory"] =
                tr.childNodes[1].childNodes[0].value;
              modifyObj[index]["modifiedPrice"] =
                tr.childNodes[2].childNodes[0].value;
              $.get(
                "modifyDish",
                {
                  modification: true,
                  originalName: modifyObj[index]["originalName"],
                  modifiedName: modifyObj[index]["modifiedName"],
                  modifiedInventory: modifyObj[index]["modifiedInventory"],
                  modifiedPrice: modifyObj[index]["modifiedPrice"]
                },
                data => {
                  $("#modifyDishList")
                    .empty()
                    .append(data);
                  modifyObj = [];
                  listenToButtons();
                  alert("dish modified successfully!");
                }
              );
            }
          });
      });
    });
  }
};

$(document).ready(function() {
  modifyObj = [];

  $.get("modifyDish", { init: true }, data => {
    $("#modifyDishList")
      .empty()
      .append(data);
    listenToButtons();
  });
});
