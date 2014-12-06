package cw3;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

	public Simulation() {
		
	}

	public static void main(String[] args) {

		final int noFloors = 20;
		
		CustomerFactory custFact = new CustomerFactory();
		
		Customer[] customers = new Customer[8];
		
		for(int i = 0; i < customers.length; i++) {
			customers[i] = custFact.createCustomer(noFloors);
		}
		
		for(Customer c : customers) {
			System.out.println(c.toString());
		}

	}

}
