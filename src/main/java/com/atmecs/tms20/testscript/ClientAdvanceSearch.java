package com.atmecs.tms20.testscript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.tms20.pages.TMSLogin;
import com.atmecs.tms20.testsuite.SampleTestSuiteBase;



public class ClientAdvanceSearch extends SampleTestSuiteBase{

	private ReportLogService report = new ReportLogServiceImpl(ClientAdvanceSearch.class);

	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void AdvanceSearch(String os, String osVersion, String br, String browserVersion) {
		
		//TMSAdmin tmsAdmin = new TMSAdmin(browser);
		TMSLogin tmsLogin = new TMSLogin(browser);
		
	   //Login 
		tmsLogin.Login("login_username_textfield", "login_password_textfield");
		
		//Verify Button
		browser.getWait().safeWait(9000);
		
		tmsLogin.ClickOnLink("homesearch_button_link");
		
		//Verifying Unlock client
		//tmsAdmin.ClickOnLink("lock_link");
	//	tmsAdmin.ClickOnLink("unlock_link");
		
		//Click on About
		//tmsAdmin.ClickOnLink("about_link");
		//tmsAdmin.ClickOnLink("about2_link");
		
	    //Click on Client Link 
		tmsLogin.ClickOnLink("client_link");
	    		
		//Click on Advance Search
		tmsLogin.ClickOnLink("advance_search_link");
		
		//First Name
		//tmsLogin.FirstName("firstname");
		
		tmsLogin.enterFirstname("firstname_link");
		
		//Conglom
		browser.getWait().safeWait(3000);
		tmsLogin.ClickOnLink("conglom_link");
		//tmsLogin.getData("select_conglom_link");
		browser.getWait().safeWait(3000);
		tmsLogin.enterConglomparttwo("conglom_link");
		
		browser.getWait().safeWait(3000);

		tmsLogin.searchbuttonclick("searchbutton_link");
		
		browser.getWait().safeWait(3000);
		
		//Validating error message
		 //tmsLogin.validateErrorMessage("errormsg_text");
		 //Select a record
		tmsLogin.selectRecord("record_select_link");
		
		browser.getWait().safeWait(3000);
		tmsLogin.ClickOnLink("cancel_button_link");
		
		//Clear button Click
		tmsLogin.clearbuttonclick("clear_button_link");
		
		
	}
}
