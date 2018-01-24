package autoCourse.automation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicTest {

	WebDriverWrapper driverWrapper;
	
	
	@Before
	public void before() {
	driverWrapper = new WebDriverWrapper();
	driverWrapper.init();
	
	GenericPO.setWebDriver(driverWrapper);
	
	}
	
	@After
	public void after() {
	driverWrapper.printScreen();
	//	driverWrapper.quit();
	}
	
}
