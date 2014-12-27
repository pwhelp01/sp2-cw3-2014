/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * User changable properties for the elevator simulation
 * <p>
 * Properties are loaded from the file bin/simulation.properties
 * 
 * @author pete
 *
 */
public class SimulationProperties {

	/* Properties */
	private int minNoFloors;
	private int maxNoFloors;
	private int minNoCustomers;
	private int maxNoCustomers;
	private String floorsPrompt;
	private String customersPrompt;
	private String welcomeLine1;
	private String welcomeLine2;
	Properties props = new Properties();
	InputStream propsInput;
	final String propsFilename;
	
	/* Initialisation Block */
	{
		propsInput = null;
		propsFilename = "bin/simulation.properties";
	}
	
	/* Methods */
	/**
	 * Create a new SimulationProperties object
	 */
	public SimulationProperties() {
		
		try {
			
			this.propsInput = new FileInputStream(this.propsFilename);
			this.props.load(propsInput);
			
			this.minNoFloors = Integer.parseInt(props.getProperty("min_nofloors"));
			this.maxNoFloors = Integer.parseInt(props.getProperty("max_nofloors"));
			this.minNoCustomers = Integer.parseInt(props.getProperty("min_nocustomers"));
			this.maxNoCustomers = Integer.parseInt(props.getProperty("max_nocustomers"));
			
			this.floorsPrompt = props.getProperty("floorsPrompt");
			this.customersPrompt = props.getProperty("customersPrompt");
			
			this.welcomeLine1 = props.getProperty("welcomeLine1");
			this.welcomeLine2 = props.getProperty("welcomeLine2");
			
		}
		catch(Exception e) {
			System.out.println("Error loading properties file: Program aborted");
			System.exit(0);
		}
		
		
	}

	/**
	 * Get the minimum number of building floors from the properties file
	 * @return Minimum number of building floors
	 */
	public int getMinNoFloors() {
		return minNoFloors;
	}

	/**
	 * Get the maximum number of building floors from the properties file
	 * @return Maximum number of building floors
	 */
	public int getMaxNoFloors() {
		return maxNoFloors;
	}

	/**
	 * Get the minimum number of customers in the building from the properties file
	 * @return Minimum number of customers
	 */
	public int getMinNoCustomers() {
		return minNoCustomers;
	}

	/**
	 * Get the maximum number of customers in the building from the properties file
	 * @return Maximum number of customers
	 */
	public int getMaxNoCustomers() {
		return maxNoCustomers;
	}

	/**
	 * Get text to display when prompting user to input number of floors
	 * @return Enter floors prompt
	 */
	public String getFloorsPrompt() {
		return floorsPrompt;
	}

	/**
	 * Get text to display when prompting user to input number of customers
	 * @return Enter customers prompt
	 */
	public String getCustomersPrompt() {
		return customersPrompt;
	}

	/**
	 * Get first line of welcome text from the properties file
	 * @return Welcome text line 1
	 */
	public String getWelcomeLine1() {
		return welcomeLine1;
	}

	/**
	 * Get second line of welcome text from the properties file
	 * @return Welcome text line 2
	 */
	public String getWelcomeLine2() {
		return welcomeLine2;
	}

}
