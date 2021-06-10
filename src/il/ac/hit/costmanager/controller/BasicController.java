/**
 *  BasicController  extends from  AbstractController
 */
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */
package il.ac.hit.costmanager.controller;

import il.ac.hit.costmanager.model.IModel;

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
