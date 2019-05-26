<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Random"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<title>ViewDetails</title>
</head>
<body bgcolor="orange">
<br><br><br>
	<div align="center">
		<%
			
			String fno=request.getParameter("fno");
			String date=request.getParameter("date");
			int sno=new Random().nextInt(500)+1;
			String name=request.getParameter("name");
			String pno=request.getParameter("pno");
	
		
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/examprac";
				Connection con=DriverManager.getConnection(url,"root","");
				PreparedStatement ps0=con.prepareStatement("select fno from flight where fno=?");
				ps0.setString(1,fno);
				ResultSet rs=ps0.executeQuery();
				if(rs.next()){
					PreparedStatement ps=con.prepareStatement("insert into seatReservation values(?,?,?,?,?)");
					ps.setString(1,fno);
					ps.setString(2,date);
					ps.setInt(3,sno);
					ps.setString(4,name);
					ps.setString(5,pno);
					ps.executeUpdate();
				%>
				
				<%=
					"Flight no.-->"+fno+"\nDate-->"+date+"\nSeat no.-->"+sno+"\nCustomer name-->"+name
				%>
				
				<% 
					ps.close();
				}else{
					out.println("No such Flight exist!");
		%>
		
			<a href="ReserveOnline.jsp">Reserve Again</a>
		
		<%
		
				}
				rs.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		%>
	</div>
</body>
</html>