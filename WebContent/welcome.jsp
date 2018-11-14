<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h1>${message}</h1>
	<div>
		<button onclick="window.location.href='cancelOrder.jsp'">
			Cancel Order
		</button>
	</div>
	<br>
	<div>
		<button onclick="window.location.href='addDish.jsp'">Add Dish</button>
	</div>
	<br>
	<div>
		<button id=removeDish>Remove Dish</button>
	</div>
	<br>
	<div>
		<button>Modify Dish</button>
	</div>
	<br>
	<a href="logout.jsp">logout</a>
	<script>
	$(document).ready(()=>{
        $("#removeDish").click(()=>{
		window.location.href='removeDish.jsp';
	});
	});
	</script>
</body>
</html>