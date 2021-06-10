package il.ac.hit.costmanager.model;

import java.util.Objects;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */

/**
 * Category class  contain string category
 */

public class Category {
	private String category;
    private int id;
    /**
     * empty constructor
     */
    public Category() {
		super();
	}
/**
 * constructor get category
 * @param category
 * @throws CostManagerException 
 */
	public Category(String category) throws CostManagerException {
        setCategory(category);
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
/**
 * get category
 * @return
 */
	
    public String getCategory() {
        return category;
    }
    /**
     * set category
     * @param category
     * @throws CostManagerException 
     */

    public void setCategory(String category) throws CostManagerException {
    	if(category.isEmpty())
    	{
    		
			  throw new  CostManagerException("category can't be empty"); 
			  }

        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category1 = (Category) o;
        return Objects.equals(category, category1.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }

    @Override
    public String toString() {
        return ""+
                 category +"";
    }
}
