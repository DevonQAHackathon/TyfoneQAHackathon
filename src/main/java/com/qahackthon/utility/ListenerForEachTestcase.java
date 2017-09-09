/*  cretaed by tyfone on 09/09/2017
 
  */



package com.qahackthon.utility;

import org.apache.log4j.Logger;
import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

/* 
 *listener class to listen to events
 * */
public class ListenerForEachTestcase implements ITestListener {
 static Logger logger  =Logger.getLogger("devpinoyLogger");	

	@Override
	public void onTestStart(ITestResult result) {
		
		logger.info("------------------------------------------------------");	
	    logger.info(result.getName()+" test case started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("The name of the testcase passed is :"+result.getName());
				
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("-----------------------------------------------------------");
		logger.info("The name of the testcase failed is :"+result.getName());
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("---------------------------------------------------------");	
		logger.info("The name of the testcase Skipped is  :"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}
