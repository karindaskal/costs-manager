Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@karindaskal 
karindaskal
/
costs-manager
1
00
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
Settings
costs-manager/WebContent/user/listExpensePreMonth.jsp
@karindaskal
karindaskal commit-0
Latest commit 7a79ce8 13 days ago
 History
 1 contributor
133 lines (110 sloc)  4.31 KB
  
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
    <div data-role="header" data-theme="b">
        <h1> Cost List Per Day</h1>
    </div>
     <a href="getlist.jsp" id="showregistration" data-ajax="false">back &rarr;</a>
    <label> Selecet a month</label>
        <select name="month" id="month" data-mini="true">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
      <option value="5">4</option>
        <option value="5">5</option>
       <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
     
    </select>
    <label> Selecet a year</label>
        <select name="year" id="year" data-mini="true">
        <option value="1">2022</option>
        <option value="2">2021</option>
        <option value="3">2020</option>
      <option value="5">2019</option>
        <option value="5">2018</option>
   
     
    </select>
  <input type="button" value="showlist" id="shoelist" onClick="window.cost.handleShoeListPerMonth()">

    <div data-role="content">

        <ul data-role="listview" data-theme="c" id="listPerMonth">

        </ul>
    </div>
    <div data-role="footer">

    </div>

     <div id="message"></div>
        
 
          <script type="text/javascript">
          /**
           * show message if fail or success
           */  
     
            window.cost.showMessage=function(text) {
                document.getElementById("message").innerText = text;
            }
          /**
        * show list of cost specific month
         */
         
             window.cost.showList=function(vec) {
            	  var list = document.getElementById('listPerMonth');
            	  $('#listPerMonth').empty();
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
                      $('#listPerMonth').listview('refresh');
            }
         
         
        </script>
        
      
</div>
<script type="text/javascript"> 
/*
 * handle onClick show button
 */
 window.cost.handleShoeListPerMonth=function(){
	   var monthObject = document.getElementById("month");
	   var strMonth = monthObject.options[monthObject.selectedIndex].text;
	   var yearObject = document.getElementById("year");
	   var strYear = yearObject.options[yearObject.selectedIndex].text;
	   var ob= new Month(strMonth,strYear);    
	window.cost.getListPerMonth(ob,window.cost.showList,window.cost.showMessage);
	
}
</script>
  



 
</body>
</html>
