/*  cretaed by tyfone on 09/09/2017
 *
 * */
package com.qahackthon.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/*  class for to re execute failed test cases
 *
 * */
public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 3;
	/*
	 * (non-Javadoc)
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 * 
	 * This method decides how many times a test needs to be rerun.
	 * TestNg will call this method every time a test fails. So we 
	 * can put some code in here to decide when to rerun the test.
	 * 
	 * Note: This method will return true if a tests needs to be retried
	 * and false it not.
	 *
	 */

	@Override
	public boolean retry(ITestResult result) {

		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
