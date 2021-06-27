package com.caloriecalc.testcases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.caloriecalc.utils.PropertyReader;

public class CalorieCalculatorDDTHTTestCase {
	WebDriver driver = null;
	@BeforeClass
	public void LaunchBrowser() throws IOException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.get(PropertyReader.readProperty("appurl"));
		//maximize my window
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getCalorieData")
	//public void EnterCalorieDetails(String age, String sex,String heightmeter){
	public void EnterCalorieDetails(Hashtable<String,String> data) throws InterruptedException{
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys(data.get("age"));
		WebElement height=driver.findElement(By.name("cheightmeter"));
		height.clear();
		height.sendKeys(data.get("heightmeter"));
        List<WebElement> genderList  = driver.findElements(By.name("csex"));
        System.out.println("Size of genderList = " + genderList.size());
        if(genderList.size() > 0) //Checking for list size
        {
        	for(WebElement gender: genderList){
        	if(gender.getAttribute("value").equals(data.get("sex"))){
        		if(!gender.isSelected()){
        			gender.click();
        			break;
        		}
        	}
          }
        }
        Thread.sleep(3000);
	}
	//to indicate this is method that provides testdata - mark it with @DataProvider
	@DataProvider
	public Object[][] getCalorieData(){
		Object[][] data = new Object[2][1];
/*		data[0][0] = "45";
		data[0][1] = "f";
		data[0][2] = "160";
		data[1][0] = "56";
		data[1][1] = "m";
		data[1][2] = "200";
*/		
		Hashtable<String,String> rec1 = new Hashtable<String,String>();
		rec1.put("age","45");
		rec1.put("sex","f");
		rec1.put("heightmeter","160");
		data[0][0] = rec1;		
		
		Hashtable<String,String> rec2 = new Hashtable<String,String>();
		rec2.put("age","56");
		rec2.put("sex","m");
		rec2.put("heightmeter","200");
		data[1][0] = rec2;
		return data;
	}
	@AfterClass
	public void CloseBrowser() throws InterruptedException{
	     Thread.sleep(3000);
		if(driver!=null){
			driver.close(); //close current active browser
			driver.quit(); //all open browser launched via script
		}
	}
}