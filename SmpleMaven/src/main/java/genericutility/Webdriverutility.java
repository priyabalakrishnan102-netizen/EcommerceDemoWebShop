package genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Webdriverutility {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void mouseHover(WebDriver driver ,WebElement element) {
		Actions a= new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void ScrollToElement(WebDriver driver ,WebElement element) {
		Actions a= new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void selectDropdown(WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	public void selectDropdown(WebElement element, String value) {
		Select s= new Select(element);
		s.selectByValue(value);
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();		
	}
	public void getPhoto(WebDriver driver) throws IOException {
		Javautility jutil= new Javautility();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenshots/"+jutil.getSystemTime()+".png");
		FileHandler.copy(temp,dest);
		
	}
	
	
	
	
}
