package com.framework.baseclass;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.framework.util.JSONutility;
import com.framework.util.LogUtility;
import com.project1.pages.Homepage;
import com.project1.pages.LoginPage;

import freemarker.template.Configuration;
@Listeners(com.framework.util.ListenerUtility.class)
public class TestBase extends DriverFactory{
	protected JSONutility du=new JSONutility();
	protected Homepage home;
	protected LoginPage login;
	
	
	@BeforeSuite
	public void openConn() {
   
	}
	@BeforeClass
	public void openWebApp() {
	    log.info("Open web application");
		driver.get(du.fetchJSON("url", "actitime"));
		 webutil.waitForElementsToLoadInDOM(driver);
	}
	@BeforeMethod
	public void login() throws IOException, ParseException {
		String[] data = du.fetchArrayJSON("data","validcredentials");
		String[] s1 = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			s1 = data[i].split(",");
		}
	    log.info("Login page displayed");
		login=new LoginPage(driver);
		login.setUsername(s1[0]);
		login.setPassword(s1[1]);
		login.clickKeepMeLogin();
		login.clickLoginButton();
	    log.info("login successful");

	
	}
	@AfterMethod
	public void logOut() {
		home=new Homepage(driver);
	home.clickLogoutButtom();
    log.info("Logout successful");

		
	}


	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void closeConn() {
		System.gc();
	}
	

}
