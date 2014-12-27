/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import java.util.Scanner;

/**
 * Elevator Simulation
 * <p>
 * Main class for the elevator simulation
 * @author pete
 *
 */
public class Simulation {
	
	private SimulationProperties props = new SimulationProperties();
	private Building defaultBuilding;
	private Building optimisedBuilding;
	
	/**
	 * Construct a new elevator simulation
	 */
	public Simulation() {
		
	}

	/**
	 * Main method for the elevator simulation program
	 * <p>
	 * Constructs a new Simulation instance and run()s it
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		
		Simulation sim = new Simulation();
		sim.run();
		
	}

	/**
	 * Start the elevator simulation
	 * <p>
	 * Gets user input, constructs necessary objects, returns results etc.
	 */
	public void run() {
		
		/* Print Welcome */
		this.printWelcome(this.props.getWelcomeLine1(), this.props.getWelcomeLine2());
		
		int noFloors = 0;
		int noCustomers = 0;
		
		/* Prompt user for no floors */
		noFloors = this.readInt(this.props.getFloorsPrompt(),
				this.props.getMinNoFloors(), this.props.getMaxNoFloors());

		
		/* Prompt user for no customers */
		noCustomers = this.readInt(this.props.getCustomersPrompt(),
				this.props.getMinNoCustomers(), this.props.getMaxNoCustomers());

		
		System.out.println("NoFloors: " + noFloors);
		System.out.println("NoCustomers: " + noCustomers);

		/* Create default building */
		BuildingFactory buildFactory = new BuildingFactory();	
		this.defaultBuilding = buildFactory.createDefaultBuilding(noFloors, noCustomers);

		/* Clone default building into optimised building so we can compare */
		this.optimisedBuilding = this.defaultBuilding.clone();
		
		/* Create and add an optimised elevator */
		ElevatorFactory elevFact = new ElevatorFactory();
		Elevator optElev = elevFact.createOptimisedElevator(noFloors);
		this.optimisedBuilding.setElevator(optElev);
		
		/* Start Elevator in Default Building */
		System.out.println();
		System.out.println("Building with Default Elevator");
		System.out.println("------------------------------");
		
		System.out.println(this.defaultBuilding);
		System.out.println();
		this.defaultBuilding.startElevator();
		System.out.println();
		System.out.println("Elevator Finished");
		System.out.println(this.defaultBuilding);
		
		/* Start Elevator in Optimised Building */
		System.out.println();
		System.out.println("Building with Optimised Elevator");
		System.out.println("------------------------------");
		
		System.out.println(this.optimisedBuilding);
		System.out.println();
		this.optimisedBuilding.startElevator();
		System.out.println();
		System.out.println("Elevator Finished");
		System.out.println(this.defaultBuilding);
		
		/* Summarise results */
		System.out.println();
		System.out.println("Results");
		System.out.println("-------");
		System.out.println("Default Elevator moves=" + this.defaultBuilding.getElevatorMoves());
		System.out.println("Optimised Elevator moves=" + this.optimisedBuilding.getElevatorMoves());
		
		
	}
	
	/**
	 * Prompt the user to input an integer
	 * <p>
	 * Validates input against supplied parameters
	 * 
	 * @param PROMPT Text prompt to display to the user
	 * @param MIN_VALUE Minimum value accepted
	 * @param MAX_VALUE Maximum value accepted
	 * @exception IllegalArgumentException Value input is out of range
	 * @return User input
	 */
	private int readInt(final String PROMPT, final int MIN_VALUE, final int MAX_VALUE)
		throws IllegalArgumentException {
		
		/* Check input parameters are valid */
		if(MIN_VALUE > MAX_VALUE) {
			throw new IllegalArgumentException();
		}
		
		
		int rv = 0;
		Scanner in = new Scanner(System.in);
		
		do {
			try {
				
				System.out.print(PROMPT);
				rv = in.nextInt();
				if(rv > MAX_VALUE || rv < MIN_VALUE) {
					throw new NumberFormatException();
				}
			}
			catch(Exception e) {
				System.out.println("Invalid input!  Please enter a number between "
						+ MAX_VALUE + " and " + MIN_VALUE);
				in.nextLine();
			}
		} while(rv > MAX_VALUE || rv < MIN_VALUE);
		
		return rv;
		
	}

	
	/**
	 * Print two line welcome message to user
	 * 
	 * @param LINE1 First line of welcome message 
	 * @param LINE2 Second line of welcome message
	 */
	private void printWelcome(final String LINE1, final String LINE2) {
		
		/* Print welcome */
		System.out.println();
		System.out.println(LINE1);
		System.out.println(LINE2);
		System.out.println();
		
	}
	

}
