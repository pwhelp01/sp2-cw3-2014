/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import java.util.List;

/**
 * Building interface indicates that the class implements the methods
 * required by an elevator simulation building
 * 
 * @author pete
 *
 */
public interface Building {
	
	/**
	 * Deep Clone a Building object
	 * <p>
	 * Based on Effective Java p.57
	 * 
	 * @return Clone of the DefaultBuilding
	 */
	public Building clone();
	
	/**
	 * Get list of customers in the building
	 * 
	 * @return List of customers in the building
	 */
	public List<Customer> getCustomers();
	
	/**
	 * Start the building's elevator
	 */
	public void startElevator();
	
	/**
	 * Set the elevator
	 * <p>
	 * Allows the default elevator to be replaced
	 * 
	 * @param NEW_ELEVATOR Elevator to add to the building
	 */
	public void setElevator(final Elevator NEW_ELEVATOR);
	
	/**
	 * Get the number of moves made by the elevator
	 * 
	 * @return Number of moves made by the building's elevator
	 */
	public int getElevatorMoves();
}
