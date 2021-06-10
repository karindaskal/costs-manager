<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <script src="costmeneger.js"></script>
<meta charset="windows-1255">
<title>Insert title here</title>
</head>
<body>
 <div id="page" data-role="page" data-theme="b">
    <div data-role="content">
      <h2>Login</h2>
      <p align="right">
        <a href="registration.html" id="showregistration">Don't have an
          account? &rarr;</a>
      </p>
      <form method="post" id="loginForm">
        <label for="password">User Name:</label> 
        <input class="required" type="text" name="username" id="username"
          placeholder="username"> 
        <label for="password">Password:</label>
        <input class="required" type="password" name="password"
          id="password" placeholder="password"> 
        <input type="button" value="Login" id="submitButton" onClick="handleLogin()">
         
          
      </form>
    </div>
     <div id="message"></div>
  </div>
   <script>

  
        function handleLogin() {
            var name= document.getElementById("username").value;
            var password= document.getElementById("password").value;
         document.getElementById("message").innerText = "loading...";
         var user= new User(name,password);
         
     
        window.cost.login(user , openList, showMessage);
        }
        function showMessage(text) {
            document.getElementById("message").innerText = text;
        }
        function openList(text) {
        	window.location.replace("listexpens.jsp"); 

        }
      

         

        
    </script>

</body>
</html>

