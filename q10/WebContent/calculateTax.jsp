<html>
<head>
<title>Tax Calculation</title>
</head>
<body>
	<%
	
		String name=request.getParameter("name");
		String org=request.getParameter("org");
		String gender=request.getParameter("gender");
		double income=Double.parseDouble(request.getParameter("income"));
		session.setAttribute("name",name);
		session.setAttribute("org",org);
		session.setAttribute("gender",gender);
		session.setAttribute("income",Double.toString(income));
		
		double tax;
		if(income<=100000){
			tax=0.0;
		}else if(income>100000 && income<=500000){
			tax=0.15*income;
		}else{
			tax=0.2*income;
		}
		session.setAttribute("interest",Double.toString(tax));
		request.setAttribute("username",session.getAttribute("username"));
		request.setAttribute("password",session.getAttribute("password"));
		response.sendRedirect("dataCapture.jsp");
	%>
</body>
</html>