<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Remove Dish</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
</head>
<body>
<%


if (session != null) {
	if (session.getAttribute("userId") != null) {				
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Remove Dish</title>");
		out.println("</head>");
		out.println("<body>");
		out.print("<div>Choose a dish to remove:</div><br><div id=\"dishList\">");
		out.println("</div>");
		out.println("</body>");
	} else {
		out.println("<div>Please log in first</div>");
	}
}


%>
<br>
<a href="welcome.jsp">Return</a>
<script type="text/javascript" src="removeDish.js" ></script>
</body>
</html>