package il.ac.hit.costmanager.controller;



import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import il.ac.hit.costmanager.model.Category;
import il.ac.hit.costmanager.model.CostManagerException;
import il.ac.hit.costmanager.model.Expense;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.SqlModel;
import il.ac.hit.costmanager.model.User;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */
/**
 * implements  controller
 */

public class UserController extends BasicController {
	/**
	 * constructor of UserController get Imodel object
	 * @param dao
	 */

    public UserController(IModel dao) {
        super(dao);
    }

    
    /**    
     * get user name and password and login
     * @param request
     * @param response
     * @throws CostManagerException
     */

    

    public void login(HttpServletRequest request, HttpServletResponse response)throws CostManagerException  {

		  String text = request.getRequestURI();
		  try {
			PrintWriter writer =response.getWriter();
		
		  //get name from the request
		 String name= request.getParameter("name");
		 //get password from the request
		 String password= request.getParameter("password");
		 if(name!=null&&password!=null) {
		 name = name.trim();
		 password=password.trim();	
		 if(name.equals("")||password.length()<6) {
			 throw new CostManagerException("the name or the password illegal");
		 }
		  response.setContentType("text/plain");
		  // Set  content type of the response so that jQuery knows what it can expect.
		
		  response.setCharacterEncoding("UTF-8");
		 
//create new user object
 User user= new User(name,password);
 
   
	IModel model = SqlModel.getInstance();
	
	//log in the model
		model.login(user);
		 }else throw new CostManagerException("get null");
		
	
			//send message if success or not 
			response.getWriter().write("susess");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new CostManagerException(e.getMessage(),e);

		}

		
	
	
   

  }
    /** 
     * get a month and call the function in the model that return  all the cost in this month
     * @param request
     * @param response
     * @throws CostManagerException
     */
    public void getlistpermonth(HttpServletRequest request, HttpServletResponse response)throws CostManagerException  {
    	
  
    String text = request.getRequestURI();
	  try {
		PrintWriter writer =response.getWriter();

	 
	  response.setContentType("text/plain");
	  // Set content type of the response so that jQuery knows what it can expect.
	  response.setCharacterEncoding("UTF-8");
	 
      //get month from the request
	  String month= request.getParameter("month");
	  String year= request.getParameter("year");
	  if(month.equals("")||year.equals("")) {
		  throw new CostManagerException("month or tear is illegal");
		  
	  }
      IModel model = SqlModel.getInstance();
	  List<Expense> list= model.getExpenseMonth(month,year);
	  System.out.println(list);
	  String json =new Gson().toJson(list);	 
		
	  response.getWriter().write(json);
} catch (IOException e1) {
	throw new CostManagerException(e1.getMessage(),e1);
}

}
    /**     
     * get cost details and call the function add cost from model
     * @param request
     * @param response
     * @throws CostManagerException
     */
    

public void addcost (HttpServletRequest request, HttpServletResponse response) throws CostManagerException {
	 String text = request.getRequestURI();
	  try {
		PrintWriter writer =response.getWriter();
	
	
		 System.out.println("dsfdfsd");

	
	 
	  response.setContentType("text/plain");
	  // Set  content type of the response so that jQuery knows what it can expect.
	  response.setCharacterEncoding("UTF-8");
	  //get description from the request
	  String description= request.getParameter("description");
	  //get category from the request
	  String category= request.getParameter("category");
	  //get sum from the request
	  String sum= request.getParameter("sum");
	  //get date from the request
	  String sDate= request.getParameter("date");
	//change the sum from string to double
	  double sumD=Double.parseDouble(sum);
	  //change string date to date object 
	  long dateTime= Long.parseLong(sDate);
	 
		// Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
	  Date date = new Date(dateTime);
 
	  Expense  ex= new Expense( sumD, description, date,new Category (category)) ;
IModel model = SqlModel.getInstance();


//call add cost function from model
model.addCost(ex);
response.getWriter().write("sacsess");


} catch (IOException e) {
	// TODO Auto-generated catch block
	throw new  CostManagerException(e.getMessage(),e);
}
}
/**
 * get the Details off the new user and call the function registration from model
 * @param request
 * @param response
 * @throws CostManagerException
 * 
 */

public void registration(HttpServletRequest request, HttpServletResponse response)throws CostManagerException  {
	 System.out.println("dsfdfsd");
	  String text = request.getRequestURI();
	  try {
		PrintWriter writer =response.getWriter();
		  //get name from the request
	 String name= request.getParameter("name");
	  //get name from the request
	 String password= request.getParameter("password");
	 name = name.trim();
	 password=password.trim();
	


	
	 
	  response.setContentType("text/plain");
	  // Set		  content type of the response so that jQuery knows what it can expect.
	  response.setCharacterEncoding("UTF-8");
	 
// You want world domination, huh?
User user= new User(name,password);

IModel model = SqlModel.getInstance();

//call registration function from the model
	model.registration(user);


		response.getWriter().write("susess");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		throw new CostManagerException(e.getMessage(),e);

	}

	




}
/** 
 * call the fubction gel lisy from model ans response with the list
 * @param request
 * @param response
 * @throws CostManagerException
 * 
 */
public void getlist(HttpServletRequest request, HttpServletResponse response)throws CostManagerException  {
		  String text = request.getRequestURI();
		  try {
			PrintWriter writer =response.getWriter();
		 
		  response.setContentType("text/plain");
		  // Set		  content type of the response so that jQuery knows what it can expect.
		  response.setCharacterEncoding("UTF-8");
		 

  
     //set a model object
	IModel model = SqlModel.getInstance();

	
//create list of expense
		  List<Expense> list= model.getExpense();
		// list to json String
		  String json =new Gson().toJson(list);
		 
			
		//write response json string
			response.getWriter().write(json);
		  } catch (IOException e) {
				// TODO Auto-generated catch block
				throw new CostManagerException(e.getMessage(),e);

			
	
	} 
	}
/**
 * call the function gel list specific day  from model an response with the list
 * @param request
 * @param response
 * @throws CostManagerException
 */
public void getlistperday(HttpServletRequest request, HttpServletResponse response)throws CostManagerException  {
	  String text = request.getRequestURI();
	  try {
		PrintWriter writer =response.getWriter();
	 
	  response.setContentType("text/plain");
	  // Set		  content type of the response so that jQuery knows what it can expect.
	  response.setCharacterEncoding("UTF-8");
	 
	  String sDate= request.getParameter("day");
	
	  long dateLong =Long.parseLong(sDate);
	  Date date = new Date(dateLong);

//set a model object
IModel model = SqlModel.getInstance();


//create list of expense
	  List<Expense> list= model.getExpenseDay(date);
	// list to json String
	  String json =new Gson().toJson(list);
	 
		
	//write response json string
		response.getWriter().write(json);
	  } catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("fail");
			throw new CostManagerException(e.getMessage(),e);

		

}
}
/**
 * call the function gel list specific week from model an response with the list
 * @param request
 * @param response
 * @throws CostManagerException
 */
public void getlistperweek(HttpServletRequest request, HttpServletResponse response)throws CostManagerException  {
	  String text = request.getRequestURI();
	  try {
		PrintWriter writer =response.getWriter();
	 
	  response.setContentType("text/plain");
	  // Set		  content type of the response so that jQuery knows what it can expect.
	  response.setCharacterEncoding("UTF-8");
	 
	  String sDate= request.getParameter("day");
	
	  long dateLong =Long.parseLong(sDate);
	  Date date = new Date(dateLong);

//set a model object
IModel model = SqlModel.getInstance();


//create list of expense
	  List<Expense> list= model.getExpenseWeek(date);
	// list to json String
	  String json =new Gson().toJson(list);
	 
		
	//write response json string
		response.getWriter().write(json);
	  } catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("fail");
			throw new CostManagerException(e.getMessage(),e);

		

}
}
/**
 * call a function to get hashMap and return a json
 * @param request
 * @param response
 * @throws CostManagerException
 */

public void getdatapiechart(HttpServletRequest request, HttpServletResponse response)throws CostManagerException  {
	  String text = request.getRequestURI();
	  try {
		PrintWriter writer =response.getWriter();
	 
	  response.setContentType("text/plain");
	  // Set content type of the response so that jQuery knows what it can expect.
	  response.setCharacterEncoding("UTF-8");
//create a model object
IModel model = SqlModel.getInstance();


//create a hashMap object
HashMap<String,Double> hashamp=model.getCategoryMap();
	//turn hashMap to json object
	  String json =new Gson().toJson(hashamp);
	 
		
	//write to response json string
		response.getWriter().write(json);
	  } catch (IOException e) {
			// TODO Auto-generated catch block
			throw new CostManagerException(e.getMessage(),e);

		

}
}
/**
 * logout
 * @param request
 * @param response
 * @throws CostManagerException
 */
public void logout(HttpServletRequest request, HttpServletResponse response) throws CostManagerException {
	
	 
	IModel model = SqlModel.getInstance();
	request.getSession().invalidate();
	
	
	
}


}
