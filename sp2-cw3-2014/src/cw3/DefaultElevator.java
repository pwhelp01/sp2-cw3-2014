/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;


/**
 * Elevator object containing the default algorithm
 * <p>
 * Start at the bottom floor, then go up each floor one and a time to the top.
 * Then come back down one floor at a time again
 * 
 * @author pete
 *
 */
public class DefaultElevator extends AbstractElevator {

	
	/* Methods */
	/*Constructors */
	/**
	 * Creates a new DefaultElevator object
 	 *
	 * @param NO_FLOORS Number of floors in parent building
	 */
	public DefaultElevator(final int NO_FLOORS) {
		
		super(NO_FLOORS);
		
	}
	
	
	/*Other Methods*/
	/**
	 * Move the elevator to the next floor in the current direction
	 * <p>
	 * If the lift is at the top floor, turn around and start coming back down
	 */
	@Override
	protected void move() {
		
		/* If lift is going UP, and there are still floors above: move up */
		if(this.direction == directions.UP) {
			if(this.currentFloor < this.NUM_OF_FLOORS) {
				this.currentFloor++;
				if(this.currentFloor == 13) {
					this.currentFloor++;
				}
				this.moves++;
			}
			/* If the lift is going UP, but has reached the top floor, turn around */
			else if(this.currentFloor == this.NUM_OF_FLOORS) {
				this.direction = directions.DOWN;
			}
		}
		/* If the lift is going down, move to the floor below */
		if(this.direction == directions.DOWN) {
			if(this.currentFloor > 1) {
				this.currentFloor--;
				if(this.currentFloor == 13) {
					this.currentFloor--;
				}
				this.moves++;
			}
		}
		
		/* Set the current floor of each customer in the list to the new floor */
		this.registerList.forEach(c -> c.setCurrentFloor(this.currentFloor));
		
	}


}
