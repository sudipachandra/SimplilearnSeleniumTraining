package com.caloriecalc.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.caloriecalc.pages.BMIPage;
import com.caloriecalc.pages.CaloriePage2;
import com.caloriecalc.utils.PropertyReader;

public class CalorieCalculatorPageTestCase {
	WebDriver driver = null;
	@Test
	public void EnterCalorieDetails() throws IOException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.get(PropertyReader.readProperty("appurl"));
		//maximize my window
		driver.manage().window().maximize();
		//Page Object Model (POM with out PageFactory)
	//	CaloriePage cp = new CaloriePage(driver); //driver object is passed as an argument to the page class
	//	cp.EnterCalorieDetails("45", "f", "160");
		
		//Page Object Model (POM with PageFactory)
		CaloriePage2 cp2 = new CaloriePage2(driver); //driver object is passed as an argument to the page class
		cp2.EnterCalorieDetails("45", "f", "4");
		//BMIPage bmi = cp2.BMILinkClick();
		//bmi.setAge("39");
		cp2.BMILink.click();
		BMIPage bmi = new BMIPage(driver);
		bmi = PageFactory.initElements(driver, BMIPage.class);
		bmi.setAge("67");	
	}
}