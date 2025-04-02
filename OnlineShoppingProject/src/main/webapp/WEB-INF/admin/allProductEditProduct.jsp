<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
h3
{
	color: yellow;
	text-align: center;
}
</style>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">All Products & Edit Products <i class='fab fa-elementor'></i></div>
<table>

<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Active</th>
</tr>
</thead>
<%
try{
Connection con =ConnectionProvider.getCon();
Statement st = con.createStatement();
String query = "Select * from products";
ResultSet rs=st.executeQuery(query);
while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><a href="editProduct.jsp?id=<%=rs.getString(1)%>">Edit <i class='fas fa-pen-fancy'></i></a></td>
<%} 
}catch(Exception e){
	System.out.println(e);
	
}
%>

</tr>

</table>
<%
String message= request.getParameter("msg");
if("done".equals(message)){
%>
<h3 class="alert">Product Successfully Updated!</h3>
<%} %>
<% if("wrong".equals(message)){ %>
<h3 class="alert">Some thing went wrong! Try again!</h3>

<%} %>
      <br>
      <br>
      <br>

</body>
</html>