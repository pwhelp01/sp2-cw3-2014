package cw3;

import java.util.ArrayList;
import java.util.List;

public class DefaultBuilding implements Building, Cloneable {
	
	private int noFloors;
	private int noCustomers;
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Floor> floors = new ArrayList<Floor>();
	private Elevator elevator;
	

	public DefaultBuilding(final int noFloors, final int noCustomers) {
		
		CustomerFactory custFactory = new CustomerFactory();
		ElevatorFactory elevFactory = new ElevatorFactory();
		
		this.noFloors = noFloors;
		
		for(int i = 0; i < noCustomers; i++) {
			this.customers.add(custFactory.createRandomCustomer(noFloors));
		}
		
		this.elevator = elevFactory.createDefaultElevator(noFloors);
		
	}
	
	
	public void startElevator() {
		this.elevator.start(this.customers);
	}
	
	public void setElevator(Elevator newElevator) {
		this.elevator = newElevator;
	}
	
	
	public List<Customer> getCustomers() {
		return this.customers;
	}
	
	@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder();
	    String SEPERATOR = " ";
	    String NEW_LINE = System.getProperty("line.separator");
	    
	    
	    result.append(this.getClass().getName() + SEPERATOR);
	    result.append("{" + NEW_LINE);
	    result.append("noFloors=" + this.noFloors + NEW_LINE);
	    result.append("noCustomers=" + this.noCustomers + NEW_LINE);
	    result.append(this.elevator + NEW_LINE);
	    this.customers.forEach((cust) -> result.append(cust + NEW_LINE));
	    result.append("}");

	    return result.toString();
	}

	
	/**
	 * Clone a DefaultBuilding object
	 * <p>
	 * Based on Effective Java p.57
	 * @return
	 */
	@Override
	public DefaultBuilding clone() {
		try {
			DefaultBuilding result = (DefaultBuilding) super.clone();
			result.noFloors = this.noFloors;
			result.noCustomers = this.noCustomers;
			
			List<Customer> clonedCustomers = new ArrayList<Customer>(this.customers.size());
			for(Customer cust : this.customers) {
				clonedCustomers.add(cust.clone());
			}
			
			result.customers = clonedCustomers;
			return result;
		}
		catch(CloneNotSupportedException e) {
			throw new AssertionError();
		}
		
	}
}
