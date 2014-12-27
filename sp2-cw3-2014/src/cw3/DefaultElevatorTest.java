package cw3;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Unit for DefaultElevator
 * 
 * @author pete
 *
 */
public class DefaultElevatorTest {
	
	private Elevator elev;
	private int NO_FLOORS = 20;
	
	/**
	 * Instantiate a DefaultBuilding for each test
	 */
	@Before
	public void setup() {

		ElevatorFactory elevFact = new ElevatorFactory();
		elev = elevFact.createDefaultElevator(NO_FLOORS);
		
	}
	
	/**
	 * Tear down the DefaultBuilding after each test
	 */
	@After
	public void tearDown() {
		
		elev = null;														
		
	}


	@Test(timeout=3000)
	public void testStart() {
		
		List<Customer> customers = new LinkedList<Customer>();
		CustomerFactory custFactory = new CustomerFactory();
		
		/* Set the number of floors this building has*/
		final int NO_FLOORS = 100;
		final int NO_CUSTOMERS = 300;
		
		/* Create random customers */
		for(int i = 0; i < NO_CUSTOMERS; i++) {
			customers.add(custFactory.createRandomCustomer(NO_FLOORS));
		}
		
		elev.start(customers);
		
		boolean finished = true;
		
		for(Customer cust : customers) {
			if(cust.getFinished() == false) {
				finished = false;
			}
		}
		
		assertTrue(finished);
		
		
	}
	
}