package com.atmecs.tms20.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class Utils {
	private static ReportLogService report = new ReportLogServiceImpl(Utils.class);

	// to find element in page of browser using Xpath
	public WebElement findElement(Browser browser, String xpath) {
		return browser.getFindFromBrowser().findElementByXpath(xpath);
	}

	// giving explicitly wait to avoid no element found exception
	public static boolean isElementPresent(Browser browser, String xpath) {
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), 5000);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
		} catch (Exception exception) {
			report.info("waited for " + 5000 + " Seconds for \"" + xpath + "\"");// to print with double codes
		}
		return true;
	}

}
