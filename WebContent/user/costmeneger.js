/**
 * Karin Daskal 208511659
 * Lilach Louz 315903179
 * @type {{}}
 */

window.cost= {};
/**
 * string of the begin url foe ajax
 * @type {string}
 */
window.cost.url="http://10.0.2.2:8080/cost/router";
/**
 * add cost item sent a request with cost objcext
 * @param ob
 * @param fun1
 * @param fun2
 */
window.cost.addCostItem= function (ob,fun1,fun2){
    //get string of the object to set the request

 var stringcost =ob.toString();

    fun2.call(this,"loading")
	   if (navigator.appName == "Microsoft Internet Explorer")
	   {
	       var xhr = new ActiveXObject("Microsoft.XMLHTTP");
	   }
	   else
	   {
	       var xhr = new XMLHttpRequest();
	   }




    xhr.abort();
    xhr.open(
        "GET",
        		 window.cost.url+"/user/addcost?"+stringcost,
        true);
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState == 4 && xhr.status == 200)
        {
            //function Succeeded
           fun1.call(this,"Succeeded")
        }
        else
        {
        fun2.call(this,"coudnt add cost")
        }
    };
    //send ajax
    xhr.send(); 


}
/**
 * login function
 * @param user
 * @param fun1
 * @param fun2
 */
window.cost.login=  function (user,fun1,fun2){

try{
var userString=user.toString()
       	  
        	   if (navigator.appName == "Microsoft Internet Explorer")
        	   {
        	       var xhr = new ActiveXObject("Microsoft.XMLHTTP");
        	   }
        	   else
        	   {
        	       var xhr = new XMLHttpRequest();
        	   }
            xhr.abort();
            xhr.open(
                "POST",
            window.cost.url+"/user/login?"+userString,
                true);
            xhr.onreadystatechange = function()
            {
                if (xhr.readyState == 4 && xhr.status == 200)
                {             
                                   fun1.call(this,xhr.responseText);                                                  

                }
                else{
                fun2.call(this, "fail login" );
                }
            };
            xhr.send(); }
            catch(exception)
            {  fun2.call(this, "fail login" );}
           


}
/**
 * registration function
 * @param user
 * @param fun1
 * @param fun2
 */
window.cost.registration=  function (user,fun1,fun2){
try{
var userString=user.toString()
       	  
        	   if (navigator.appName == "Microsoft Internet Explorer")
        	   {
        	       var xhr = new ActiveXObject("Microsoft.XMLHTTP");
        	   }
        	   else
        	   {
        	       var xhr = new XMLHttpRequest();
        	   }
        	
            //create an object that represents the new item  
         
                
          
            xhr.abort();
            xhr.open(
                "POST",
            window.cost.url+"/user/registration?"+userString,
                true);
            xhr.onreadystatechange = function()
            {
                if (xhr.readyState == 4 && xhr.status == 200)
                {
               
                                   fun1.call(this,xhr.responseText);  
                                                 

                }
                else{
                fun2.call(this,xhr.responseText );
                }
            };
            xhr.send(); }
            catch(exception)
            {}
           


}

/**
 * getlist of the cost
 * @param fun1
 * @param fun2
 */
window.cost.getList=  function (fun1,fun2){

            	
                var xhr = new XMLHttpRequest();
                xhr.open("GET", window.cost.url+"/user/getlist",true);
                xhr.onreadystatechange = function()
                {
                    if (xhr.readyState == 4 && xhr.status == 200){  
                      data=xhr.responseText        
                          var vec = JSON.parse(data);
                        fun1.call(this,vec);
                        fun2.call(this,"");
                       // return  vec;
                    
                   }
                   else
                   {
                   fun2.call(this,"fail load data");
                 }
                }
                xhr.send();


}
/**
 * get list of specific month 
 * @param ob
 * @param fun1
 * @param fun2
 */
window.cost.getListPerMonth=function (ob,fun1,fun2){
fun2.call(this,"laoding...")
    
         var monthString=ob.toString();       
                var xhr = new XMLHttpRequest();
                xhr.open("GET",
                 window.cost.url+"/user/showListPerMonth?"+monthString
                ,true);
                xhr.onreadystatechange = function()
                {
                    if (xhr.readyState == 4 && xhr.status == 200){  
                      data=xhr.responseText        
                          var vec = JSON.parse(data);
                        fun1.call(this,vec);
                        fun2.call(this,"");
                       // return  vec;
                    
                   }
                   else
                   {
                   fun2.call(this,"fail load data");
                 }
                }
                xhr.send();

}
/**
 * get list of specific month 
 * @param day
 * @param fun1
 * @param fun2
 */
window.cost.getListPerDay=function (day,fun1,fun2){
fun2.call(this,"laoding...")
    
             
                var xhr = new XMLHttpRequest();
                xhr.open("GET",
                 window.cost.url+"/user/getlistperday?day="+day
                ,true);
                xhr.onreadystatechange = function()
                {
                    if (xhr.readyState == 4 && xhr.status == 200){  
                      data=xhr.responseText        
                          var vec = JSON.parse(data);
                        fun1.call(this,vec);
                        fun2.call(this,"");
                       // return  vec;
                    
                   }
                   else
                   {
                   fun2.call(this,"fail load data");
                 }
                }
                xhr.send();

}
/**
 * get hach map of cost by category
 * @param fun1
 */
window.cost.getpiechart=  function (fun1){

            	
                var xhr = new XMLHttpRequest();
                xhr.open("GET", window.cost.url+"/user/gethashmap",true);
                xhr.onreadystatechange = function()
                {
                    if (xhr.readyState == 4 && xhr.status == 200){  
                      data=xhr.responseText        
                          var vec = JSON.parse(data);
                        fun1.call(this,vec);
                        }
                        else{
                        fun2.call(this,"fail")
                        }
                  
                      
                    
                   
                
                }
                xhr.send();


}

/**
 * cost class
 */
class Cost {
    /**
     * constructor
     * @param sum
     * @param category
     * @param description
     * @param date
     */
    constructor(sum, category, description,date) {
        this.sum = sum;
        this.category = category;
        this.description = description; 
        this.date=date 
    }

    /**
     * get string to send with url
     * @returns {string}
     */
    toString() {
        return "sum="+this.sum+"&category="+this.category+"&description="+this.description+"&date="+this.date
      }
}

/**
 * User class 
 */
   class User {
    /**
     * constructor
     * @param name
     * @param password
     */
            constructor(name,password) {
                this.name = name;
                this.password = password;
               
            }

    /**
     * get string to send with url
     * @returns {string}
     */
    toString() {
                return "name="+this.name+"&password="+this.password
              }
        }

/**
 * month class
 */
class Month {
    /**
     * constructor 
     * @param month
     * @param year
     */
    constructor(month,year) {
                this.month = month;
                this.year = year;
               
            }

    /**
     * string to send with url
     * @returns {string}
     */
    toString() {
                return "month="+this.month+"&year="+this.year
              }
        }


