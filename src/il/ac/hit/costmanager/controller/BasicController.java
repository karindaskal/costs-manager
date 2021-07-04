
package il.ac.hit.costmanager.controller;

import il.ac.hit.costmanager.model.IModel;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */

/**
 *  BasicController  extends from  AbstractController
 */

public class BasicController extends AbstractController{

/**
 * constructor get Imodel object
 * @param dao
 */
    public BasicController(IModel dao) {
        super(dao);
    }

    @Override
    public void init() {

    }
}
