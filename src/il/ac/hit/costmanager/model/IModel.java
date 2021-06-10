package il.ac.hit.costmanager.model;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */

public interface IModel {
    /**
     *     add expense to the cost table
     *       @param expense
     *       @throws CostManagerException
     */

    public void addCost(Expense expense) throws  CostManagerException; 

    /**
     * get list of expenses on specific month
     * * @param month
     *    
     *      @return
     *      @throws CostManagerException
     */

    public List<Expense> getExpenseMonth (String month,String year) throws  CostManagerException;
    /**
     * get list of all the Expense
     *   @return
     *   @throws CostManagerException
     */
    public List<Expense> getExpense () throws  CostManagerException;
    /**
     * get list of expenses on specific day
     * * @param day
     *    
     *      @return
     *      @throws CostManagerException
     */

    public List<Expense> getExpenseDay (Date day) throws  CostManagerException;

    /**
     * add new user 
     * @param user
     * @throws CostManagerException
     */
    public void registration (User user)throws CostManagerException;
    /**
     * login function
     * @param user
     * @throws CostManagerException
     */
    public void login(User user)throws CostManagerException;
    /**
     * get hashMap of Categories
     * @return
     * @throws CostManagerException
     */
    public HashMap<String,Double>getCategoryMap() throws  CostManagerException;

}
