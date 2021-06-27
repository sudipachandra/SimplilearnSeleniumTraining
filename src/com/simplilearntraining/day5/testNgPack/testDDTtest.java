package com.simplilearntraining.day5.testNgPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDDTtest {
	WebDriver driver = null;
	@BeforeMethod
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//maximize my window
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getCalorieData")
	public void EnterCalorieDetails(String age){
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
		/*
		 * WebElement height=driver.findElement(By.name("cheightmeter"));
		 * height.clear(); height.sendKeys(heightmeter); List<WebElement> genderList =
		 * driver.findElements(By.name("csex"));
		 * System.out.println("Size of genderList = " + genderList.size());
		 * if(genderList.size() > 0) //Checking for list size { for(WebElement gender:
		 * genderList){ if(gender.getAttribute("value").equals(sex)){
		 * if(!gender.isSelected()){ gender.click(); break; } } }
		 */
        }
	
	//to indicate this is method that provides testdata - mark it with @DataProvider
	@DataProvider
	public Object[][] getCalorieData(){
		String[][] data = new String[2][1];
		data[0][0] = "45";
		//data[0][1] = "f";
		//data[0][2] = "160";
		data[1][0] = "56";
		//data[1][1] = "m";
		//data[1][2] = "200";
				
		return data;
	}
	@AfterMethod
	public void CloseBrowser() throws InterruptedException{
	     Thread.sleep(3000);
		if(driver!=null){
			driver.close(); //close current active browser
			driver.quit(); //all open browser launched via script
		}
	}

}