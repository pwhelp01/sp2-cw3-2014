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
 * Test Unit for creating new Elevators with Elevator Factory
 * 
 * @author pete
 *
 */
public class RandomCustomerTest {

	private Customer cust;
	/**
	 * Instantiate a RandomCustomer for each test
	 */
	@Before
	public void setup() {
		
		cust = new RandomCustomer(100);										
		
	}
	
	/**
	 * Tear down the RandomCustomer after each test
	 */
	@After
	public void tearDown() {
		
		cust = null;
		
	}
	
	/**
	 * Test constructor
	 */
	@Test
	public void testRandomCustomer() {
		
		final int NO_FLOORS = 40;
		Customer c = new RandomCustomer(NO_FLOORS);
		
		assertNotNull(c);
		
	}

	/**
	 * Test invalid constructor
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidRandomCustomer() {
		
		Customer c = new RandomCustomer(0);
		
	}
	
	/**
	 * Test customer get in elevator returns result
	 */
	@Test
	public void testGetInElevator() {
		
		assertFalse(cust.getInElevator());
		
	}

	/**
	 * Test customer gets in elevator
	 */
	@Test
	public void testSetInElevator() {
		
		cust.setInElevator(true);
		assertTrue(cust.getInElevator());
		
	}

	/**
	 * Test that clone method produces a different object
	 */
	@Test
	public void testClone() {
		
		Customer cust2 = cust.clone();
		assertNotSame(cust, cust2);
		
	}

}
