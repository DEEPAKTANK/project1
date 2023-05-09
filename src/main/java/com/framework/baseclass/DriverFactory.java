package com.framework.baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.framework.util.LogUtility;
import com.framework.util.Webdriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	public static WebDriver driver=null;
	Webdriverutility webutil=new Webdriverutility();
	protected LogUtility log=new LogUtility();
	@BeforeTest
	public void openBrowser() {
//		if (browser.equalsIgnoreCase("Chrome")) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//	if (browser.equalsIgnoreCase("Edge")) {
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//
//	}
	    log.info("Opening browser");

	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	webutil.maximiseWindow(driver);
	
	}
}
