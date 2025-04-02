
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<title>Login</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
     <form action="LoginAction.jsp"  method="post">
     <input type="text" name="email" placeholder="enter the email" required><br><br>
     <input type="password" name="password" placeholder="enter the password" required><br><br>
     <input type="submit" value="Login">
      <h2><a href="signup.jsp">SignUp</a></h2>
       <h2><a href="forgotPassword.jsp">Forgot Password?</a></h2>
       </form>
  </div>
  <div class='whysignLogin'>
  
  <% 
  String message= request.getParameter("msg");
  if("notExists".equals(message)){
  %>
  <h1>Incorrect username or password</h1>
<% } %>
<% 
if("Invalid".equals(message)){

%>
<h1>Some thing Went Wrong! Try Again !</h1>
<%} %>
    <h2>Online Shopping</h2>
    <p>The Online Shopping System is the application that allows the users to shop online without going to the shops to buy them.</p>
  </div>
</div>

</body>
</html>