<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="css/reset.css" rel="stylesheet">
		<link href="css/editAssignment.css" rel="stylesheet">
		<title>edit assignment</title>
	</head>
	<body class=body>
		<%@ page import='java.util.*, br.edu.insper.*' %>
		<%  
			String userId = request.getParameter("userId");
			String asgId = request.getParameter("asgId");
		%>
		
		<h1 class='title'>Edit your assignment</h1>
		<form action='UpdateAssignment' method='post' class='form'>
			<div class='box'>
				<p>asignment: <input type='text' name='asg'></p>
				<p>date: <input type='text' name='date'></p>
			</div>
			<input type='hidden' value=<%= userId %> name='userId'><br>
			<input type='hidden' value=<%= asgId  %> name='asgId'>
			
			<input type='submit' value='submit changes'>
			
		</form>

	</body>
</html>