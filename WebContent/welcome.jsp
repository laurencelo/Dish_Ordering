<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.section {
	height: 70vh;
	margin-top: 15vh;
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<%
		if (session != null) {
			if (session.getAttribute("userId") == null) {
				response.sendRedirect("login.jsp");
			}
		}
	%>
	<div class="container">
		<div class="section">
			<div class="level">
				<div class="level-item has-text-centered">
					<h1 class="subtitle is-1">Administrator Mode</h1>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<button class="button is-link is-large is-rounded is-outlined"
						id=addDish onclick="window.location.href='addDish.jsp'">Add
						Dish</button>

				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">

					<button class="button is-link is-large is-rounded is-outlined"
						id=modifyDish onclick="window.location.href='modifyDish.jsp'">Modify
						Dish</button>

				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<button class="button is-link is-large is-rounded is-outlined"
						id=removeDish>Remove Dish</button>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">

					<button class="button is-link is-large is-rounded is-outlined"
						id=cancelOrder onclick="window.location.href='cancelOrder.jsp'">
						Cancel Order</button>

				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<a class="button is-link is-large is-rounded is-outlined"
						href="logout.jsp">logout</a>
				</div>
			</div>
		</div>
	</div>
	</div>

	<script>
	$(document).ready(()=>{
        $("#removeDish").click(()=>{
		window.location.href='removeDish.jsp';
	});
	});
	</script>
</body>
</html>