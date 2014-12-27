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
 * Elevator interface indicates that the class implements the methods
 * required by an elevator simulation elevator
 * 
 * @author pete
 *
 */
public interface Elevator {

	/**
	 * Starts the elevator using the default algorithm
	 * <p>
	 * Start at the bottom floor, then go up each floor one and a time to the top.
	 * Then come back down one floor at a time again
	 * 
	 * @param customers List of customers in the building waiting for the elevator
	 */
	public void start(List<Customer> customers);
	
	/**
	 * Get the number of moves made by the elevator
	 * 
	 * @return Number of moves
	 */
	public int getMoves();
	
	/**
	 * Get the current floor the elevator is on
	 * 
	 * @return Current floor
	 */
	public int getCurrentFloor();

}
