package com.atmecs.tms20.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.tms20.constant.FilePathConstants;
import com.atmecs.tms20.utils.PropReader;
import com.atmecs.tms20.utils.Utils;
import com.atmecs.falcon.automation.ui.selenium.Verify;

	public class TMS_Verify_Driver extends Utils {
		
		Browser browser;
		PropReader policyPageProps;
		PropReader loginpageProps;

		private ReportLogService report = new ReportLogServiceImpl(TMSLogin.class);

		// constructor
		public TMS_Verify_Driver(Browser browser) {
			this.browser = browser;
			policyPageProps = new PropReader(FilePathConstants.DRIVER_PAGE_LOCATOR_PATH);
			loginpageProps = new PropReader(FilePathConstants.LOGIN_PAGE_LOCATOR_PATH);
		}

		// login
		public boolean Login(String username, String Password) {
			if (isElementPresent(browser, policyPageProps.get(username))) {
				report.info("Entering USN");
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(username),
						loginpageProps.get("username"));

				report.info("Click on next button");
				browser.getClick().waitandclick(LocatorType.XPATH, policyPageProps.get("next_button_link"), 3000);

				if (isElementPresent(browser, policyPageProps.get(Password))) {
					report.info("Entering pwd");
					browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(Password),
							loginpageProps.get("password"));
					report.info("Click signin");
					browser.getClick().waitandclick(LocatorType.XPATH, policyPageProps.get("signin_button_link"), 3000);

				}
				return true;
			}

			return false;
		}

		public boolean Verify(String Verify) {
			if (isElementPresent(browser, policyPageProps.get(Verify))) {
				report.info("verify button link");
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(Verify),
						loginpageProps.get("Verify"));
				browser.getClick().waitandclick(LocatorType.XPATH, policyPageProps.get("verify_button_link"), 3000);
				return true;
			}
			return false;
		}

		public boolean ClickOnLink(String textarea) {
			if (isElementPresent(browser, policyPageProps.get(textarea))) {
				report.info("click on link" + textarea);
				browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get(textarea));
				
				return true;
			}
			return false;
		}

		public boolean enterConglom(String textarea) {

			if (isElementPresent(browser, policyPageProps.get(textarea))) {
				report.info("Entering CONGLOM Value");
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(textarea), "BAH-IND");
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(textarea), Keys.ARROW_DOWN);
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(textarea), Keys.ENTER);
				return true;
			}
			return false;
		}

		public boolean enterConglomparttwo(String textarea) {

			if (isElementPresent(browser, policyPageProps.get(textarea))) {
				report.info("Entering CONGLOM Value");
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(textarea), "BAH-IND");
				browser.getClick().performClick(LocatorType.XPATH,"//*[@id=\"conglom\"]/option[2]");
				return true;
			}
			return false;
		}

		public boolean getData(String textarea) {
			if (isElementPresent(browser, loginpageProps.get(textarea))) {
				report.info("Entering CONGLOM Value");
				browser.getTextField().enterTextField(LocatorType.NAME, "BAH-IND", "select_conglom_link");
				return true;
			}
			return false;
		}

		public boolean validateErrorMessage(String textarea) {
			if (isElementPresent(browser, loginpageProps.get(textarea))) {
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(textarea), "&&");
				WebElement error = browser.getFindFromBrowser().findElementByXpath(policyPageProps.get("errormsg_text"));
				String errortext = error.getText();
				Verify.verifyString(errortext, "No records were found matching the search parameters",
						"Validated error message");
				return true;
			}

			return false;
		}

		public boolean enterFirstname(String username) {
			if (isElementPresent(browser, policyPageProps.get(username))) {
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(username),
						loginpageProps.get("firstname"));

				browser.getClick().waitandclick(LocatorType.XPATH, policyPageProps.get("firstname_link"), 3000);

				return true;
			}

			return false;
		}
		
			 public boolean searchbuttonclick(String button) {
					if (isElementPresent(browser, policyPageProps.get(button))) {
						report.info("click on link" + button);
					//	browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get("searchbutton_link"));
						browser.getClick().waitandclick(LocatorType.XPATH, policyPageProps.get("searchbutton_link"), 3000);
						return true;
					}
					return false;
				}
		
		   public boolean selectRecord(String userdata) {
			if (isElementPresent(browser, policyPageProps.get(userdata))) {
				browser.getTextField().enterTextField(LocatorType.XPATH, policyPageProps.get(userdata),
						loginpageProps.get("firstname"));

				browser.getClick().waitandclick(LocatorType.XPATH, policyPageProps.get("firstname_link"), 3000);

				return true;
			}

			return false;
		}
		
		   public boolean cancelbuttonclick(String button) {
				if (isElementPresent(browser, policyPageProps.get(button))) {
					report.info("click on link" + button);
				//	browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get("searchbutton_link"));
					browser.getClick().waitandclick(LocatorType.XPATH, policyPageProps.get("cancel_button_link"), 3000);
					return true;
				}
				return false;
			}
		
			 public boolean clearbuttonclick(String button) {
					if (isElementPresent(browser, policyPageProps.get(button))) {
						report.info("click on link" + button);
					//	browser.getClick().performClick(LocatorType.XPATH, policyPageProps.get("clear_button_link"));
						browser.getClick().waitandclick(LocatorType.XPATH, policyPageProps.get("clear_button_link"), 3000);
						
						return true;
					}
					return false;
				}

}
