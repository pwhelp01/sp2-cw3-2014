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
 * A factory for building Customer objects
 * 
 * @author pete
 *
 */
public class CustomerFactory {

	
	/**
	 * Creates a new CustomerFactory object
	 */
	public CustomerFactory() {
		
	}

	
	/**
	 * Returns a new RandomCustomer object
	 * <p>
	 * RandomCustomers have randomised current and destination floors
	 * 
	 * @param NO_FLOORS Number of floors in the building
	 * @return RandomCustomer Customer with current / destination floors
	 */
	public Customer createRandomCustomer(final int NO_FLOORS) {
		
		Customer cust = new RandomCustomer(NO_FLOORS);
		
		return cust;
		
	}
}
