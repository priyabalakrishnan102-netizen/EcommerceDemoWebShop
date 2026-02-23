package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class Listenerutility extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.INFO, "test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getName();
		Reporter.log(methodname+" has be passed",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "test execution failed");
		TakesScreenshot ts= (TakesScreenshot)driver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		try {
			wu.getPhoto(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getName();
		Reporter.log(methodname+" has been skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	
}
