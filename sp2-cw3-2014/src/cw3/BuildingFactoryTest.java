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
 * Test Unit for creating new Buildings with Building Factory
 * 
 * @author pete
 *
 */
public class BuildingFactoryTest {
	
	private BuildingFactory buildFact;
	
	/**
	 * Instantiate a BuildingFactory for each test
	 */
	@Before
	public void setup() {
		
		buildFact = new BuildingFactory();										
		
	}
	
	
	/**
	 * Tear down the BuildingFactory after each test
	 */
	@After
	public void tearDown() {
		
		buildFact = null;														
		
	}
	
	
	/**
	 * Test building a perfectly good building
	 */
	@Test
	public void testCreateDefaultBuilding() {
		
		final int NO_FLOORS = 10;
		final int NO_CUSTOMERS = 100;
		
		Building b = buildFact.createDefaultBuilding(NO_FLOORS, NO_CUSTOMERS);
		
		assertNotNull(b);
	}
	
	/**
	 * Test invalid building (should throw an exception)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidCreateDefaultBuilding() throws IllegalArgumentException{
		
		final int NO_FLOORS = -1;
		final int NO_CUSTOMERS = 10;
		
		Building b = buildFact.createDefaultBuilding(NO_FLOORS, NO_CUSTOMERS);
		
	}

}
