<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<title>ForgotPassword</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
     <form action="ForgotPasswordAction.jsp" method="post">
      <input type="text" name="email" placeholder="Enter the email" required><br><br>
      <input type="number" name="mobileNumber" placeholder="Enter the mobileNumber" required><br><br>
      <select name="security_question">
      <option>What's your first Car?</option>
       <option>What is your mother's middle name?</option>
        <option>What is your favourite colour?</option>
      </select><br><br>
       <input type="text" name="answer" placeholder="Enter the answer" required><br><br>
       <input type="password" name="new_password" placeholder="Enter the new password" required><br><br>
       <input type="submit"  value="SignUp">
      </form>
      <h2><a href="login.jsp">Login</a></h2>
      
  </div>
  <div class='whyforgotPassword'>
  <%
 String message= request.getParameter("msg");
  if("valid".equals(message))
  {
  %> 
<h1>Password Changed Successfully!</h1>
<% }%>
<%
if("Invalid".equals(message))
{
%>
<h1>Some thing Went Wrong! Try Again !</h1>
<% }%>
    <h2>Online Shopping</h2>
    <p>The Online Shopping System is the application that allows the users to shop online without going to the shops to buy them.</p>
  </div>
</div>
</body>
</html>