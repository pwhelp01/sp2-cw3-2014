/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import java.util.ArrayList;
import java.util.List;

/**
 * Building object containing randomised customers and default elevator
 * 
 * @author pete
 *
 */
public class DefaultBuilding implements Building, Cloneable {
	
	private int noFloors;
	private int noCustomers;
	private List<Customer> customers = new ArrayList<Customer>();
	private Elevator elevator;
	

	/**
	 * Creates a new DefaultBuilding object
	 * <p>
	 * DefaultBuilding has customers with randomised requirements.  As this is
	 * an American building, there will be no floor 13 and the ground floor will
	 * be floor 1
	 * 
	 * @param NO_FLOORS The number of floors 
	 * @param NO_CUSTOMERS The number of customers to populate the building with
	 * @exception IllegalArgumentException Invalid number of floors / customers (e.g. < 1) provided
	 */
	public DefaultBuilding(final int NO_FLOORS, final int NO_CUSTOMERS) throws IllegalArgumentException {
		
		/* Check building has floors and customers */
		if(NO_FLOORS < 1 || NO_CUSTOMERS < 1) {
			throw new IllegalArgumentException();
		}
		
		/* Create factories to build customers and elevator */
		CustomerFactory custFactory = new CustomerFactory();
		ElevatorFactory elevFactory = new ElevatorFactory();
		
		/* Set the number of floors this building has*/
		this.noFloors = NO_FLOORS;
		this.noCustomers = NO_CUSTOMERS;
		
		/* Create random customers */
		for(int i = 0; i < NO_CUSTOMERS; i++) {
			this.customers.add(custFactory.createRandomCustomer(this.noFloors));
		}
		
		/* Create and set a default elevator */
		this.elevator = elevFactory.createDefaultElevator(this.noFloors);
		
	}
	
	
	/**
	 * Start the elevator
	 */
	public void startElevator() {
		this.elevator.start(this.customers);
	}
	
	
	/**
	 * Set the elevator
	 * <p>
	 * Allows the default elevator to be replaced
	 * 
	 * @param NEW_ELEVATOR Elevator to add to the building
	 */
	public void setElevator(final Elevator NEW_ELEVATOR) {
		this.elevator = NEW_ELEVATOR;
	}
	
	
	/**
	 * Get list of customers in the building
	 * 
	 * @return List of customers in the building
	 */
	public List<Customer> getCustomers() {
		return this.customers;
	}
	
	/**
	 * Get the number of moves made by the elevator
	 * 
	 * @return Number of moves made by the building's elevator
	 */
	public int getElevatorMoves() {
		return this.elevator.getMoves();
	}
	
	
	/**
	 * Return contextual information about the DefaultBuilding's
	 * properties
	 * 
	 * @return String representation of the DefaultBuilding
	 */
	@Override
	public String toString() {
		
		/* Create a StringBuilder to concatenate property information */
		StringBuilder result = new StringBuilder();
	    String SEPERATOR = " ";
	    String NEW_LINE = System.getProperty("line.separator");
	    
	    /* Append each property's value to the string */
	    result.append(this.getClass().getName() + SEPERATOR);
	    result.append("{" + NEW_LINE);
	    result.append("noFloors=" + this.noFloors + NEW_LINE);
	    result.append("noCustomers=" + this.noCustomers + NEW_LINE);
	    result.append(this.elevator + NEW_LINE);
	    this.customers.forEach((cust) -> result.append(cust + NEW_LINE));
	    result.append("}");

	    /* Return string */
	    return result.toString();
	    
	}

	
	/**
	 * Deep Clone a DefaultBuilding object
	 * <p>
	 * Based on Effective Java p.57
	 * 
	 * @return Clone of the DefaultBuilding
	 */
	@Override
	public DefaultBuilding clone() {
		
		try {
			
			/* Create new DefaultBuilding Object */
			DefaultBuilding result = (DefaultBuilding) super.clone();
			
			/* Clone primitive properties */
			result.noFloors = this.noFloors;
			result.noCustomers = this.noCustomers;
			
			/* Iterate through customers and clone them */
			List<Customer> clonedCustomers = new ArrayList<Customer>(this.customers.size());
			for(Customer cust : this.customers) {
				clonedCustomers.add(cust.clone());
			}
			
			/* Return result*/
			result.customers = clonedCustomers;
			return result;
		}
		/* An error has occurred */
		catch(CloneNotSupportedException e) {
			throw new AssertionError();
		}
		
	}
}
