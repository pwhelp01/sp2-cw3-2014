/**
 * Software and Programming II
 * Coursework: sp2-cw3-2014
 * 
 * Pete Whelpton / Mayra Ribeiro
 * Due Date: 29/12/2014
 * Lecturer: Keith Mannock
 */

package cw3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test Suite incorporating all JUnit tests
 * @author pete
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ BuildingFactoryTest.class, CustomerFactoryTest.class,
		DefaultBuildingTest.class, DefaultElevatorTest.class,
		ElevatorFactoryTest.class, OptimisedElevatorTest.class,
		RandomCustomerTest.class })
public class AllTests {

}
