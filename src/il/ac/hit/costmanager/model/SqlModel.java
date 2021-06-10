package il.ac.hit.costmanager.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */
/**
 * model connect to hibernate 
 * getting and adding data to database
 */



public class SqlModel implements  IModel  {
	private SessionFactory factory;
	private User user;
	
	
	private static SqlModel instance;
	static {
		SqlModel.instance = new SqlModel();
		
	}

	private SqlModel() {
	
	}

	/**
	 * This method return instance of the SimpleJDBCMySQLProductsDAO class
	 */
	public static SqlModel getInstance() {
		return SqlModel.instance;
		
	}

	@Override
	 /**
     *     add expense to the cost table
     *       @param expense
     *       @throws CostManagerException
     */
	public void addCost(Expense expense) throws CostManagerException {
		Session session= null;
		try {
			//get current user
		expense.setUserId(user.getId());
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		 session = factory.openSession();
		session.beginTransaction();	
		//add expense to the table
		session.save(expense);
		session.getTransaction().commit();
		}
		   catch(HibernateException hibernateEx) {
				  throw new  CostManagerException(hibernateEx.getMessage(),hibernateEx); }
		finally {
			  if(session!=null) { 
				  session.close();
			  }
		}
		

		
	}



	@Override
	   /**
     * get list of expenses on specific month
     * * @param month
     *    
     *      @return
     *      @throws CostManagerException
     */
	public List<Expense> getExpenseMonth(String month, String year) throws CostManagerException {
		Session session= null;
      
		try {
			//get factory object from configure
		 SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		 //get  session object
		  session = factory.openSession();
			//start a transaction 
		  session.beginTransaction();		 
				  @SuppressWarnings("unchecked")
				  //get list of an expense in  specific month
				  List<Expense> list =( List<Expense>)session.createQuery(" FROM Expense  WHERE MONTH(DATE) = "+ month+"and YEAR(DATE)="+year+"and USERID=:userid")
						  .setParameter("userid", user.getId()).
						  list();
				  return list;
				
				
		}
	   catch(HibernateException hibernateEx) {
		  throw new  CostManagerException(hibernateEx.getMessage(),hibernateEx); }
finally {
	  if(session!=null) { 
		  //close session
		  session.close();
	  }
}	
			

	
	}


	@Override
	 /**
     * add new user 
     * @param user
     * @throws CostManagerException
     */
	public void registration(User user) throws CostManagerException {
		Session session= null;
		try {
			//get factory object from configure
			 SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
			 //get  session object
			  session = factory.openSession();
			//start a transaction 
			  session.beginTransaction();	
		session.save(user);
		session.getTransaction().commit();
		}
		catch(HibernateException hibernateEx) {
			   throw new CostManagerException(hibernateEx.getMessage(),hibernateEx);
		}
		finally {
			if(session!=null) {
				session.close();

			}
		}
		
		
	}

	@Override
	   /**
     * 
     * @param user
     * @throws CostManagerException
     */
	public void login(User user) throws CostManagerException {
		 Session session= null;
		try { 
			//get factory object from configure
			 SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
			 //get  session object
			  session = factory.openSession();
			//start a transaction 
			  session.beginTransaction();	
			
				 
			// get an user object user = (User)
			User user1=(User)session.createQuery("FROM User U WHERE U.userName = :userName").setParameter(
			"userName", user.getUserName()) .uniqueResult(); 
			if(user1 != null && user1.getPassword().equals(user.getPassword())) {
				this.user=user1; }
			else {
			 throw new CostManagerException("User does not exist"); }  
			
			
				  
				  } catch(HibernateException hibernateEx) {
					  throw new  CostManagerException(hibernateEx.getMessage(),hibernateEx); }
		finally {
				  if(session!=null) { 
					  session.close();
				  }
		}
	}

	@Override
	  /**
     * get list of all the Expense
     *   @return
     *   @throws CostManagerException
     */
	public List<Expense> getExpense() throws CostManagerException {
		Session session= null;
        //List<Expense> list = new ArrayList<>();
		try {
			// Get the SessionFactory object from configuration.
		 SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
        //get session object
		  session = factory.openSession();
		//start a transaction 
		  session.beginTransaction();		 
				  @SuppressWarnings("unchecked")
				  //sql query
				  List<Expense> list=( List<Expense>)session.createQuery(" FROM Expense  WHERE USERID=:userid")
						  .setParameter("userid",user.getId()).list();
				
						  
				  return list;
				
		}
	   catch(HibernateException hibernateEx) {
		  throw new  CostManagerException(hibernateEx.getMessage(),hibernateEx); }
finally {
	  if(session!=null) { 
		  session.close();
	  }
}
	
	}

	@Override
	 /**
     * get list of expenses on specific day
     * * @param day
     *    
     *      @return
     *      @throws CostManagerException
     */
	public List<Expense> getExpenseDay(Date day) throws CostManagerException {
		Session session= null;
	      
		try {
			//get factory object from configure
		 SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		 //get  session object
		  session = factory.openSession();
	
			//start a transaction 
		  session.beginTransaction();	
		  long dayAfter =day.getTime()+1000 * 60 * 60 * 24;
				  @SuppressWarnings("unchecked")
				  String pattern = "yyy-MM-dd HH:mm:ss";

				// Create an instance of SimpleDateFormat used for formatting 
				// the string representation of date according to the chosen pattern
				DateFormat df = new SimpleDateFormat(pattern);

				// Get the today date using Calendar object.
		
				// representation of a date with the defined format.
				String todayAsString = df.format(day);
				
				  
				  //get list of an expense in  specific month
				  List<Expense> list =( List<Expense>)session.createQuery(" FROM Expense WHERE DATE ='"+todayAsString+"'and USERID=:userid")
						  .setParameter("userid", user.getId()).
						  list();
				  return list;
				
				
		}
	   catch(HibernateException hibernateEx) {
		  throw new  CostManagerException(hibernateEx.getMessage(),hibernateEx); }
finally {
	  if(session!=null) { 
		  //close session
		  session.close();
	  }
	}
}
	 /**
     * get hashMap of Categories
     * @return
     * @throws CostManagerException
     */

	@Override
	public HashMap<String, Double> getCategoryMap() throws CostManagerException {
		Session session= null;
		  HashMap<String, Double> categories = new HashMap<>();
        //List<Expense> list = new ArrayList<>();
		try {
			// Get the SessionFactory object from configuration.
		 SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
        //get session object
		  session = factory.openSession();
		//start a transaction 
		  session.beginTransaction();		 
				  @SuppressWarnings("unchecked")
				  //sql query
				  List<Expense> list=( List<Expense>)session.createQuery(" FROM Expense  WHERE USERID=:userid")
						  .setParameter("userid",user.getId()).list();
			for(Expense expense : list) {
				//get current count
				Double j = categories.get(expense.getCategory().getCategory());
				categories.put(expense.getCategory().getCategory(),(j==null)?1:j+1);
			}
			return categories;
				
		}
	   catch(HibernateException hibernateEx) {
		  throw new  CostManagerException(hibernateEx.getMessage(),hibernateEx); }
finally {
	  if(session!=null) { 
		  session.close();
	  }
}
	
	}
}  
				  
				  
		
		
	




