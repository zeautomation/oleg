package autoCourse.automation;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageObjects {

	public static class homePage extends GenericPO {

		public static void openHomePage() {
			driverWrapper.openUrl("https://www.vroom.com/");
		}

		public static void searchBoxText(String text) {
			WebElement searchBox = driverWrapper.getEelement("hero-search-input", "id");
			searchBox.sendKeys(text);
		}

		public static void clickOnSearch() {
			WebElement searchButton = driverWrapper.getEelement("//*[@class='search-button']", "xpath");
			searchButton.click();

		}

		public static void sortBynewsetModel() {
			WebElement sortButton = driverWrapper.getEelement("//*[@class='dropdown-heading']", "xpath");
			WebElement newsetModel = driverWrapper.getEelement("//a[contains(text(),'Newest Model')]", "xpath");

			driverWrapper.hoverAndClick("//*[@class='dropdown-heading']", "//a[contains(text(),'Newest Model')]");
		}

		public static void waitTillLoad() throws InterruptedException {
			driverWrapper.remoteWebDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}

		public static void clickOnBuy() {
			WebElement buyButton = driverWrapper.getEelement("//*[@id='container']/header/div/nav/ul/li[1]/a", "xpath");
			buyButton.click();
			

		}

		public static void priceAbove300k() {
			WebElement resultlist = driverWrapper.getEelement("cars-section']", "id");
			WebElement firstCarPrice = driverWrapper
					.getEelement("//*[@class='car-list list-unstyled']/li[1]//*[@class='price']", "xpath");
			firstCarPrice.getText();

		}

		public static class ResultLists extends GenericPO {

			public static void priceAbove300k() {
				//WebElement resultlist = driverWrapper.getEelement("cars-section']", "id");
				WebElement firstCarPrice = driverWrapper
						.getEelement("//*[@class='car-list list-unstyled']/li[1]//*[@class='price']", "xpath");
				firstCarPrice.getText();
				System.out.println(firstCarPrice);

			}

		}
	}
}
