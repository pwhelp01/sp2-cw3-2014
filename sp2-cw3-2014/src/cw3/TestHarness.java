/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Scrappy class to test the algorithms head-to-head 100 times
 * @author pete
 *
 */
public class TestHarness {

	/**
	 * Create a new TestHarness
	 */
	public TestHarness() {
		
		
	}
	
	/**
	 * Run TestHarness class
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] noFloors = new int[100];
		int [] noCust = new int[100];
		int [] defaultMoves = new int[100];
		int[] optimisedMoves = new int[100];
		
		

		
		for(int i = 0; i < 100; i++) {
			
			Random rand = new Random();
			
		    int randFloors = rand.nextInt((163 - 1) + 1) + 1;
		    int randCust = rand.nextInt((1000 - 1) + 1) + 1;
			
			BuildingFactory buildFact = new BuildingFactory();
			ElevatorFactory elevFact = new ElevatorFactory();
			
			Building b1 = buildFact.createDefaultBuilding(randFloors, randCust);
			Building b2 = b1.clone();
			b2.setElevator(elevFact.createOptimisedElevator(randFloors));
			
			
			System.out.println(b1);
			System.out.println("Starting Default Elevator");
			b1.startElevator();
			
			System.out.println();
			
			System.out.println(b2);
			System.out.println("Starting Optimised Elevator");
			b2.startElevator();
			
			System.out.println();
			System.out.println("Default Elevator moves: " + b1.getElevatorMoves());
			System.out.println("Optimised Elevator moves: " + b2.getElevatorMoves());
			
			noFloors[i] = randFloors;
			noCust[i] = randCust;
			defaultMoves[i] = b1.getElevatorMoves();
			optimisedMoves[i] = b2.getElevatorMoves();
		}
		
		System.out.println("Floors");
		for(int i : noFloors) {
			System.out.println(i);
		}
		
		System.out.println("Customers");
		for(int i : noCust) {
			System.out.println(i);
		}
		
		System.out.println("Deafult Moves");
		for(int i : defaultMoves) {
			System.out.println(i);
		}
		
		System.out.println("Optimised Moves");
		for(int i : optimisedMoves) {
			System.out.println(i);
		}
		
	}
	
}
