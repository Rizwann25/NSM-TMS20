/***
 *
 */
package com.atmecs.tms20.testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.atmecs.falcon.automation.ui.selenium.Browser;

public class SampleTestSuiteBase {
	public Browser browser;

	protected String os;
	protected String osVersion;
	protected String br;
	protected String browserVersion;
	
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void preSetup(String os, String osVersion, String br, String browserVersion ) {
		
		browser = new Browser();
		browser = new Browser();
		this.os = os;
		this.br = br;
		this.osVersion = osVersion;
		this.browserVersion = browserVersion;
		browser.openURL("https://nsm-eus-t02-wa-tms.azurewebsites.net/", os, osVersion, br, browserVersion);
		browser.maximizeWindow();
	}
	
	@AfterMethod
	public void teardown() {
		browser.closeBrowser();
	}	

}