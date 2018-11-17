<%@page import="dao.UserDaoImpl"%>
<%@page import="java.util.*"%>
<%@page import="model.Dish"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<meta charset="ISO-8859-1">
<title>Create Order</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="level">
			<div class="level-item has-text-centered">
				<h1 class="subtitle is-1">Create Your Order</h1>
			</div>
		</div>
		<%
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			ArrayList<Dish> dl = userDaoImpl.getDishList().getList();
			out.print("<div  id=\"menuTable\"><h1>Menu</h1>");
			out.print(
					"<table class=\"table table is-bordered is-striped is-narrow is-hoverable is-fullwidth \"><thead><tr><th>Dish Name</th><th>Price</th></tr></thead><tbody >");
			for (int i = 0; i < dl.size(); i++) {
				out.println("<tr>");
				out.print("<td><button class=\"addDish button is-success is-small is-rounded is-outlined\">"
						+ dl.get(i).getDishName() + "</button></td>");
				out.print("<td>$" + dl.get(i).getPrice() + "</td>");
				out.println("</tr>");
			}
			out.print("</table></div>");
			out.println("<br>");
			out.println("<div><h1>Order</h1></div>");
			out.println("<div>");
			out.println("<table class=\" table is-bordered is-striped is-narrow is-hoverable is-fullwidth \">");
			out.println("<thead><tr>");
			out.println("<th>Dish Name </th><th>Price </th>");
			out.println(
					"</tr></thead><tbody id=\"orderTable\"></tbody></table></div><button class=\" button is-link is-medium is-rounded is-outlined \" id=\"checkoutOrder\">Checkout Order</button><br>");
			out.println(
					"<div><button class=\" button is-link is-medium is-rounded is-outlined \" id=\"returnBtn\">Home Page</button></div>");
			out.println(
					"<div><button class=\" button is-link is-medium is-rounded is-outlined \" id=\"swipeCard\" style=\"display: none;\">Swipe Card</button></div>");
			out.print(
					"<div><button class=\" button is-link is-medium is-rounded is-outlined \" id=\"backBtn\" style=\"display: none;\">Back To Cart</button></div>");
		%>
		<script type="text/javascript" src="createOrder.js"></script>
	</div>
</body>
</html>