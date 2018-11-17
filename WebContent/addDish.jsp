<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<script type="text/javascript" src="addDishValidate.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Dish</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
	
</script>
<style>
div.section {
	height: 50vh;
	margin-top: 25vh;
}
</style>
</head>
<body>
	<div class="container">
		<div class="section">
			<div class="level">
				<div class="level-item has-text-centered">
					<h1 class="subtitle is-1">Add Dish</h1>
				</div>
			</div>
			<form name="regform" action="addDish" method="post"
				onsubmit="return regValidate()">

				<%
					if (session != null) {
						if (session.getAttribute("userId") != null) {
							out.println("<div class=\"level\">"
									+ "<div class=\"level-item has-text-centered\">Dish Name: <input class=\"input is-success\" type=\"text\" name=\"dishname\"> </div>");
							out.println(
									"<div class=\"level-item has-text-centered\">Dish Price: <input class=\"input is-success\" step=\"0.01\" type=\"number\" name=\"dishprice\"></div>");
							out.println(
									"<div class=\"level-item has-text-centered\">Dish Inventory: <input class=\"input is-success\" type=\"number\" name=\"dishinventory\"></div></div>");
							out.println(
									"<div class=\"level\"><div class=\"level-item has-text-centered\"><input  class=\"button is-primary is-medium is-rounded is-outlined\" type=\"submit\" name=\"submit\" value=\"Add Dish\" >");
						} else {
							out.println("<div>Please log in first</div>");
						}
					}
				%>




			</form>
			<div class="level">
				<div class="level-item has-text-centered">
					<a class="button is-link is-medium is-rounded is-outlined"
						href="welcome.jsp">return</a>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="addDish.js"></script>
	</div>
</body>
</html>