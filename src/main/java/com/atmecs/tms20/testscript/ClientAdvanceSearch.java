package com.atmecs.tms20.testscript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.tms20.pages.TMSAdmin;
import com.atmecs.tms20.pages.TMSLogin;
import com.atmecs.tms20.testsuite.SampleTestSuiteBase;

public class ClientAdvanceSearch extends SampleTestSuiteBase{

	private ReportLogService report = new ReportLogServiceImpl(ClientAdvanceSearch.class);

	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void AdminModule(String os, String osVersion, String br, String browserVersion) {
		
		TMSAdmin tmsAdmin = new TMSAdmin(browser);
		TMSLogin tmsLogin = new TMSLogin(browser);
		
	   //Login 
		tmsLogin.Login("login_username_textfield", "login_password_textfield");
		tmsAdmin.ClickOnAdmin("next_button_link");
		
		//Sign In
		tmsAdmin.ClickOnAdmin("signin_button_link");
		
		//Verify Button
		tmsAdmin.ClickOnAdmin("verify_button_link");
		browser.getWait().safeWait(5000);
		
		tmsAdmin.ClickOnAdmin("admin_link");
		
		//Verifying Unlock client
		tmsAdmin.ClickOnAdmin("lock_link");
		tmsAdmin.ClickOnAdmin("unlock_link");
		
		//Click on About
		tmsAdmin.ClickOnAdmin("about_link");
		tmsAdmin.ClickOnAdmin("about2_link");
		
	    //Click on Client Link 
		tmsAdmin.ClickOnAdmin("client_link");
	    //Click on Client Search Link 
		tmsAdmin.ClickOnUserAdmin("client_search_link");
		
		//Click on Search Field
		tmsAdmin.ClickOnAdmin("search_field_link");
		
		//Click on Advance Search
		tmsAdmin.ClickOnAdmin("advance_search_link");
		
		//Click on FirstName
		tmsAdmin.ClickOnAdmin("firstname_link");
		tmsLogin.getData("firstname");
		
		//Click on Conglom
		tmsAdmin.ClickOnAdmin("conglom_link");
		tmsAdmin.ClickOnAdmin("");
		
		//Click on Clear Button
		tmsAdmin.ClickOnAdmin("clear_button_link");
		
	}
}
