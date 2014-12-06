package cw3;

public class FloorFactory {

	public FloorFactory() {

	}
	
	public Floor createFloor() {
		
		Floor floor = new BuildingFloor();
		return floor;
	}

}
