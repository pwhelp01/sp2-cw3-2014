package cw3;

public class CustomerFactory {

	public CustomerFactory() {
		
	}

	public Customer createRandomCustomer(final int noFloors) {
		
		Customer cust = new RandomCustomer(noFloors);
		
		return cust;
		
	}
}
