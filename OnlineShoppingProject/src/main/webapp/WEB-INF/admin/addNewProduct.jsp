<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<%@include file="adminHeader.jsp" %>
<%@include file="../footer.jsp" %>
<html>
<head>
<link rel="stylesheet" href="../css/addNewProduct-style.css">
<title>Add New Product</title>   
</head>
<body>
<%
int id=0;
try{
Connection con=ConnectionProvider.getCon();
Statement st=con.createStatement();
String query="select max(id) from products";
ResultSet rs=st.executeQuery(query);
while(rs.next()){
id=	rs.getInt(1);
id=id+1;
}}catch(Exception e){
	System.out.println(e);
}


%>
<form action="AddProductAction.jsp" method="post">
<h3 style="color: yellow;">Product ID: <%out.println(id) ;%></h3>
<input type="hidden" name="id" value="<%out.println(id) ; %>">


<div class="left-div">
 <h3>Enter Name</h3>
 <input class="input-style" type="text" name="name" placeholder="Enter the name" required>
<hr>
</div>

<div class="right-div">
<h3>Enter Category</h3>
 <input class="input-style" type="text" name="category" placeholder="Enter the category" required>
<hr>
</div>

<div class="left-div">
<h3>Enter Price</h3>
 <input class="input-style" type="number" name="price" placeholder="Enter the price" required>
<hr>
</div>

<div class="right-div">
<h3>Active</h3>
   <select class="input-style" name="active">
   <option value="Yes">Yes</option>
   <option value="No">No</option>
   </select>
<hr>
</div>
<button class="button">Save <i class='far fa-arrow-alt-circle-right'></i></button>
</form>
<%
String message=request.getParameter("msg");
if("success".equals(message)){
%>
<h3 class="alert">Product Added Successfully!</h3>
<% }%>
<% 
if("failed".equals(message)){
	
%>
<h3 class="alert">Some thing went wrong! Try Again!</h3>	
<% }%>
</body>
<br><br><br>
</body>
</html>