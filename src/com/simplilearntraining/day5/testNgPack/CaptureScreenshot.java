package com.simplilearntraining.day5.testNgPack;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureScreenshot {
	WebDriver driver = null;
	@Test
	public void CaptureScreenshot() throws IOException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//maximize my window
		driver.manage().window().maximize();
		getScreenshot(driver,"CalorieErrMsg");
	}
	public void getScreenshot(WebDriver driver,String Screenshotname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		//logical file object of the captured screenshot at this point of time is available
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/Screenshots/"+Screenshotname+".png"));

	}
}
