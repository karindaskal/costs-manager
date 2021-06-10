package il.ac.hit.costmanager.model;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */


public class User {
	private String userName;
	private String password;
	private int id;
/**
 * empty constructor
 */

	public User() {
		super();
	}
	/**
	 * constructor get two string of use name and password
	 * @param userName
	 * @param password
	 * @throws CostManagerException 
	 */
	public User(String userName, String password) throws CostManagerException {
		super();
		
		setUserName(userName);
		setPassword(password);
	
		
	}
	/**
	 * get user name 
	 * @return
	 */
	public String getUserName() {		
		return userName;
	}
	/**
	 * set user name
	 * @param userName
	 * @throws CostManagerException 
	 */
	public void setUserName(String userName) throws CostManagerException {
		if(userName.isEmpty())
		{
			  throw new  CostManagerException("user name can't be empty"); 

		}
		this.userName = userName;
	}
	/**
	 * get password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * set password password must be more than 6 sign 
	 * @param password
	 * @throws CostManagerException 
	 */
	public void setPassword(String password) throws CostManagerException {
		if(password.length()<6) {
			  throw new  CostManagerException("list must be more than 6 sign"); 
			  }
		
			
		this.password = password;
	}
	/**
	 * get id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * set id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	

}
