<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<html>
<head>
<title>Page</title>
</head>
<body bgcolor="orange">
<%! String username;
	String password;
%>
<%
	
	if(null==session.getAttribute("username")){
		 username=request.getParameter("username");
		 password=request.getParameter("password");
	}else{
		username=String.valueOf(session.getAttribute("username"));
		password=String.valueOf(session.getAttribute("password"));
		
	}
	HashMap<String,String> hm=new HashMap<>();
	hm.put("sabya","sabya");
	hm.put("sanchit","sanchit");
	hm.put("rishikesh","rishikesh");
	hm.put("piyush","piyush");
	
	if(hm.containsKey(username) && hm.get(username).equals(password)){
		
		out.println("Hello "+username+"<br>");
		Date date= new Date();
		out.println(date+"<br>");
		session.setAttribute("username",username);
		session.setAttribute("password",password);
		
%>
<a href="destroySession.jsp">Logout</a>
	<div align="center">
	<form action="calculateTax.jsp"><br><br><br>
		Name:<input type="text" name="name"><br><br>
		Place Of Work:<select name="org">
			<option value="MIT">MIT</option>
			<option value="Oxford">OXFORD</option>
			<option value="Harvard">HARVARD</option>
		</select><br><br>
		Gender: Male<input type="radio" name="gender" value="Male">  Female<input type="radio" name="gender" value="Male"><br><br>
		Annual Income:<input type="text" name="income"><br><br>
		<input type="submit" value="CalculateTax">
	</form>
	
	Interest on your Income--><%out.println(session.getAttribute("income")); %> is--><% out.println(session.getAttribute("interest")); %>
	</div>
	<% 	
	}else{
		out.println("Wrong credentials!");
	%>
	<a href="login.html">Login Again</a>
	<%}
	%>
	
</body>
</html>