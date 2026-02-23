package ExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {
	@Test
	public void createTest() {
		//create an object for ExtentSparkReporter class to pass fle locaton
		ExtentSparkReporter spark= new ExtentSparkReporter("./HTML_Reports/");
		//Cretae an object for ExtentReports class to call ts non statc methods
		ExtentReports report= new ExtentReports();
		//attach reports to the fle path
		report.attachReporter(spark);
		//callng non statc method createTest
		ExtentTest test = report.createTest("createPost");
		// prntng my reports status
		test.log(Status.PASS,"HTML report s generated");
		//to collect all the detals at the end we should call flush()
		report.flush();
	}

}


