<!--  Karin Daskal 208511659
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
<a href="#popupMenu" data-rel="popup" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-icon-bars ui-btn-icon-left ui-btn-b" data-transition="pop">menu</a>
<div data-role="popup" id="popupMenu" data-theme="b">
        <ul data-role="listview" data-inset="true" style="min-width:210px;">
<li data-role="list-divider">Choose an action</li>
<li><a href="addcost.jsp" data-ajax="false">add</a></li>
            <li> <a href="getlistpermonth.jsp" data-ajax="false" data-rel="dialog">list expense per Month</a></li>
          <li><a href="getlistperday.jsp"  data-ajax="false" data-rel="dialog" data-close-btn="right" >list expense per Day</a></li>
          <li><a href="getlistperweek.jsp"  data-ajax="false" data-rel="dialog" data-close-btn="right" >list expense per Week</a></li>

            <li><a href="piechar.jsp"  data-ajax="false" data-rel="dialog" data-close-btn="right" >show pie chart</a></li>
        </ul>
</div>
  <a href="#" data-role="button" data-theme="b" data-inline="true" id="submitButton" onClick="window.cost.handleLogout()">logout</a>
          
    <div data-role="header" data-theme="b">
        <h1> Cost List</h1>
    </div>


    <div data-role="content">

        <ul data-role="listview" data-theme="c" id="list">

        </ul>
    </div>
    <div data-role="footer">

    </div>

     <div id="message"></div>
     
        
 
          <script type="text/javascript">
          /**
           * show message if fail 
           */        
           window.cost.showMessage= function(text) {
                document.getElementById("message").innerText = text;
            }
          /**
          *show list of cost
          */
            window.cost.showList= function(vec) {
            	  var list = document.getElementById('list');
            	vec.forEach(
                        function(ob)
                        {
                            var li = document.createElement("li");
                            var a = document.createElement("a");
                            var br1 = document.createElement("br");
                            var br2 = document.createElement("br");
                            var br3 = document.createElement("br");
                            var text = document.createTextNode('Description:'+ob.text);
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
                      $('#list').listview('refresh');
            }
            
             window.cost.handleLogout=function(){
            	window.cost.logout(window.cost.backToLogin,window.cost.showMessage)
            }
             window.cost.backToLogin=function(){
         	window.location.replace("login.jsp"); 

         }
        </script>
        
        
</div>
<script type="text/javascript"> 
//call get list
window.cost.getList(window.cost.showList,window.cost.showMessage)
</script>
  



 
</body>
</html>