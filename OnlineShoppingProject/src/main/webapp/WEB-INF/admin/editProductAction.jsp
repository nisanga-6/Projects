<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<% 
    boolean key=false;
	try{
		  Connection con=	ConnectionProvider.getCon();
		  String id=request.getParameter("id");
		  String name=request.getParameter("name");
		  String category=request.getParameter("category");
		  String price=request.getParameter("price");
		  String active=request.getParameter("active");
		  String query = "update products set name=?, category=?, price=?, active=? where id=?";
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setString(1, name);
		  ps.setString(2, category);
		  ps.setString(3, price);
		  ps.setString(4, active);
		  ps.setString(5, id);
		  ps.execute();
	if(active.equals("No")){
		String query1="delete from cart where product_id=? and address is null";
		PreparedStatement ps1=con.prepareStatement(query1);
		ps1.setString(1, id);
		ps1.execute();
		
	}
	response.sendRedirect("allProductEditProduct.jsp?msg=done");
}
catch(Exception e){
	System.out.println(e);
	response.sendRedirect("allProductEditProduct.jsp?msg=wrong");
}

%>