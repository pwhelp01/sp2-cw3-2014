package cw3;

public class RandomCustomer implements Customer {
	
	static int customerCount = 0;
	int currentFloor;
	int destinationFloor;
	int id;
	boolean inElevator;
	boolean finished;
	
	{
		this.id = RandomCustomer.customerCount++;
		this.inElevator = false;
		this.finished = false;
	}
	
	public RandomCustomer() {
		
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean getInElevator() {
		return this.inElevator;
	}
	
	public boolean getFinished() {
		return this.finished;
	}

	/**
	 * Returns all properties as a string
	 * 
	 */
	 @Override 
	 public String toString() {
		    
		 StringBuilder result = new StringBuilder();
		    String NEW_LINE = System.getProperty("line.separator");

		    result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		    result.append(this.getId() + NEW_LINE);
		    result.append(this.getInElevator() + NEW_LINE);
		    result.append(this.getFinished() + NEW_LINE);
		    result.append("}");

		    return result.toString();
		    
		  }
	
	
	
}
