


package com.qahackthon.utility;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


/*  cretaed by tyfone on 09/09/2017
 * class to created to get screen shot
 * */
public class GetScreenshot
{
	
	static Logger logger  =Logger.getLogger("devpinoyLogger");	
/*  Method to capture screen shot*/
	public static String capture(WebDriver driver, String screenshotName) throws IOException
	{
		logger.info("Capturing screen shot and placing in respective destination");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/Errorscreenshot/"+screenshotName+".png";
		File destination=new File(dest);
		FileUtils.copyFile(source,destination);
		return dest;

	}
}
