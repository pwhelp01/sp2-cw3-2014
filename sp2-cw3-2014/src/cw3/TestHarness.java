package cw3;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TestHarness {

	public TestHarness() {
		
		
	}

	public static void main(String[] args) {
		
		BuildingFactory buildFact = new BuildingFactory();
		
		Building b1 = buildFact.createDefaultBuilding(3, 10);
		Building b2 = b1.clone();
		
		System.out.println(b1);
		System.out.println("Starting Elevator");
		b1.startElevator();
		
		
	}
	
}
