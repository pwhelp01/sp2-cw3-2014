package cw3;

public class BuildingFactory {

	public BuildingFactory() {
		
	}
	
	public Building createDefaultBuilding(int noFloors, int noCustomers) {
		
		Building build = new DefaultBuilding(noFloors, noCustomers);
		
		return build;
		
	}

}
