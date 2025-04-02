<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<% 


String email=request.getParameter("email");
String mobileNumber=request.getParameter("mobileNumber");
String security_question=request.getParameter("security_question");
String answer=request.getParameter("answer");
String new_password=request.getParameter("new_password");


try{
	int check=0;
Connection con=	ConnectionProvider.getCon();
String sql= "select * from users where email=? and mobileNumber=? and securityQuestion=? and answer=?";
PreparedStatement statement= con.prepareStatement(sql);
statement.setString(1, email);
statement.setString(2, mobileNumber);
statement.setString(3, security_question);
statement.setString(4, answer);
ResultSet rs=statement.executeQuery();
while(rs.next()){
	check=1;
	String sqlUpdate="update users set password=? where email=?";
	PreparedStatement statement1= con.prepareStatement(sqlUpdate);
	statement1.setString(1, new_password);
	statement1.setString(2,email);
	statement1.executeUpdate();
	response.sendRedirect("forgotPassword.jsp?msg=valid");
}
if(check==0){
	response.sendRedirect("forgotPassword.jsp?msg=Invalid");
}
}
catch(Exception e){
	System.out.println(e);
	//response.sendRedirect("forgotPassword.jsp?msg=Invalid");
}

%>