package cw3;

import java.util.ArrayList;
import java.util.List;

public class DefaultElevator implements Elevator {

	final int NUM_OF_FLOORS;
	List<Customer> registerList = new ArrayList<Customer>();
	
	public DefaultElevator(int noFloors) {
		
		this.NUM_OF_FLOORS = noFloors;
		
	}

}
