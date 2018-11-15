function regValidate() {

	var dishname = document.forms["regform"]["dishname"].value;
	var dishprice = document.forms["regform"]["dishprice"].value;
	var dishinventory = document.forms["regform"]["dishinventory"].value;
	
	if (dishname == "") {
        alert("dish name must be filled out");
        document.forms["regform"]["dishname"].focus();
        return false;
    }else if (dishprice== "") {
        alert("dish price must be filled out");
        document.forms["regform"]["dishprice"].focus();
        return false;
    }else if (dishinventory == "") {
        alert("dish inventory must be filled out");
        document.forms["regform"]["dishinventory"].focus();
        return false;
    }
}
