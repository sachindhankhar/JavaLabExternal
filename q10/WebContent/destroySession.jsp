<html>

<body>
<%
	session.invalidate();
	response.sendRedirect("login.html");
%>
</body>
</html>