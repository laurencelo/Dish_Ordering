<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, td, th{
border:1px solid black;
border-style: ridge;
}
table{
border-collapse: collapse;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cancel Order</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
</head>
<body>
<h1> Cancel Order </h1>
<div id="cancelTable"></div>
<button> submit</button>

	<a href="welcome.jsp">return</a>
	<a href="logout.jsp">logout</a>
<script type="text/javascript" src="cancelOrder.js" ></script>
</body>
</html>