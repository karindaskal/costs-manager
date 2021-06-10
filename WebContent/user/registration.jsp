<!--  Karin Daskal 208511659
  Lilach Louz 315903179 -->
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
  <div data-role="header" data-theme="b">
      <h1>Registration</h1>
      </div>
    <div data-role="content">
     
      <p align="right">
        <a href="login.jsp" id="showregistration" data-ajax="false">login
         &rarr;</a>
      </p>
      <form method="post" id="registrarionForm">
        <label for="password">User Name:</label> 
        <input class="required" type="text" name="username" id="username"
          placeholder="username"> 
        <label for="password">Password:</label>
        <input class="required" type="password" name="password"
          id="password" placeholder="password"> 
             <label for="password"> Confirm Password :</label>
        <input class="required" type="password" name="confirm"
          id="confirm" placeholder="password"> 
        <input type="button" value="Registration" id="submitButton" onClick="handleRegistration()">
         
          
      </form>
    </div>
     <div id="message"></div>
  </div>
   <script>

  /**
* handle onClick button
  */
        function handleRegistration() {
            var name= document.getElementById("username").value;
            var password= document.getElementById("password").value;
            var confirm= document.getElementById("confirm").value;
        	showMessage("loading...")
          
            if(password!=confirm){
            	showMessage("The passwords are not the same")
            }
        	  if(password.length<6){
              	showMessage("Password must be at least 6 characters long ")
              }
              else if(name==""){
              	showMessage("user naem coudt bo empty ")

             }
            else{
       
         var user= new User(name,password);         
     
        window.cost.registration(user , showMessage, showMessage);
            }
        }
  /**
  * show message if failed or success
  */
        function showMessage(text) {
            document.getElementById("message").innerText = text;
        }
     
    </script>

</body>
</html>

