<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Dish</title>

</head>
<body>
<form name="regform" action="dishController" method="post" onsubmit="return regValidate()">
	<br>${message}<br>
	
	<%
		if (session != null) {
			if (session.getAttribute("userId") != null) {				
				out.println("Dish Name: <input type=\"text\" name=\"dishname\"> <br>");
				out.println("Dish Price: <input type=\"text\" name=\"dishprice\"> <br>");
				out.println("Dish Inventory: <input type=\"text\" name=\"dishinventory\"> <br>");	
				out.println("<div id=\"password_error\"></div><br>");
				out.println("<input type=\"submit\" name=\"submit\" value=\"addDish\" >");
				out.println("<input type=\"reset\" name=\"reset\">");
			} else {
				out.println("<div>Please log in first</div>");
			}
		}
	%>

	

	
	</form>
	<a href="welcome.jsp">return</a>
	
</body>
</html>