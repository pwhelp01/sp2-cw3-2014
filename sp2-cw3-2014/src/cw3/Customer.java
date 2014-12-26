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

		public int getId();
		public boolean getInElevator();
		public boolean getFinished();
		public void setFinished(final Boolean IS_FINISHED);
		public int getCurrentFloor();
		public int getDestinationFloor();
		public Customer clone();
		public void setCurrentFloor(final int FLOOR);
		public void setInElevator(final boolean IN_ELEVATOR);
		
}
