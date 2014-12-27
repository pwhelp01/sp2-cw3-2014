/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Unit for OptimisedElevator
 * 
 * @author pete
 *
 */
public class OptimisedElevatorTest {
	private Elevator elev;
	private int NO_FLOORS = 20;
	
	/**
	 * Instantiate a OptimisedElevator for each test
	 */
	@Before
	public void setup() {

		ElevatorFactory elevFact = new ElevatorFactory();
		elev = elevFact.createOptimisedElevator(NO_FLOORS);
		
	}
	
	/**
	 * Tear down the OptimisedElevator after each test
	 */
	@After
	public void tearDown() {
		
		elev = null;														
		
	}

	/**
	 * Test the start method of the elevator
	 */
	@Test(timeout=3000)
	public void testStart() {
		
		List<Customer> customers = new LinkedList<Customer>();
		CustomerFactory custFactory = new CustomerFactory();
		
		/* Set the number of floors this building has*/
		final int NO_CUSTOMERS = 30;
		
		/* Create random customers */
		for(int i = 0; i < NO_CUSTOMERS; i++) {
			customers.add(custFactory.createRandomCustomer(NO_FLOORS));
		}
		
		while(!isFinished(customers)) {
			elev.start(customers);
		}
		
		assertTrue(isFinished(customers));
		
		
	}
	
	/**
	 * Check a list of Customers and return true if they have all completed
	 * their journey
	 * 
	 * @param CUSTOMERS List of Customers to check
	 * @return True if all customers have completed their journey
	 */
	protected boolean isFinished(final List<Customer> CUSTOMERS) {
		
		/* Iterate through each customer, if anyone still has to journey
		 * return false
		 */
		for(Customer c : CUSTOMERS) {
			if(!c.getFinished()){
				return false;
			}
		}
		/* Otherwise, all customers have completed their journey, so return 
		 * true
		 */
		return true;
	}
	
}