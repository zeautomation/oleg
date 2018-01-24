package autoCourse.automation;

import javax.xml.xpath.XPath;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import autoCourse.automation.PageObjects.homePage;
import autoCourse.automation.PageObjects.homePage.ResultLists;

public class VroomTest extends BasicTest{


//	@Test
//	public void search() throws Exception {
//		homePage.openHomePage();
//		homePage.searchBoxText("mazda");
//		homePage.clickOnSearch();
//		System.out.println("Now we will sort the page by newest model");
//		//homePage.sortBynewsetModel();
//		homePage.waitTillLoad();
//		driverWrapper.printScreen();
//		
//	
//	}
	
	@Test
	public void mostExpensive() throws Exception {
		homePage.openHomePage();
		homePage.clickOnBuy();
		driverWrapper.hoverAndClick("//*[@class='dropdown-heading']", "//*[@id='cars-section']/div/div[3]/div/div/div/ul/li[3]/a");
		ResultLists.priceAbove300k();
	}
}
