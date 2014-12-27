/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import java.util.Random;

/**
 * Customer object with random current and destination floors
 * 
 * @author pete
 *
 */
public class RandomCustomer implements Customer, Cloneable {
	
	/* Properties */
	public static int customerCount = 0;
	private int currentFloor;
	private int destinationFloor;
	private int id;
	private boolean inElevator;
	private boolean finished;
	
	/* Initialisation Block */
	{
		this.id = RandomCustomer.customerCount++;
		this.inElevator = false;
		this.finished = false;
		this.currentFloor = 0;
		this.destinationFloor =0;
	}
	
	/* Methods */
	/* Constructors */
	/**
	 * Creates a new RandomCustomer object
	 * <p>
	 * RandomCustomers have random current and destination floors
	 * 
	 * @param NO_FLOORS The number of floors in the building
	 * @exception IllegalArgumentException Invalid number of floors (e.g. < 1) provided
	 */
	public RandomCustomer(final int NO_FLOORS) throws IllegalArgumentException {
		
		/* Check building has floors */
		if(NO_FLOORS < 1) {
			throw new IllegalArgumentException();
		}

		/* Constant for the minimum number of floors */
		final int MIN = 1;
		
		/* Randomly determine current floor */
		Random rand = new Random();
	    while(this.currentFloor == 0 || this.currentFloor == 13) {
	    	this.currentFloor = rand.nextInt((NO_FLOORS - MIN) + 1) + MIN;
	    }
	    
	    /* Randomly determine destination floor, making sure it is not the same
	     * as the current floor.  Take the lack of a 13th floor into account */
	    while(this.destinationFloor == 0 
	    		|| this.destinationFloor == this.currentFloor
	    		|| this.destinationFloor == 13) {
	    	this.destinationFloor = rand.nextInt((NO_FLOORS - MIN) + 1) + MIN;
	    }
	    
	}
	

	/* Getters & Setters */
	/**
	 * Get the Customer's ID number
	 * 
	 * @return Customer ID
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Check if the Customer is currently in the Elevator
	 * 
	 * @return True if the Customer is in the Elevator
	 */
	public boolean getInElevator() {
		return this.inElevator;
	}
	
	/**
	 * Add / Remove Customer to/from Elevator
	 * 
	 * @param IN_ELEVATOR State of Customer.  True if in Elevator
	 */
	public void setInElevator(final boolean IN_ELEVATOR) {
		this.inElevator = IN_ELEVATOR;
	}
	
	/**
	 * Check if the Customer has finished their journey
	 * 
	 * @return True if Customer has reached their destination
	 */
	public boolean getFinished() {
		return this.finished;
	}
	
	/**
	 * Set the Customer's finished state
	 * 
	 * @param IS_FINISHED True if Customer has finished their journey
	 */
	public void setFinished(final Boolean IS_FINISHED) {
		this.finished = IS_FINISHED;
	}

	/**
	 * Get the current floor the Customer is on
	 * 
	 * @return Customer's current floor
	 */
	public int getCurrentFloor() {
		return this.currentFloor;
	}
	
	/**
	 * Set the current floor the Customer is on
	 * 
	 * @param FLOOR The floor the Customer is now on
	 */
	public void setCurrentFloor(final int FLOOR) {
		this.currentFloor = FLOOR;
	}
	
	/**
	 * Get the Customer's destination floor
	 * 
	 * @return The floor the Customer wishes to travel to
	 */
	public int getDestinationFloor() {
		return this.destinationFloor;
	}
	
	
	/* Other methods */
	/**
	 * Return contextual information about the RandomCustomer's
	 * properties
	 * 
	 * @return String representation of the RandomCustomer
	 */
	@Override 
	public String toString() {
		
		/* Create a StringBuilder to concatenate property information */
		 StringBuilder result = new StringBuilder();
		    String SEPERATOR = " ";
		    
		    /* Append each property's value to the string */
		    result.append(this.getClass().getName() + SEPERATOR);
		    result.append("{" + SEPERATOR);
		    result.append("ID=" + this.getId() + SEPERATOR);
		    result.append("currentFloor=" + this.getCurrentFloor() + SEPERATOR);
		    result.append("destinationFloor=" + this.getDestinationFloor() + SEPERATOR);
		    result.append("inElevator=" + this.getInElevator() + SEPERATOR);
		    result.append("finished=" + this.getFinished() + SEPERATOR);
		    result.append("}");
		    
		    /* Return string */
		    return result.toString();
		    
		  }
	
	
	/**
	 * Clone a Customer object
	 * <p>
	 * Based on Effective Java p.57
	 * @return Clone of the RandomCustomer
	 */
	@Override
	public RandomCustomer clone() {
		try {
			RandomCustomer result = (RandomCustomer) super.clone();
			result.currentFloor = this.currentFloor;
			result.destinationFloor = this.destinationFloor;
			result.finished = this.finished;
			result.id = this.id;
			result.inElevator = this.inElevator;
			return result;
		}
		catch(CloneNotSupportedException e) {
			throw new AssertionError();
		}
		
	}
	
	
}
