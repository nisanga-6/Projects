<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>

<% 

String email=request.getParameter("email");
String password=request.getParameter("password");
if("admin@gmail.com".equals(email) && "admin".equals(password)){
	session.setAttribute("email", email);
	response.sendRedirect("adminHome.jsp");
}else{
	try{
	int z=0;
Connection con=	ConnectionProvider.getCon();
//Statement st=con.createStatement();
String query = "Select * from users where email=? and password=?";
PreparedStatement ps=con.prepareStatement(query);
ps.setString(1, email);
ps.setString(2, password);
ResultSet rs=ps.executeQuery();
while(rs.next()){
	 z=1;
	session.setAttribute("email", email);
	response.sendRedirect("home.jsp");
}
if(z==0){
	response.sendRedirect("login.jsp?msg= notExists");
}
	}
	catch(Exception e){
		System.out.println(e);
		response.sendRedirect("login.jsp?msg= Invalid");
	}
}

%>