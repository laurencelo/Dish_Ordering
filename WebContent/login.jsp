<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
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
<title>Login Page</title>
</head>
<body>

	<div class="container">
		<div class="section">
			<div class="level">
				<div class="level-item has-text-centered">
					<h1 class="subtitle is-1">Login Page</h1>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<%
						out.print("Hello!");
					%>
					<%=new java.util.Date()%>
					<%!int number1, number2;%>
					<%
						if (session != null) {
							if (session.getAttribute("userId") != null) {
								response.sendRedirect("welcome.jsp");
							}
						}
						DbManager db = new DbManager();
						Connection conn = (Connection) db.getConnection();
						if (conn == null)
							out.print("failed");
						else
							out.print("succeeded");
					%>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<form name="loginform" action="Controller" method="post"
						onsubmit="return loginValidate()">
						<br> ${message}<br> ${successMessage}<br>

						<div class="level">
							<div class="level-item has-text-centered">
								User Id: <input class="input info" type="number" name="userId"
									id="username"> Password: <input class="input info"
									type="password" name="password" id="password">
							</div>
						</div>

						<input class="button is-primary is-medium is-rounded is-outlined"
							type="submit" name="submit" value="login"><br>
					</form>
				</div>
			</div>
			<div class="level">
				<div class="level-item has-text-centered">
					<a class="button is-link is-medium is-rounded is-outlined"
						href="index.jsp">Return</a>
				</div>
			</div>
		</div>
	</div>



</body>
</html>