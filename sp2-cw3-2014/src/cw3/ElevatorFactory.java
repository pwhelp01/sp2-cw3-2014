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
 * A factory for building Elevator objects
 * 
 * @author pete
 *
 */
public class ElevatorFactory {

	/**
	 * Creates a new ElevatorFactory object
	 */
	public ElevatorFactory() {
		
	}
	
	
	/**
	 * Returns a new DefaultElevator object
	 * <p>
	 * DefaultElevators use the default algorithm "Start at the bottom floor, 
	 * then go up each floor one and a time to the top. Then come back down one 
	 * floor at a time again"
	 * 
	 * @param NO_FLOORS
	 * @return RandomCustomer object
	 */
	public Elevator createDefaultElevator(final int NO_FLOORS) {
		
		Elevator elev = new DefaultElevator(NO_FLOORS);
		return elev;
		
	}

	
}
