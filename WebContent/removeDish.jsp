<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Remove Dish</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="level">
		<div class="level-item has-text-centered">
			<h1 class="subtitle is-1">Remove Dish</h1>
		</div>
	</div>


	<%
		if (session != null) {
			if (session.getAttribute("userId") != null) {
				out.print("<!DOCTYPE html>");
				out.print("<html>");
				out.println("<head>");
				out.println("<title>Remove Dish</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<div class=\"container\">");
				out.print(
						"<div class=\"level\"><div class=\"level-item has-text-centered\"><div>Choose a dish to remove:</div></div></div>");
				out.println("<div class=\"level\">");
				out.println("<div class=\"level-item has-text-centered\">");
				out.print("<br>");
				out.print("<div id=\"dishList\"></div>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
				out.println("</body>");
			} else {
				out.println("<div class=\"container\">Please log in first</div>");
			}
		}
	%>
	<div class="level">
		<div class="level-item has-text-centered">
			<a class="button is-link is-medium is-rounded is-outlined"
				href="welcome.jsp">Return</a>
		</div>
	</div>

	<script type="text/javascript" src="removeDish.js"></script>
</body>
</html>