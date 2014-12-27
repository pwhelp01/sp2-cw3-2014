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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Unit for creating new Customers with Customer Factory
 * 
 * @author pete
 *
 */
public class CustomerFactoryTest {

	CustomerFactory custFact;
	
	/**
	 * Instantiate a CustomerFactory for each test
	 */
	@Before
	public void setup() {
		
		custFact = new CustomerFactory();										
		
	}
	
	
	/**
	 * Tear down the CustomerFactory after each test
	 */
	@After
	public void tearDown() {
		
		custFact = null;														
		
	}
	
	
	/**
	 * Test building a perfectly good customer
	 */
	@Test
	public void testCreateRandomCustomer() {

		int NO_FLOORS = 25;
		
		Customer c = custFact.createRandomCustomer(NO_FLOORS);
		
		assertNotNull(c);
		
	}

	/**
	 * Test invalid customer (should throw an exception)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidCreateRandomCustomer() throws IllegalArgumentException{
		
		final int NO_FLOORS = -1;
		
		Customer c = custFact.createRandomCustomer(NO_FLOORS);

	}
}
