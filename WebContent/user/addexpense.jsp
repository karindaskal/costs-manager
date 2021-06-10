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
 <div id="page" data-role="page" data-theme="b">
    <div data-role="header" data-theme="b">
        <h1>Add Cost</h1>
    </div>
   <a href="listexpens.jsp" id="showregistration" data-ajax="false">back &rarr;</a>

<div  data-role="content">
<form method="post">

    <label for="textinput-fc">Enter sum:</label>
    <input type="number" name="sun" id="sum" placeholder="$$" value="">
     <label for="select-native-1">category:</label>
    <select name="category" id="category" data-mini="true">
      <option value="1">Food</option>
   <option value="1">Travel</option>
        <option value="1">education</option>
        <option value="2">Clothes</option>
        <option value="3">housing</option>
        <option value="4">health</option>
    </select>
     <label for="textinput-fc">Enter Description:</label>
    <input type="text" name="description" id="description" placeholder="description..." value="">
     <label for="textinput-fc">Enter Date:</label>
      <input type="date" name="date" id="date" placeholder="date" value="">
   <input type="button" value="Add Cost" id="submitButton" onClick=" handleAddCost()">
    </form>
    

</div>
  
     
     <div id="message">
     
     </div>
          <script type="text/javascript">

/**
 * handel add cost 
 */

function handleAddCost(){	
    var sum= document.getElementById("sum").value;
    var description= document.getElementById("description").value
    var date= document.getElementById("date").valueAsNumber
    var category = document.getElementById("category")
    var categoryStr = category.options[category.selectedIndex].text; 
    if(sum==""||description==""||date==""){
    	showMessage("There are empty fields")
    }
    else{
    	if(sum<=0){
    		showMessage("sum cant be nagetive or equle to zero")
    	}
    	else{
    var cost = new Cost(sum,categoryStr,description,date)	  
    window.cost.addCostItem(cost, showMessage, showMessage);}
    }
}
/**
 * show message if fail or success
 */
function showMessage(text) {
    document.getElementById("message").innerText = text;
}


</script>

 
</div>



</body>
</html>
<%

%>
