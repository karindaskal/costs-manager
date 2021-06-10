package il.ac.hit.costmanager.model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class drive {

	public static void main(String[] args) throws CostManagerException, ParseException {
		// TODO Auto-generated method stub
		IModel s = SqlModel.getInstance();
		   String sDate1="14/9/2020";  
		   Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
		
		
		  Date utilStartDate = Calendar.getInstance().getTime();
		  Date sqlStartDate = new Date(utilStartDate.getTime());
		
		  Expense product = new Expense(100.0, "books", date1, new Category("ediction"));
		  System.out.println("product"+product);
		  User  user1= new User("lilach","lilch1234");
		
		  s.login(user1);
		  s.addCost(product);
		  List<Expense> list= s.getExpenseDay(date1);
		  System.out.println(list);
		  HashMap<String,Double> list1=s.getCategoryMap();
		  

		//  String json =new Gson().toJson(list1);
		  //System.out.println(json);
			 
		

	
		
		
		  
		 
	}
}


