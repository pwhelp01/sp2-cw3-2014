package cw3;

public class CustomerFactory {

	public CustomerFactory() {
		
	}

	public Customer createCustomer() {
		
		Customer cust = new RandomCustomer();
		
		return cust;
		
	}
}
