<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.UserDaoImpl"%>
<%@page import="java.util.*"%>
<%@page import="model.Dish"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dish Page</title>
</head>
<body>
<h1> ${message}</h1>
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
					"<table><thead><tr><th>Dish name</th><th>Price</th><th>Inventory</th></tr></thead><tbody id=\"menuTable\" >");
			for (int i = 0; i < dl.size(); i++) {
				out.println("<tr>");
				
				out.print("<td id=\"dishName\">" + dl.get(i).getDishName() + "</td>");
				out.print("<td id=\"dishPrice\">" + dl.get(i).getPrice() + "</td>");
				out.print("<td id=\"dishInventory\">" + dl.get(i).getInventory() + "</td>");
				out.print("<td><button class=\"modifyDish\">edit</button></td>");
				out.println("</tr>");
			}
			out.print("</table>");
%>
<script type="text/javascript" src="modifyDish.js" ></script>

<button onclick="window.location.href='addDish.jsp'"> Add Dish</button>
<button onclick="window.location.href='welcome.jsp'"> Admin Page</button>

	<a href="logout.jsp">logout</a>

</body>
</html>