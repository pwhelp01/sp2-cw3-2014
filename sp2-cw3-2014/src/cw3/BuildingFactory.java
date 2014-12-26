/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

/**
 * A factory for creating Building objects
 * 
 * @author pete
 *
 */
public class BuildingFactory {

	
	/**
	 * Creates a new BuildingFactory object
	 */
	public BuildingFactory() {
		
	}
	
	
	/**
	 * Returns a new DefaultBuilding object
	 * <p>
	 * The default building object contains customers with randomised 
	 * requirements and an elevator using the default algorithm
	 * 
	 * @param NO_FLOORS Number of floors the building will contain
	 * @param NO_CUSTOMERS  Number of customers needing to use the elevator
	 * @return DefaultBuilding object
	 */
	public Building createDefaultBuilding(final int NO_FLOORS, final int NO_CUSTOMERS) {
		
		Building build = new DefaultBuilding(NO_FLOORS, NO_CUSTOMERS);
		
		return build;
		
	}

}
