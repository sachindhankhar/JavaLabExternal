<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<title>Flights</title>
</head>
<body bgcolor="green"><br><br><br><br>
	<div align="center">
	<%
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/examprac";
	Connection con=DriverManager.getConnection(url,"root","");
	PreparedStatement ps0=con.prepareStatement("select * from flight where day=?");
	ps0.setString(1,request.getParameter("day"));
	ResultSet rs=ps0.executeQuery();
	%>
	<table border="1">
	<tr><th>Flight_no.</th><th>Airline Name</th><th>Day</th></tr>
	<% 
		while(rs.next()){
			
	%>
		
		<tr><td><%out.println(rs.getString("fno")); %></td>
		<td><%out.println(rs.getString("airline_name")); %></td>
		<td><%out.println(rs.getString("day")); %></td></tr>
	
	<%
	}
	rs.close();
	ps0.close();
	con.close();
	%>
	</table>
	</div>
</body>
</html>