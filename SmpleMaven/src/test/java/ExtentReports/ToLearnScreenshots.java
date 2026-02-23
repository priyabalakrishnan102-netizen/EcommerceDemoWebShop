package ExtentReports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnScreenshots {
	@Test
	public void addScreenshot() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		//create an object for ExtentSparkReporter class to pass fle locaton
				ExtentSparkReporter spark= new ExtentSparkReporter("./HTML_Reports/report.html");
				//Cretae an object for ExtentReports class to call ts non statc methods
				ExtentReports report= new ExtentReports();
				//attach reports to the fle path
				report.attachReporter(spark);
				//callng non statc method createTest
				ExtentTest test = report.createTest("createPost");
				// prntng my reports status
				test.log(Status.PASS,"HTML report s generated");
				
				test.addScreenCaptureFromBase64String(screenshot);
				//to collect all the detals at the end we should call flush()
				report.flush();
			}
		
		
	}


