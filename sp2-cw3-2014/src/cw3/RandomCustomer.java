package cw3;

import java.util.Random;

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
	
	/* Constructors */
	public RandomCustomer(final int noFloors) {
		
		final int MIN = 1;
		
		/* Randomly determine current floor */
		Random rand = new Random();
	    while(this.currentFloor == 0 || this.currentFloor == 13) {
	    	this.currentFloor = rand.nextInt((noFloors - MIN) + 1) + MIN;
	    }
	    
	    /* Randomly determine destination floor */
	    while(this.destinationFloor == 0 
	    		|| this.destinationFloor == this.currentFloor
	    		|| this.destinationFloor == 13) {
	    	this.destinationFloor = rand.nextInt((noFloors - MIN) + 1) + MIN;
	    }
	    
	}
	
	/* Methods */
	/* Getters & Setters */
	public int getId() {
		return this.id;
	}
	
	public boolean getInElevator() {
		return this.inElevator;
	}
	
	public void setInElevator(final boolean IN_ELEVATOR) {
		this.inElevator = IN_ELEVATOR;
	}
	
	public boolean getFinished() {
		return this.finished;
	}
	
	public void setFinished(final Boolean IS_FINISHED) {
		this.finished = IS_FINISHED;
	}

	public int getCurrentFloor() {
		return this.currentFloor;
	}
	
	public void setCurrentFloor(final int FLOOR) {
		this.currentFloor = FLOOR;
	}
	
	public int getDestinationFloor() {
		return this.destinationFloor;
	}
	
	
	/* Other methods */
	/**
	 * Returns all properties as a string
	 * 
	 */
	@Override 
	public String toString() {
		
		 StringBuilder result = new StringBuilder();
		    String SEPERATOR = " ";

		    result.append(this.getClass().getName() + SEPERATOR);
		    result.append("{" + SEPERATOR);
		    result.append("ID=" + this.getId() + SEPERATOR);
		    result.append("currentFloor=" + this.getCurrentFloor() + SEPERATOR);
		    result.append("destinationFloor=" + this.getDestinationFloor() + SEPERATOR);
		    result.append("inElevator=" + this.getInElevator() + SEPERATOR);
		    result.append("finished=" + this.getFinished() + SEPERATOR);
		    result.append("}");

		    return result.toString();
		    
		  }
	
	
	/**
	 * Clone a Customer object
	 * <p>
	 * Based on Effective Java p.57
	 * @return
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
