package cw3;

public class CustomerFactory {

	public CustomerFactory() {
		
	}

	public Customer createCustomer(final int noFloors) {
		
		Customer cust = new RandomCustomer(noFloors);
		
		return cust;
		
	}
}
