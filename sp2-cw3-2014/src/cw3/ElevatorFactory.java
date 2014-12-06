package cw3;

public class ElevatorFactory {

	public ElevatorFactory() {
		
	}
	
	public Elevator createDefaultElevator(int noFloors) {
		
		Elevator elev = new DefaultElevator(noFloors);
		return elev;
		
	}

}
