package il.ac.hit.costmanager.model;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */
/**
 * class expense contain  the sum,the category,the date ,a small text describing that cost and user id.
 */


import java.util.Date;

import javax.persistence.JoinColumn;

public class Expense {
	   private  Category category;
	   private double sum;
	   private String text;
	   private Date date;
	   private int  id;
	   private int userId;
	   /**
	    * empty constructor 
	    */
	    public Expense() {
		super()	;
	}

/**
 * constructor
 * @param sum
 * @param text
 * @param date
 * @param category
 * @throws CostManagerException 
 */
		public Expense(double sum, String text, Date date, Category category) throws CostManagerException {
	       
	        setSum(sum);
	        setText(text);
	        setDate(date);
	        setCategory(category);
	        setUserId(userId);
	    }
		/**
		 * get id
		 * @return
		 */

	    public int getId() {
			return id;
		}
/**
 * ste id
 * @param id
 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * get category
		 * @return
		 */
		@JoinColumn(name="categoryId")
		public Category getCategory() {
	        return category;
	    }
		/**
		 * set category
		 * @param category
		 */

	    public void setCategory(Category category) {
	        this.category = category;
	    }
/**
 * get date
 * @return
 */
	    public java.util.Date getDate() {
	        return date;
	    }
	    /**
	     * set date
	     * @param date
	     */

	    public void setDate(Date date) {
	        this.date = date;
	    }
	    /**
	     * get sum
	     * @return
	     */

	    public double getSum() {
	        return sum;
	    }
	    /**
	     * set sum
	     * @param sum
	     * @throws CostManagerException 
	     */

	    public void setSum(double sum) throws CostManagerException {
	    	if(sum<=0) {
				  throw new  CostManagerException("sum can't bo negitive"); }

	    	
	        this.sum = sum;
	    }

	 /**
	  * get text
	  * @return
	  */

	    public String getText() {
	        return text;
	    }
	    /**
	     * set text
	     * @param text
	     * @throws CostManagerException 
	     */

	    public void setText(String text) throws CostManagerException {
	    	if(text.isEmpty()) {
	    		
				  throw new  CostManagerException("text can't be empty"); }

	        this.text = text;
	    }
	    /**
	     * get user id
	     * @return
	     */
	    public int getUserId() {
			return userId;
		}
/**
 * set user id
 * @param userId
 */
		public void setUserId(int userId) {
			this.userId = userId;
		}
		/**
		 * Override to  String function
		 */

	    @Override
	    public String toString() {
	        return "Expense{" +
	                "category=" + category.getCategory() +
	                ", sum=" + sum +	              
	                ", text='" + text + '\'' +
	                ", date=" + date +
	                '}';
	    }

		

}
