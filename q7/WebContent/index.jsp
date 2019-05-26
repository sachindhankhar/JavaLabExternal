<%@page import="java.sql.ResultSet"%>
<html>
<head>
<title>T-shirt</title>
</head>
<body bgcolor="yellow"><br><br><br>
	<div align="center">
	
	<form action="Tshirts" method="post">
	
		T-Shirt Accessories:Belt:<input type="checkbox" name="acc" value="belt">
		Cap:<input type="checkbox" name="acc" value="cap">
		HairBand:<input type="checkbox" name="acc" value="HairBand">
		<br><br>
		T-Shirt Tag line:<input type="text" name="tagline"><br><br>
		Chest Pocket:Yes<input type="radio" name="pocket" value="yes">
					 No<input type="radio" name="pocket" value="no">
		T-Shirt Color:<select name="color">
		<option value="red">Red</option>
		<option value="green">Green</option>
		<option value="blue">Blue</option>
		</select>
		<input type="submit" value="Click Me">
	</form>
	<br><br>
	<table border="1"><tr><th>OrderNo</th>
	<th>Accessories</th><th>Tagline</th><th>ChestPocket</th>
	<th>Color</th></tr>
	<%if(null!=session.getAttribute("tshirts")){
	ResultSet rs=(ResultSet)session.getAttribute("tshirts");
	
	while(rs.next()){
	%><tr><td><%= rs.getInt("orderno")%></td><td><%= rs.getString("acc")%></td>
	<td><%= rs.getString("tagline")%></td><td><%= rs.getString("pocket")%></td>
	<td><%= rs.getString("color")%></td></tr>
	<%}}%>
	</table>
	</div>
</body>
</html>
