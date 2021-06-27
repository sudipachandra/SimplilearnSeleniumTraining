package com.simplilearntraining.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCss {

	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		WebElement AgeLabelRelCss = driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(1)> td:nth-child(1)"));
		System.out.println("AgeLabel Value  = " + AgeLabelRelCss.getText());
		
	}

}