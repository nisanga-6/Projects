<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<%
try{
Connection con=ConnectionProvider.getCon();
Statement st=con.createStatement();
String query="create table users(username varchar(100), email varchar(100), mobileNumber int, securityQuestion varchar(200), answer varchar(200), password varchar(100),address varchar(500),city varchar(100), state varchar(100), country varchar(100) )";
String query2="create table products(id int, name varchar(100),category varchar(200), price int, active varchar(10))";
String query3="create table cart(email varchar(100), product_id int, quantity int, price int, total int, address varchar(500),city varchar(100),state varchar(100),country varchar(100),mobileNumber bigint, orderDate varchar(100), deliveryDate varchar(100), paymentMethod varchar(100),transactionID varchar(100),status varchar(10))";

//System.out.println(query2);
//System.out.println(query);
System.out.println(query3);
//st.execute(query2);
st.execute(query3);
System.out.println("Table created");
con.close();
}catch(Exception e){
	System.out.println(e);
}
%>