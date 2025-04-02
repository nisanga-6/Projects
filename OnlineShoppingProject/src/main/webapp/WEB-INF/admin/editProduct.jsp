<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<html>
<head>
<link rel="stylesheet" href="../css/addNewProduct-style.css">
<title>Add New Product</title>
<style>
.back
{
  color: white;
  margin-left: 2.5%
}
</style>
</head>
<body>
<%
String id=request.getParameter("id");
  try{
	  Connection con=	ConnectionProvider.getCon();
	  String query ="select * from products where id=?";
	  PreparedStatement ps=con.prepareStatement(query);
	  ps.setString(1, id);
	ResultSet rs=  ps.executeQuery();
    while(rs.next()){
  
%>
 <form action="editProductAction.jsp" method="post">
 <input type="hidden" name="id" value=<%out.println(id); %>>
<div class="left-div">
 <h3>Enter Name</h3><br>
  <input type="text" name="name"  value=<%=rs.getString(2)%>>
<hr>
</div>

<div class="right-div">
<h3>Enter Category</h3><br>
 <input type="text" name="category"  value=<%=rs.getString(3)%>>
<hr>
</div>

<div class="left-div">
<h3>Enter Price</h3>
 <input type="text" name="price"  value=<%=rs.getString(4)%>>
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
 <i class='far fa-arrow-alt-circle-right'></i>


<button><i class='fas fa-arrow-circle-left'> Edit</i></button>
<h2><a class="back" href="allProductEditProduct.jsp"><i class='fas fa-arrow-circle-left'> Back</i></a></h2>
</form>
<%
    }}
catch(Exception e){
	System.out.println(e);
} %>
<% 
String message=request.getParameter("msg");
if("updated".equals(message)){
%>
<h1>Updated Successfully</h1>
<%} %>
<%if("notUpdated".equals(message)){ %>
<h1>Some thing Went Wrong! Try Again !</h1>
<%}  %>
<br><br><br>
</body>
</html>