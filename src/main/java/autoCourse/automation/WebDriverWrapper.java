package autoCourse.automation;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper {

	RemoteWebDriver remoteWebDriver;

	

public void printScreen() {

		WebDriver augmentedDriver = new Augmenter().augment(remoteWebDriver);
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

		copyFile(screenshot, System.getProperty("user.dir") + "\\files\\scr\\" + screenshot.getName());
	}

	public static void copyFile(File source, String destinationPath) {
		try {
			InputStream in = new FileInputStream(source);
			try {
				OutputStream out = new FileOutputStream(new File(destinationPath));
				try {
					// Transfer bytes from in to out
					byte[] buf = new byte[1024];
					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
				} finally {
					out.close();
				}
			} finally {
				in.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	public void hoverAndClick(String xpathInitialize, String xpathToClick){
		WebElement element = getEelement(xpathInitialize, "xpath");
		
		Actions actions = new Actions(remoteWebDriver);
		actions.moveToElement(element).build().perform();
		remoteWebDriver.findElementByXPath(xpathToClick).click();
//		actions.moveToElement(element).moveToElement(remoteWebDriver.findElementByXPath(xpathToClick)).click();
		
	}
	
	DesiredCapabilities capabilites = DesiredCapabilities.chrome();

	public void init() {
		remoteWebDriver = new RemoteWebDriver(capabilites);

	}
	
	public void openUrl(String url) {
		remoteWebDriver.get(url);
	}
	
public List<WebElement> findLostOfElements(By xpath){
	WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 20, 1000);
	List<WebElement> elementsList = null;
	
	try {
		elementsList = driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	
	return elementsList;
}
	WebElement getEelement(String value, String type) {
		WebElement element = null;

		WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 10, 1000);

		try {
			if (type.equals("xpath")) {
				element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			} else if (type.equals("id")) {
				element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
			}
		} catch (Exception e) {
			printScreen();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return element;

	}

	public void quit() {
		remoteWebDriver.quit();
	}
}
