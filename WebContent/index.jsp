<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.js"
	integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<button id="adminMode">Admin Mode</button>
	<button id="menu">Menu</button>
	<%-- <form action="createOrder" method="GET">
		<button type="submit">Menu</button>
	</form> --%>
	<script>
	$(document).ready(()=>{
        $("#adminMode").click(()=>{
		window.location.href='login.jsp';
	});
		$("#menu").click(()=>{
		window.location.href='createOrder.jsp';
	});


	});
	
	</script>
</body>
</html>