package com.framework.util;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class Javautility {
	static CurrentDateAndTime date=new CurrentDateAndTime();
	public static void captureScreenShot(WebDriver driver) {
		
		TakesScreenshot sh = (TakesScreenshot) driver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		File dist = new File("./Screenshots/image"+date.getDateNTime()+".png");
		try {
			Files.copy(src, dist);
		}
		catch (IOException e) {

			e.printStackTrace();
			}
	}	 
}
