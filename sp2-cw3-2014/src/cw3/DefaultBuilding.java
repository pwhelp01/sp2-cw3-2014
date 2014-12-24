package cw3;

import java.util.ArrayList;
import java.util.List;

public class DefaultBuilding implements Building, Cloneable {
	
	int noFloors;
	int noCustomers;
	List<Customer> customers = new ArrayList<Customer>();
	List<Floor> floors = new ArrayList<Floor>();
	
	public DefaultBuilding(final int noFloors, final int noCustomers) {
		
		CustomerFactory custFactory = new CustomerFactory();
		
		this.noFloors = noFloors;
		
		for(int i = 0; i < noCustomers; i++) {
			this.customers.add(custFactory.createRandomCustomer(noFloors));
		}
		
		
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder();
	    String SEPERATOR = " ";
	    String NEW_LINE = System.getProperty("line.separator");
	    
	    result.append(this.getClass().getName() + SEPERATOR);
	    result.append("{" + NEW_LINE);
	    customers.forEach((cust) -> result.append(cust + NEW_LINE));
	    result.append("}");

	    return result.toString();
	}

	@Override
	public DefaultBuilding clone() {
		try {
			DefaultBuilding result = (DefaultBuilding) super.clone();
			result.noFloors = this.noFloors;
			result.noCustomers = this.noCustomers;
			result.floors = this.floors.clone();
			result.customers = this.customers.clone();
		}
		catch(CloneNotSupportedException e) {
			throw new AssertionError();
		}
		
	}
}
