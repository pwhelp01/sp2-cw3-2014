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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Elevator object containing the optimised algorithm
 * <p>
 * The optimised Elevator maintains priority queues of the floors that
 * customers need to be collected / delivered to, and only stops at those
 * floors
 * 
 * @author pete
 *
 */
public class OptimisedElevator extends AbstractElevator {

	/* Properties */
	Queue<Integer> goingUpQueue = new PriorityQueue<Integer>();
	Queue<Integer> goingDownQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
	int highestFloorToVisit;
	
	
	/* Constructor */
	/**
	 * Creates a new OptimisedElevator object
 	 *
	 * @param NO_FLOORS Number of floors in parent building
	 */
	public OptimisedElevator(final int NO_FLOORS) {
		super(NO_FLOORS);
	}
	
	
	/* Business Logic */
	/**
	 * Starts the elevator using the optimised
	 * <p>
	 * The elevator maintains queues of floors that need to be visited on the way
	 * up and the way down, and only stops at those floors
	 * 
	 * @param CUSTOMERS List of customers in the building waiting for the elevator
	 */
	@Override
	public void start(final List<Customer> CUSTOMERS) {
		
		/* Get queue of Customers going up */
		this.goingUpQueue = this.getGoingUpQueue(CUSTOMERS);
		
		/* Get queue of Customers going down */
		this.goingDownQueue = this.getGoingDownQueue(CUSTOMERS);

		this.goingDownQueue.forEach(i -> System.out.println(i.toString()));
		
		/* Call parent start() method */
		super.start(CUSTOMERS);
	
	}
	
	
	/**
	 * Move the elevator to the next floor in the current direction
	 * <p>
	 * If the lift is at the top floor, turn around and start coming back down
	 */
	@Override
	protected void move() {
		
		/* If lift is going UP, and there are still floors above: move up */
		if(this.direction == directions.UP && !this.goingUpQueue.isEmpty()) {
			if(this.goingUpQueue.peek() == this.currentFloor) {
				this.goingUpQueue.remove();
			}
			this.currentFloor = this.goingUpQueue.peek();
			this.goingUpQueue.remove();
			this.moves++;
		}
		/* If the lift is going UP but there are no more floors to visit */
		else if(this.direction == directions.UP && this.goingUpQueue.isEmpty()) {
				this.direction = directions.DOWN;
				if(this.goingDownQueue.peek() == this.currentFloor) {
					this.goingDownQueue.remove();
				}
				
		}
		
		/* If the lift is going down, move to the floor below */
		if(this.direction == directions.DOWN && !this.goingDownQueue.isEmpty()) {
			this.currentFloor = this.goingDownQueue.peek();
			this.goingDownQueue.remove();
			this.moves++;
		}
		
		
		/* Set the current floor of each customer in the list to the new floor */
		this.registerList.forEach(c -> c.setCurrentFloor(this.currentFloor));
		
	}
	
	
	/**
	 * Create a queue of floors the Elevator needs to visit on the way UP
	 * @param CUSTOMERS List of all Customers in the Building
	 * @return Queue of floors to visit in order
	 */
	private Queue<Integer> getGoingUpQueue(final List<Customer> CUSTOMERS) {
		
		/* Get a stream of all customers going up */
		List<Customer> goingUp =  CUSTOMERS.parallelStream()
										  .filter(c -> c.getDestinationFloor() > c.getCurrentFloor())
										  .collect(Collectors.toCollection(ArrayList::new));
		
		/* Get the 'going up' customers' start and end floors, so we know where to stop */
		IntStream currentFloors = goingUp.parallelStream()
										 .mapToInt(Customer::getCurrentFloor);
		IntStream destinationFloors = goingUp.parallelStream()
											 .mapToInt(Customer::getDestinationFloor);
		
		/* Combine, sort and make distinct the stream and return as a queue */
		return IntStream.concat(currentFloors, destinationFloors)
						.distinct()
						.sorted()
						.boxed()
						.collect(Collectors.toCollection(PriorityQueue::new));
	}

	
	/**
	 * Create a queue of floors the Elevator needs to visit on the way DOWN
	 * @param CUSTOMERS List of all Customers in the Building
	 * @return Queue of floors to visit in order
	 */
	private Queue<Integer> getGoingDownQueue(final List<Customer> CUSTOMERS) {
		
		/* Get a stream of all customers going up */
		List<Customer> goingDown =  CUSTOMERS.parallelStream()
											 .filter(c -> c.getDestinationFloor() < c.getCurrentFloor())
											 .collect(Collectors.toList());
		
		/* Get the 'going down' customers' start and end floors, so we know where to stop */
		IntStream currentFloors = goingDown.stream()
										   .mapToInt(Customer::getCurrentFloor);
		IntStream destinationFloors = goingDown.stream()
											   .mapToInt(Customer::getDestinationFloor);
		

		/* Combine, reverse sort and make distinct the stream and return as a queue */ 
		Queue<Integer> result = new PriorityQueue<Integer>(Collections.reverseOrder());  
				 
		IntStream.concat(currentFloors, destinationFloors) 
				 .distinct() 
				 .boxed() 
				 .forEach(i -> result.add(i)); 
				 
		return result; 

	}
	
	

	/**
	 * Get a list of customers to pickup from a list of customers on the same floor
	 * 
	 * @param CUSTOMERS List of customers on one floor to check for those who need
	 * picking up
	 * @return List of customers to pick up
	 */
	@Override
	protected List<Customer> getCustomersToPickup(final List<Customer> CUSTOMERS) {
		
		/* Get customers going in the same direction as the lift, if it is going up */
		if(this.direction == directions.UP && !this.goingUpQueue.isEmpty()){ 
			return CUSTOMERS.parallelStream()
							.filter(c -> c.getDestinationFloor() > this.currentFloor)
							.collect(Collectors.toCollection(LinkedList::new));
		}
		/* Get customers going in the same direction as the lift, if it is going down */
		else {
			return CUSTOMERS.parallelStream()
							.filter(c -> c.getDestinationFloor() < this.currentFloor)
							.collect(Collectors.toCollection(LinkedList::new));
		}
	}
	
}
