<!--  Karin Daskal 208511659
  Lilach Louz 315903179 -->
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
    <script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
      <script src="costmeneger.js"></script>
    <script>
    /**
    *onload function
    */
        window.onload = function () {
        	 window.cost.getpiechart(showpieChart,showMessage)


        }
        /**
       * show message if failed
        */
        
        function showMessage(text) {
            document.getElementById("message").innerText = text;
        }
        /**
       * Show pie cahrt
        */
        function showpieChart(vec) {

            var array_keys = new Array();
            var array_values = new Array();

            for (var key in vec) {
                array_keys.push({label:key,y:vec[key]});
                array_values.push(vec[key]);
            }
            //  alert(vec);

            var options = {
                title: {
                    text: "pie chart cost"
                },
                subtitles: [{
                    text: "by categories"
                }],
                animationEnabled: true,
                data: [{
                    type: "pie",
                    startAngle: 40,                
                    toolTipContent: "<b>{label}</b>: {y}%",
                    showInLegend: "true",
                    legendText: "{label}",
                    indexLabelFontSize: 16,
                    indexLabel: "{label} - {y}%",
                    dataPoints: array_keys
                }]
            };
            $("#chartContainer").CanvasJSChart(options);
        }

    </script>

    
</head>

<body>
 <a href="listexpens.jsp" id="showregistration" data-ajax="false">back &rarr;</a>

<div id="chartContainer" data-theme="b" ></div>
  <div id="message"></div>


</body>
</html>