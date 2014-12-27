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
 * Customer interface indicates that the class implements the methods
 * required by an elevator simulation customer
 * 
 * @author pete
 *
 */
public interface Customer {

	/**
	 * Get the Customer's ID number
	 * 
	 * @return Customer ID
	 */
	public int getId();
	
	/**
	 * Check if the Customer is currently in the Elevator
	 * 
	 * @return True if the Customer is in the Elevator
	 */
	public boolean getInElevator();
	
	/**
	 * Check if the Customer has finished their journey
	 * 
	 * @return True if Customer has reached their destination
	 */
	public boolean getFinished();
	
	/**
	 * Set the Customer's finished state
	 * 
	 * @param IS_FINISHED True if Customer has finished their journey
	 */
	public void setFinished(final Boolean IS_FINISHED);
	
	/**
	 * Get the current floor the Customer is on
	 * 
	 * @return Customer's current floor
	 */
	public int getCurrentFloor();
	
	/**
	 * Get the Customer's destination floor
	 * 
	 * @return The floor the Customer wishes to travel to
	 */
	public int getDestinationFloor();
	
	/**
	 * Clone a Customer object
	 * <p>
	 * Based on Effective Java p.57
	 * @return Clone of the RandomCustomer
	 */
	public Customer clone();
	
	/**
	 * Set the current floor the Customer is on
	 * 
	 * @param FLOOR The floor the Customer is now on
	 */
	public void setCurrentFloor(final int FLOOR);
	
	/**
	 * Add / Remove Customer to/from Elevator
	 * 
	 * @param IN_ELEVATOR State of Customer.  True if in Elevator
	 */
	public void setInElevator(final boolean IN_ELEVATOR);
		
}
