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
public class ElevatorFactoryTest {

	private ElevatorFactory elevFact;
	
	/**
	 * Instantiate a ElevatorFactory for each test
	 */
	@Before
	public void setup() {
		
		elevFact = new ElevatorFactory();										
		
	}
	
	
	/**
	 * Tear down the BuildingFactory after each test
	 */
	@After
	public void tearDown() {
		
		elevFact = null;														
		
	}
	
	
	/**
	 * Test building a perfectly good default elevator
	 */
	@Test
	public void testCreateDefaultElevator() {
		
		final int NO_FLOORS = 10;
		
		Elevator e = elevFact.createDefaultElevator(NO_FLOORS);
		
		assertNotNull(e);
		
	}
	
	/**
	 * Test invalid default elevator (should throw an exception)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidCreateDefaultElevator() throws IllegalArgumentException{
		
		final int NO_FLOORS = 0;
		
		Elevator e = elevFact.createDefaultElevator(NO_FLOORS);
		
	}
	
	
	/**
	 * Test building a perfectly good default elevator
	 */
	@Test
	public void testCreateOptimisedElevator() {
		
		final int NO_FLOORS = 10;
		
		Elevator e = elevFact.createOptimisedElevator(NO_FLOORS);
		
		assertNotNull(e);
		
	}
	
	/**
	 * Test invalid default elevator (should throw an exception)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidCreateOptimisedElevator() throws IllegalArgumentException{
		
		final int NO_FLOORS = 0;
		
		Elevator e = elevFact.createDefaultElevator(NO_FLOORS);
		
	}
}
