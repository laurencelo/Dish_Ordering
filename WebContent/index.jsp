<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.js"
	integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<style>
div.section {
	height: 70vh;
	margin-top: 15vh;
}
</style>
</head>
<body>
	<div class="container">
		<div class="section">
			<div class="level">
				<div class="level-item has-text-centered">
					<h1 class="subtitle is-1">Dish Ordering System</h1>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<button class="button is-primary is-large is-rounded is-outlined"
						id="adminMode">Admin Mode</button>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<button class="button is-primary is-large is-rounded is-outlined"
						id="menu">Menu</button>
				</div>
			</div>
		</div>
	</div>
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