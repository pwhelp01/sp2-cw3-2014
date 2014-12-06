package cw3;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

	public Simulation() {
		
	}

	public static void main(String[] args) {

		final int noFloors = 20;
		final int noCustomers = 10;
		
		BuildingFactory buildFactory = new BuildingFactory();
		
		
		Building b = buildFactory.createDefaultBuilding(noFloors, noCustomers);
		
		
		System.out.println(b);
		

		
	}

}
