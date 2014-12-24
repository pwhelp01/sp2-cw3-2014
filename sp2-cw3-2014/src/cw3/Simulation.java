package cw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {
	
	private SimulationProperties props = new SimulationProperties();
	private Building defaultBuilding;
	private Building optimisedBuilding;
	
	
	public Simulation() {
		
		
		
	}

	
	public static void main(String[] args) {
		
		Simulation sim = new Simulation();
		sim.run();
		
	}

	
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
		
		
	}
	
	
	private int readInt(final String PROMPT, final int MIN_VALUE, final int MAX_VALUE) {
		
		/* Check input parameters are valid */
		if(MIN_VALUE > MAX_VALUE) {
			throw new IllegalArgumentException();
		}
		
		Scanner in = new Scanner(System.in);
		int rv = 0;
		
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

	
	private void printWelcome(final String LINE1, final String LINE2) {
		
		/* Print welcome */
		System.out.println();
		System.out.println(LINE1);
		System.out.println(LINE2);
		System.out.println();
		
	}
	

}
