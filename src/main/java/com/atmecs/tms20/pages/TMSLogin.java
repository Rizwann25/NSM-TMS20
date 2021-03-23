package com.atmecs.tms20.pages;



import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.tms20.Utils.PropReader;
import com.atmecs.tms20.Utils.Utils;
import com.atmecs.tms20.constant.FilePathConstants;

	public class TMSLogin extends Utils {
		Browser browser;
		PropReader policyPageProps;			
		PropReader loginpageProps;			
		
		
		//constructor 
		public TMSLogin(Browser browser) {
			this.browser = browser;
			policyPageProps = new PropReader(FilePathConstants.ADMIN_PAGE_LOCATOR_PATH);
			loginpageProps  = new PropReader(FilePathConstants.LOGIN_PAGE_LOCATOR_PATH);
		}
		
		
		//login 
		public boolean Login(String username , String Password ) {
			if (isElementPresent(browser, policyPageProps.get(username))) {
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(username),
						loginpageProps.get("username"));
			
				if (isElementPresent(browser, policyPageProps.get(Password))) {
					browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(Password),
							loginpageProps.get("password"));
				return true;
				}
			}
			return false;
		}
		
		
		public boolean ClickOAdmin(String textarea) {
			if (isElementPresent(browser, policyPageProps.get(textarea))) {
				browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get(textarea));
				return true;
			}
			return false;
		}
		
		public boolean getData(String textarea) {
			if (isElementPresent(browser, policyPageProps.get(textarea))) {
				browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get(textarea));
				return true;
			}
			return false;
		}


}
