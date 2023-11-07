package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listen implements ITestListener
{
	//this class is for actions on listners for testing
//ITestListener is a interface and all the methods below r defined in that interface, so we can give the body as we want and all those body will be invoked as per their need
	
	//these both objects r for the report
	ExtentReports er;// this is for the entire test
	ExtentTest et;//this is for the method that executed under the main
	Screenshot ss;
	
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Test Started");
		// the parameter has all thge details of the execution, so with that argument we get the current method name and other details
		et.log(LogStatus.INFO, result.getMethod().getMethodName()+" has started");//the log method logs the pass or fail etc detail in the report and also ,logs in the report pie chart
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success");
		
		//for adding the screen shot to report
		try {
			//only this line is required for adding the screenshot to reports, here calling the method we created and it returns the path and this method will fetch the file and add it in report
			et.log(LogStatus.PASS, et.addScreenCapture(ss.screenst())+" Scrrenshot : test has passed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		et.log(LogStatus.FAIL, result.getMethod().getMethodName()+" has failed");
	  }
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("Test Skipped");
		  et.log(LogStatus.SKIP, result.getMethod().getMethodName()+" has skipped");
		  }

		
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  System.out.println("Test failed with success%");
		  }

		
	  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		    System.out.println("Test Failed with timeout");
		  }

		
	  public void onStart(ITestContext context) {
		  System.out.println("TestNG Started");
		  er=new ExtentReports("test-output\\myreport.html");//intialize the extent report
		  et=er.startTest("Test has started:)");//intialize the extent test
		  
		  er.addSystemInfo("Browser","Firefox");//can add system info to report
		  er.addSystemInfo("Build","Smoke Test");
		  
		  ss=new Screenshot();
		  
		  }

		 
	  public void onFinish(ITestContext context) {
		  System.out.println("TestNG Finished");
		  er.endTest(et);//to end the report
		  er.flush();
		  }
}
