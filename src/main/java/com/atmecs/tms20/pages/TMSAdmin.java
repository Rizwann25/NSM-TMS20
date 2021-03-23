package com.atmecs.tms20.pages;



import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.tms20.Utils.PropReader;
import com.atmecs.tms20.Utils.Utils;
import com.atmecs.tms20.constant.FilePathConstants;

	public class TMSAdmin extends Utils {
		Browser browser;
		PropReader policyPageProps;			
		
		
		//constructor 
		public TMSAdmin(Browser browser) {
			this.browser = browser;
			policyPageProps = new PropReader(FilePathConstants.ADMIN_PAGE_LOCATOR_PATH);
		}
		
		
		// click on user admin 
		public boolean ClickOnUserAdmin(String textarea) {
			if (isElementPresent(browser, policyPageProps.get(textarea))) {
				browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get(textarea));
				return true;
			}
			return false;
		}
		
		//click on admin
		public boolean ClickOnAdmin(String textarea) {
			if (isElementPresent(browser, policyPageProps.get(textarea))) {
				browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get(textarea));
				return true;
			}
			return false;
		}


}
