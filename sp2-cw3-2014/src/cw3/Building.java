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
	public Building clone();
	public List<Customer> getCustomers();
	public void startElevator();
}
