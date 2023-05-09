package com.project1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver d;
	@FindBy(id = "username")
	private WebElement username;
	@FindBy(css = "input[placeholder='Password']")
	private WebElement password;
	@FindBy(id = "keepLoggedInCheckBox")
	private WebElement keepLogin;
	@FindBy(id = "loginButton")
	private WebElement loginButton;

	public void setUsername(String username) {
		this.username.sendKeys(username);
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickKeepMeLogin() {
		this.keepLogin.click();
	}

	public void clickLoginButton() {
		this.loginButton.click();
	}
	
	public LoginPage(WebDriver driver) {
		d=driver;
		PageFactory.initElements(driver,this);
	}

	

}
