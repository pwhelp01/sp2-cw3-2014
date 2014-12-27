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

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Unit for DefaultBuilding
 * 
 * @author pete
 *
 */
public class DefaultBuildingTest {

	private Building build;
	private final int NO_FLOORS = 20;
	private final int NO_CUSTOMERS = 30;
	final int NOT_MOVED = 0;
	
	/**
	 * Instantiate a DefaultBuilding for each test
	 */
	@Before
	public void setup() {
		
		
		
		BuildingFactory buildFact = new BuildingFactory();
		build = buildFact.createDefaultBuilding(NO_FLOORS, NO_CUSTOMERS);
		
	}
	
	/**
	 * Tear down the DefaultBuilding after each test
	 */
	@After
	public void tearDown() {
		
		build = null;														
		
	}
	

	/**
	 * Check that the elevator moves when started
	 */
	@Test
	public void testStartElevator() {
		
		// Elevator hasn't started yet, so moves should be ZERO
		assertTrue(build.getElevatorMoves() == NOT_MOVED);
		
		// Start Elevator moving
		build.startElevator();
		
		// Elevator should have moved, so moves should be > ZERO
		assertTrue(build.getElevatorMoves() > NOT_MOVED);
	}

	/**
	 * Check that the elevator can be replaced
	 */
	@Test
	public void testSetElevator() {
		
		ElevatorFactory elevFact = new ElevatorFactory();
		Elevator el = elevFact.createOptimisedElevator(NO_FLOORS);
		
		build.setElevator(el);
		
		// Elevator hasn't started yet, so moves should be ZERO
		assertTrue(build.getElevatorMoves() == NOT_MOVED);
				
		// Start Elevator moving
		System.out.println("Starting Optimised Elevator");
		build.startElevator();
				
		// Elevator should have moved, so moves should be > ZERO
		assertTrue(build.getElevatorMoves() > NOT_MOVED);
		
		System.out.println();
		System.out.println("Moves=" + build.getElevatorMoves());
		
	}
	
	/**
	 * Test a list of customers is returned
	 */
	@Test
	public void testGetCustomers() {

		List<Customer> customers = build.getCustomers();
		assertFalse(customers.isEmpty());
		
	}
	
	/**
	 * Check that the correct number of moves is returned
	 */
	@Test
	public void testGetElevatorMoves() {
		
		// 20 storey building, should skip 13th floor
		final int EXPECTED_MOVES = 36;
		
		build.startElevator();
		int actualMoves = build.getElevatorMoves();
		
		assertTrue(actualMoves == EXPECTED_MOVES);
		
	}
	

	/**
	 * Test that clone works (creates a new building rather than copying
	 * references)
	 */
	@Test
	public void testClone() {

		Building build2 = build.clone();
		
		List<Customer>buildCustomers = build.getCustomers();
		List<Customer>build2Customers = build2.getCustomers();
		
		/* Overridden clone() should have created new Customer objects, not just
		 * reused references
		 */
		assertFalse(buildCustomers == build2Customers);
		
	}

}
