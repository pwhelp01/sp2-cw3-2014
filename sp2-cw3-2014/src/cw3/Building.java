package cw3;

import java.util.List;

public interface Building {
	public Building clone();
	public List<Customer> getCustomers();
	public void startElevator();
}
