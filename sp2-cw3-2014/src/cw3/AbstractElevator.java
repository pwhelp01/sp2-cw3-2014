/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public abstract class AbstractElevator implements Elevator {
	
	/* Properties */
	protected final int NUM_OF_FLOORS;
	protected List<Customer> registerList = new LinkedList<Customer>();
	protected int currentFloor;
	protected enum directions {UP, DOWN};
	protected directions direction;
	protected int moves;
	
	/* Initialisation Block */
	{
		this.currentFloor = 1;
		this.direction = directions.UP;
	}

	
	public AbstractElevator(final int NO_FLOORS) {
		this.NUM_OF_FLOORS = NO_FLOORS;
	}
	
	
	/**
	 * Starts the elevator using the default algorithm
	 * <p>
	 * Start at the bottom floor, then go up each floor one and a time to the top.
	 * Then come back down one floor at a time again
	 * 
	 * @param CUSTOMERS List of customers in the building waiting for the elevator
	 */
	public void start(final List<Customer> CUSTOMERS) {
		
		/* Loop whilst customers still need to get to their destination */
		while(!this.isFinished(CUSTOMERS)) {
			
			/* Get list of customers on current floor */
			System.out.println();
			System.out.println("Current Floor=" + this.currentFloor);
			List<Customer> customersOnFloor = this.getCustomersOnFloor(CUSTOMERS);

			/* Check the customers on this floor for those going in the same
			 * direction as the elevator, and pick them up
			 */
			List<Customer> customersToPickup = this.getCustomersToPickup(customersOnFloor);
			System.out.print("Picking up customers: ");
			customersToPickup.forEach(c -> System.out.print(c.getId() + " "));
			customersToPickup.forEach(c -> this.customerJoins(c));
			
			/* Check customers already in the elevator if they want to get off
			 * at this floor, and if so drop them
			 */
			System.out.println();
			List<Customer> customersToDrop = this.getCustomersToDrop();
			System.out.print("Droping off customers: ");
			customersToDrop.forEach(c -> System.out.print(c.getId() + " "));
			customersToDrop.forEach(c -> this.customerLeaves(c));
			
			/* Move elevator to next floor */
			System.out.println();
			this.move();
		}
		
	}
	
	
	protected abstract void move();
	
	public int getMoves() {
		return this.moves;
	}
	
	/**
	 * Get a list of all customers on the same floor as the elevator
	 * <p>
	 * Filters out customers already in the elevator or have finished their 
	 * journey
	 * 
	 * @param CUSTOMERS List of all customers in building
	 * @return LinkedList of customers on the same floor as the elevator
	 */
	protected List<Customer> getCustomersOnFloor(final List<Customer> CUSTOMERS) {
		
		return CUSTOMERS.parallelStream()
						.filter(c -> c.getCurrentFloor() == this.currentFloor)
						.filter(c -> c.getInElevator() == false)
						.filter(c -> c.getFinished() == false)
						.collect(Collectors.toCollection(LinkedList::new));
	}
	
	
	/**
	 * Get a list of customers to pickup from a list of customers on the same floor
	 * 
	 * @param CUSTOMERS List of customers on one floor to check for those who need
	 * picking up
	 * @return List of customers to pick up
	 */
	protected List<Customer> getCustomersToPickup(final List<Customer> CUSTOMERS) {
		
		/* Get customers going in the same direction as the lift, if it is going up */
		if(this.direction == directions.UP && this.currentFloor < this.NUM_OF_FLOORS){ 
			return CUSTOMERS.parallelStream()
							.filter(c -> c.getDestinationFloor() > this.currentFloor)
							.collect(Collectors.toCollection(LinkedList::new));
		}
		/* Get customers going in the same direction as the lift, if it is going down */
		else {
			return CUSTOMERS.parallelStream()
							.filter(c -> c.getDestinationFloor() < this.currentFloor)
							.collect(Collectors.toCollection(LinkedList::new));
		}
	}
	
	
	/**
	 * Get a list of customers to drop off 
	 * 
	 * @return List of customers that want to get off at this floor
	 */
	private List<Customer> getCustomersToDrop() {
		return this.registerList.parallelStream()
								.filter(c -> c.getDestinationFloor() == this.currentFloor)
								.collect(Collectors.toCollection(LinkedList::new));
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
	
	
	/**
	 * Add a customer into the elevator
	 * 
	 * @param cust Customer that wants to get in the Elevator
	 */
	protected void customerJoins(Customer cust) {
		this.registerList.add(cust);
		cust.setInElevator(true);
	}
	
	
	/**
	 * Remove a customer from the elevator
	 * <p>
	 * Customers leave when they finish their journey
	 * @param cust Customer that wants to leave the Elevator
	 */
	protected void customerLeaves(Customer cust) {
		this.registerList.remove(cust);
		cust.setInElevator(false);
		cust.setFinished(true);
	}
	

}
