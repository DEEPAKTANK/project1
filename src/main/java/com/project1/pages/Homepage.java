package com.project1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver d;
	@FindBy(id = "logoutLink")
	private WebElement logout;
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement task;
	@FindBy(xpath = "//div[text()='Reports']")
	private WebElement reports;
	@FindBy(xpath = "//div[text()='Time-Track']")
	private WebElement timeTrack;
	@FindBy(xpath = "//div[text()='Users']")
	private WebElement users;
	public void clickLogoutButtom() {
		logout.click();
	}
	public void clickTasks() {
		task.click();
	}
	public void clickReports() {
		reports.click();
	}
	public void clickTimeTrack() {
		timeTrack.click();
	}
	public void clickUsers() {
		users.click();
	}
	public Homepage(WebDriver driver) {
		d = driver;
		PageFactory.initElements(driver, this);
	}

}
