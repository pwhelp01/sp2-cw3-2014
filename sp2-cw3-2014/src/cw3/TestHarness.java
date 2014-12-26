package cw3;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TestHarness {

	public TestHarness() {
		
		
	}

	public static void main(String[] args) {
		
		BuildingFactory buildFact = new BuildingFactory();
		ElevatorFactory elevFact = new ElevatorFactory();
		
		Building b1 = buildFact.createDefaultBuilding(10, 8);
		Building b2 = b1.clone();
		b2.setElevator(elevFact.createOptimisedElevator(10));
		
		
		System.out.println(b1);
		System.out.println("Starting Default Elevator");
		b1.startElevator();
		
		System.out.println();
		System.out.println("Starting Optimised Elevator");
		b2.startElevator();
		
		System.out.println();
		System.out.println("Default Elevator moves: " + b1.getElevatorMoves());
		System.out.println("Optimised Elevator moves: " + b2.getElevatorMoves());
		
	}
	
}
