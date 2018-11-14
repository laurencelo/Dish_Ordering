<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Dish</title>

</head>
<body>
<form name="regform" action="ModifyDishController" method="post" onsubmit="return regValidate()">
	<br>${message}<br>
	<script
  	src="https://code.jquery.com/jquery-3.3.1.min.js" 
  	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  	crossorigin="anonymous">
	</script>
	
	<%-- <%
		/* int start = Integer.parseInt(request.getParameter("name")); //not working
		out.print(start); */
		try{ 
			int start=Integer.parseInt(request.getParameter("name")); 
			out.print("start-->"+start); 
			} 
			catch(Exception e) 
			{ 
			e.printStackTrace(); 
			}
	%> --%>
	<div>${param["dname"]}</div>
	Dish Name: <input type="text" class="nnnnnn" name="dishname"><br>
	Dish Price: <input type="text" name="dishprice"> <br>
	Dish Inventory: <input type="text" name="dishinventory"> <br>
	
	<div id="password_error"></div><br>
	<input type="submit" name="submit" value="updateDish" >
	<input type="reset" name="reset">
	
	
	</form>
	<a href="welcome.jsp">return</a>
	
</body>
	<!-- <script type="text/javascript" src="modifyDish.js" ></script> -->
</html>