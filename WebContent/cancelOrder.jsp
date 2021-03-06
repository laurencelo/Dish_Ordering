<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cancel Order</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<div class="section">
			<div class="level">
				<div class="level-item has-text-centered">
					<h1  class="subtitle is-1">Cancel Order</h1>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<div id="cancelTable"></div>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<a class="button is-link is-medium is-rounded is-outlined" href="welcome.jsp">Return</a> <a class="button is-link is-medium is-rounded is-outlined" href="logout.jsp">Logout</a>
				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript" src="cancelOrder.js"></script>
</body>
</html>