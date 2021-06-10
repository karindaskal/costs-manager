
package il.ac.hit.costmanager.controller;
import il.ac.hit.costmanager.model.IModel;
/**
 * abstract class of controller
 * 
 */
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */


public abstract class AbstractController {

    protected IModel dao;
  
    /**
     * constructor get Imodel object
     * @param dao
     */

    AbstractController(IModel dao) {
        this.dao = dao;
    }
   /**
    * init function
    */

    public abstract void init();
}
