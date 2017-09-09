package com.qahackthon.hackthondemo.Login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import com.relevantcodes.extentreports.LogStatus;
import com.qahackthon.pageobject.LoginPage;
import com.qahackthon.utility.ReportGeneration;
import com.qahackthon.utility.Utilities;
import org.apache.log4j.Logger;

@Listeners(com.qahackthon.utility.ListenerForEachTestcase.class)
public class LoginTestcases extends ReportGeneration {
	 Utilities utility1=new Utilities();
	 public Actions a=new Actions(driver);
		private Assertion hardAssert = new Assertion();
		Logger logger  =Logger.getLogger("devpinoyLogger");	
		LoginPage obj=new LoginPage();
		

	
  @Test (priority=0)		
	public void launch() throws InterruptedException, IOException
	
	{ 
		/* Loging data using log 4j */
		logger.info("Executing launch test method");
		/*Writing InvalidLogin test method to  extent report*/
		test=extent.startTest("launch");	
		driver.manage().window().maximize();
		//driver.get(utility1.getTenant(Integer.parseInt(utility1.getOrgID()),"Url"));
		driver.get(utility1.getObjectID("url"));
		test.log(LogStatus.PASS, "Test passed");
		
}
  @Test (priority=1)		
 	public void login() throws InterruptedException, IOException
 	
 	{ 
 		/* Loging data using log 4j */
 		logger.info("Executing login test method");
 		test=extent.startTest("login");
 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		driver.findElement(By.id(utility1.getObjectID(obj.HOME_ID))).click();
 		String title = driver.getTitle();
 		driver.findElement(By.id(utility1.getObjectID(obj.USER_ID))).sendKeys((utility1.getObjectID(obj.USERNAME_DATA)));
 		driver.findElement(By.id(utility1.getObjectID(obj.PASSWORD_ID))).sendKeys((utility1.getObjectID(obj.PASSWORD_DATA)));
 		driver.findElement(By.xpath(utility1.getObjectID(obj.BUTTON_ID))).click();
 		hardAssert.assertEquals(title, utility1.getObjectID(obj.LOGIN_PAGE_TITLE));
 		test.log(LogStatus.PASS, "Test passed");
 		
 }
  
  @Test (priority=2)		
	public void editProfile() throws InterruptedException, IOException
	
	{ 
		/* Loging data using log 4j */
		logger.info("Executing login test method");
		test=extent.startTest("editProfile");
		
		driver.findElement(By.className((utility1.getObjectID(obj.VIEWPROFILE_CLASS)))).click();
		driver.findElement(By.linkText((utility1.getObjectID(obj.PROFILEEDIT_LINK)))).click();
		driver.findElement(By.className((utility1.getObjectID(obj.PROFILE_SAVE_CLASS)))).click();
		//driver.findElement(By.id((utility1.getObjectID(obj.CONFIRMATION_MSG)))).click();
		
		
		String stext = driver.findElement(By.id((utility1.getObjectID(obj.CONFIRMATION_MSG)))).getText();
		System.out.println(stext);
		//hardAssert.assertEquals(stext, utility1.getObjectID(obj.EDIT_SUCCESS));
}
}
