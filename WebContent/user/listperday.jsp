<!-- Karin Daskal 208511659
 Lilach Louz 315903179 -->
<%@ page language="java" contentType="text/html; charset=windows-1255"
 pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
 <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
 <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
 <script src="costmeneger.js"></script>
</head>
<body>
<div data-role="page" id="home" data-theme="b">
 <div data-role="header" data-theme="b">
 <h1> Cost List Per Month</h1>
 </div>
 <a href="listexpens.jsp" id="showregistration" data-ajax="false">back &rarr;</a> <label for="textinput-fc">Enter Date:</label>
 <input type="date" name="date" id="date" placeholder="date" value="">
 <input type="button" value="showlist" id="shoelist" onClick="handleShoeListPerDay()">
 <div data-role="content">
 <ul data-role="listview" data-theme="c" id="listPerDay">
 </ul>
 </div>
 <div data-role="footer">
 </div>
 <div id="message"></div>
 <div id="message2"></div> 
 <script type="text/javascript">
 
  /**
 * show message if fail 
 */
 function showMessage(text) {
 document.getElementById("message").innerText = text;
 }
 /**
 * show list of cost in specific day
 */
 function showList(vec) {
 var list = document.getElementById('listPerDay'); 
 $('#listPerDay').empty(); 
vec.forEach( 
 function(ob)
 {
 var li = document.createElement("li");
 var a = document.createElement("a");
 var br1 = document.createElement("br");
 var br2 = document.createElement("br");
 var br3 = document.createElement("br"); var text = document.createTextNode('Description:'+ob.text);
 var sum = document.createTextNode('Sum:'+ob.sum);
 var date = document.createTextNode('Date:'+ob.date);
 var category = document.createTextNode(ob.category.category); 
 a.appendChild(category);
 a.appendChild(br1);
 a.appendChild(text);
 a.appendChild(br2);
 a.appendChild(sum);
 a.appendChild(br3);
 a.appendChild(date);
 a.setAttribute("href","#");
 li.appendChild(a);
 list.appendChild(li);
 }
 );
 $('#listPerDay').listview('refresh');
 }
 
  </script>
 
 
</div>
<script type="text/javascript"> 
/*
* handle onClick show button of day
*/
function handleShoeListPerDay(){
var date= document.getElementById("date").valueAsNumber
showMessage(date)
 
 
window.cost.getListPerDay(date,showList,showMessage);
}</script>
 
</body>
</html>