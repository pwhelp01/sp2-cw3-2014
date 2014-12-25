package cw3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DefaultElevator implements Elevator {

	private final int NUM_OF_FLOORS;
	private List<Customer> registerList = new LinkedList<Customer>();
	private int currentFloor;
	private enum directions {UP, DOWN};
	private directions direction;
	private int moves;
	
	{
		this.currentFloor = 1;
		this.direction = directions.UP;
	}

	
	public DefaultElevator(int noFloors) {
		
		this.NUM_OF_FLOORS = noFloors;
		
		
	}
	
	
	public void start(List<Customer> customers) {
		
		while(!this.isFinished(customers)) {
			System.out.println();
			System.out.println("Current Floor=" + this.currentFloor);
			List<Customer> customersOnFloor = this.getCustomersOnFloor(customers);


			List<Customer> customersToPickup = this.getCustomersToPickup(customersOnFloor);
			System.out.print("Picking up customers: ");
			customersToPickup.forEach(c -> System.out.print(c.getId() + " "));
			customersToPickup.forEach(c -> this.customerJoins(c));
			
			System.out.println();
			List<Customer> customersToDrop = this.getCustomersToDrop();
			System.out.print("Droping off customers: ");
			customersToDrop.forEach(c -> System.out.print(c.getId() + " "));
			customersToDrop.forEach(c -> this.customerLeaves(c));
			
			System.out.println();

			this.move();
		}
		
		
	}
	
	
	private void move() {
		
		if(this.direction == directions.UP) {
			if(this.currentFloor < this.NUM_OF_FLOORS) {
				this.currentFloor++;
				this.moves++;
			}
			else if(this.currentFloor == this.NUM_OF_FLOORS) {
				this.direction = directions.DOWN;
			}
		}
		
		if(this.direction == directions.DOWN) {
			if(this.currentFloor > 1) {
				this.currentFloor--;
				this.moves++;
			}
		}
		
		this.registerList.forEach(c -> c.setCurrentFloor(this.currentFloor));
		
	}

	
	private List<Customer> getCustomersOnFloor(List<Customer> customers) {
		
		return customers.parallelStream()
						.filter(c -> c.getCurrentFloor() == this.currentFloor)
						.filter(c -> c.getInElevator() == false)
						.filter(c -> c.getFinished() == false)
						.collect(Collectors.toCollection(LinkedList::new));
	}
	
	
	private List<Customer> getCustomersToPickup(List<Customer> customers) {
		
		if(this.direction == directions.UP && this.currentFloor < this.NUM_OF_FLOORS){ 
			return customers.parallelStream()
							.filter(c -> c.getDestinationFloor() > this.currentFloor)
							.collect(Collectors.toCollection(LinkedList::new));
		}
		else {
			return customers.parallelStream()
							.filter(c -> c.getDestinationFloor() < this.currentFloor)
							.collect(Collectors.toCollection(LinkedList::new));
		}
	}
	
	
	private List<Customer> getCustomersToDrop() {
		return this.registerList.parallelStream()
								.filter(c -> c.getDestinationFloor() == this.currentFloor)
								.collect(Collectors.toCollection(LinkedList::new));
	}
	
	
	private void customerJoins(Customer cust) {
		this.registerList.add(cust);
		cust.setInElevator(true);
	}
	
	private void customerLeaves(Customer cust) {
		this.registerList.remove(cust);
		cust.setInElevator(false);
		cust.setFinished(true);
	}
	
	private boolean isFinished(List<Customer> customers) {
		
		for(Customer c : customers) {
			if(!c.getFinished()){
				return false;
			}
		}
		
		return true;
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder();
	    String SEPERATOR = " ";
	    String NEW_LINE = System.getProperty("line.separator");
	    
	    
	    result.append(this.getClass().getName() + SEPERATOR);
	    result.append("{" + NEW_LINE);
	    result.append("NUM_OF_FLOORS=" + this.NUM_OF_FLOORS + SEPERATOR);
	    result.append("currentFloor=" + this.currentFloor + SEPERATOR);
	    result.append("moves=" + this.moves + SEPERATOR);
	    result.append("direction=" + this.direction + NEW_LINE);
	    this.registerList.forEach((cust) -> result.append(cust + NEW_LINE));
	    result.append("}");

	    return result.toString();
	}
	
	
	
}
