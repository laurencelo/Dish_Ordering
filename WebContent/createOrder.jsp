<%@page import="dao.UserDaoImpl"%>
<%@page import="java.util.*"%>
<%@page import="model.Dish"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
</head>
<body>
<%

            UserDaoImpl userDaoImpl=new UserDaoImpl();
            ArrayList<Dish> dl=userDaoImpl.getDishList();
			out.print("<div><h1>Menu</h1></div>");
			out.print(
					"<table><thead><tr><th>Dish name</th><th>Price</th><th>Add to Order</th></tr></thead><tbody id=\"menuTable\" >");
			for (int i = 0; i < dl.size(); i++) {
				out.println("<tr>");
				out.print("<td>" + dl.get(i).getDishName() + "</td>");
				out.print("<td>" + dl.get(i).getPrice() + "</td>");
				out.println("</tr>");
			}
			out.print("</table>");
%>
<script type="text/javascript" src="createOrder.js" ></script>

</body>
</html>