package com.simplilearntraining.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpath {

	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		WebElement AgeLabelAbsXpath = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/table[1]/tbody/tr[1]/td[1]"));
		System.out.println("AgeLabel Value  = " + AgeLabelAbsXpath.getText());
		WebElement AgeLabelRelXpath = driver.findElement(By.xpath("//*[@id='calinputtable']/tbody/tr[1]/td[1]"));
		System.out.println("AgeLabel Value  = " + AgeLabelRelXpath.getText());
		
	}

}