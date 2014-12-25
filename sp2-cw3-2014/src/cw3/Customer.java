package cw3;

public interface Customer {

		public int getId();
		public boolean getInElevator();
		public boolean getFinished();
		public void setFinished(final Boolean IS_FINISHED);
		public int getCurrentFloor();
		
		public int getDestinationFloor();
		public Customer clone();
		public void setCurrentFloor(final int FLOOR);
		public void setInElevator(final boolean IN_ELEVATOR)
		
}

