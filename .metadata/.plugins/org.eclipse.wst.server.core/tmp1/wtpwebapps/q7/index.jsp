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
	<table border="1">
	<tr><th>OrderNo.</th><th>Accessories</th><th>TagLine</th>
	<th>ChestPocket</th><th>Color</th></tr>
	<tr><td><%= String.valueOf(session.getAttribute("orderno"))%></td>
	<td><%= String.valueOf(session.getAttribute("acc")) %></td>
	<td><%= String.valueOf(session.getAttribute("tagline")) %></td>
	<td><%= String.valueOf(session.getAttribute("pocket")) %></td>
	<td><%= String.valueOf(session.getAttribute("color")) %></td>
	</tr></table><% session.invalidate(); %>
	</div>
</body>
</html>