package com.simplilearntraining.day5.testNgPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleFrames {
	WebDriver driver = null;
	@Test
	public void HandleFrames(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		//maximize my window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);
		//driver.switchTo().frame(0); 
		//driver.switchTo().frame(1); 
		
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement destElement = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement,destElement).build().perform();
		Assert.assertTrue(destElement.getText().equals("Dropped!"));
	}
}