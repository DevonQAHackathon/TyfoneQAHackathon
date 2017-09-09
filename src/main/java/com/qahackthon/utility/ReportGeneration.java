/*  cretaed by tyfone on 09/09/2017
 
 * */
package com.qahackthon.utility;

import java.io.IOException;
import java.util.Date;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ReportGeneration {
 public static  ExtentReports extent=null;
 public static  ExtentTest test;

 Utilities utility=new Utilities();
 public WebDriver driver=utility.getDriver();
 static Logger logger  =Logger.getLogger("devpinoyLogger");	
 GetScreenshot s=new GetScreenshot();
 /*  
  *intialising extent report
  * */
	@BeforeSuite
	public static void init(){
		Date date=new Date();
		logger.info("Inside init method in the report generation class");
		
		extent=new ExtentReports(System.getProperty("user.dir")+"/ReportsOfAutomatedtestcases/qahackthon"+date.getTime()+".html");
	
	}
	
	
	@AfterMethod
	  public void getResult(ITestResult result) 
	  {
	  	if(result.getStatus()==ITestResult.FAILURE)
	  	{  		
	  	
	  		String screenshotPath;
	  		
			try {
				
				
				screenshotPath = GetScreenshot.capture(driver, "screenshotName"+s);
				test.log(LogStatus.FAIL, result.getThrowable());
		  		test.log(LogStatus.FAIL, "Screenshot below: "+test.addScreenCapture(screenshotPath));
		  		logger.info("Capturing screen shot for failure test case");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Not able to write into Extent reeport");
			}
	  		
	  	}
	  	
	  	extent.endTest(test);
	  }
	  @AfterSuite
	  public void endreport()
	  {
		  logger.info("Ending Extent report");
	  	extent.flush();
	  	extent.close();
	  }
	

}
