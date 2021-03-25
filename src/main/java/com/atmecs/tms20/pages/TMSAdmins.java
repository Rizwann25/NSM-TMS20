package com.atmecs.tms20.pages;

import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.tms20.constant.FilePathConstants;
import com.atmecs.tms20.utils.PropReader;
import com.atmecs.tms20.utils.Utils;

		public class TMSAdmins extends Utils {
			Browser browser;
			PropReader policyPageProps;		
			PropReader loginpageProps;
			
			
			//constructor 
			public TMSAdmins(Browser browser) {
				this.browser = browser;
				policyPageProps = new PropReader(FilePathConstants.ADMIN_PAGE_LOCATOR_PATH);
				loginpageProps  = new PropReader(FilePathConstants.LOGIN_PAGE_LOCATOR_PATH);
			}
			
			
			// click operation
			public boolean ClickOnUserAdmin(String textarea) {
				if (isElementPresent(browser, policyPageProps.get(textarea))) {
					browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get(textarea));
					return true;
				}
				return false;
			}
			
			//click on link
			public boolean ClickOnLink(String textarea) {
				if (isElementPresent(browser, policyPageProps.get(textarea))) {
					browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get(textarea));
					return true;
				}
				return false;
			}
			public boolean validateErrorMessage(String textarea) {
				if (isElementPresent(browser, loginpageProps.get(textarea))) {
				browser.getTextField().enterTextField(LocatorType.XPATH, loginpageProps.get(textarea),"&&");
				WebElement error = browser.getFindFromBrowser().findElementByXpath(loginpageProps.get("errormsg_text"));
				String errortext = error.getText();
				Verify.verifyString(errortext, "No records were found matching the search parameters", "Validated error message");
				return true;
				}

				return false;
				}

}
