package cw3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class SimulationProperties {

	private int minNoFloors;
	private int maxNoFloors;
	private int minNoCustomers;
	private int maxNoCustomers;
	private String floorsPrompt;
	private String customersPrompt;
	private String welcomeLine1;
	private String welcomeLine2;
	
	
	Properties props = new Properties();
	InputStream propsInput=null;
	final String propsFilename="bin/simulation.properties";
	
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

	public int getMinNoFloors() {
		return minNoFloors;
	}

	public int getMaxNoFloors() {
		return maxNoFloors;
	}

	public int getMinNoCustomers() {
		return minNoCustomers;
	}

	public int getMaxNoCustomers() {
		return maxNoCustomers;
	}

	public String getFloorsPrompt() {
		return floorsPrompt;
	}

	public String getCustomersPrompt() {
		return customersPrompt;
	}

	public String getWelcomeLine1() {
		return welcomeLine1;
	}

	public String getWelcomeLine2() {
		return welcomeLine2;
	}
	
	

}
