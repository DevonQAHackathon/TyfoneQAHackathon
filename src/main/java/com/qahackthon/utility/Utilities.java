
/*  cretaed by tyfone on 09/09/2017
 *
 * */

package com.qahackthon.utility;


import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*  
 *  Utilities class 
 * */
public class Utilities {
 public static  WebDriver driver=null;
 private WebElement element = null;
 static int counter=0;
 static Logger logger  =Logger.getLogger("devpinoyLogger");	
	
public static WebDriver getDriver() {
		
		if(driver==null){		
				/*getting chrome driver*/
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
     driver = new ChromeDriver();
    logger.info("Got driver to launch");	
		}
					
		return driver;
	}

   /*
    * Method to get object ids from config.properties 
    */
	public String getObjectID(String a)
	{	
		logger.info("Getting object ids from config.properties");
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle(
				"confignew",Locale.getDefault());
				return resourceBundle.getString(a);
	}
	
	
	//---------------------------------------------------
	
		

}
