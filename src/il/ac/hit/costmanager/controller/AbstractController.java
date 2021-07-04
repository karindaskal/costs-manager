
package il.ac.hit.costmanager.controller;
import il.ac.hit.costmanager.model.IModel;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */
/**
 * abstract class of controller
 * 
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
