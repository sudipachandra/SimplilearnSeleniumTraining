package com.simplilearntraining.day5.testNgPack;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingAlertPopups {
	WebDriver driver = null;
	@Test
	public void HandleAlerts() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//maximize my window
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('The username is not valid!');");
		//Verifying the alert message 
		//Closing alert - handling it and continuing with the next operation
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		Thread.sleep(3000);
		alert.accept(); //Click on Ok button of the alert message
		if(alertMsg.equals("The username is not valid!")){
			System.out.println("Alert Msg - Match found");
		}
		else 
		{
			System.out.println("Alert Msg - Match not found");
		}
		js.executeScript("confirm('Do you want to continue(y/n)?');");
		alert = driver.switchTo().alert();
		alertMsg = alert.getText();
		Thread.sleep(3000);
		alert.dismiss(); //Click on Cancel button of the alert message
		if(alertMsg.equals("The username is not valid!")){
			System.out.println("Alert Msg - Match found");
		}
		else 
		{
			System.out.println("Alert Msg - Match not found");
		}
		
	
	}

}