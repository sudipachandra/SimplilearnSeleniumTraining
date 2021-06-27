package com.simplilearntraining.day5.testNgPack;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleAjaxSuggestion {
	WebDriver driver = null;
	@Test	
	public void HandleAjax(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		//maximize my window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("selenium");
		WebDriverWait wait = new WebDriverWait(driver,30);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbox']/li[1]")));
			List<WebElement> lst = driver.findElements(By.xpath("//*[@role='listbox']/li"));
			System.out.println(lst.size());
			if(lst.size()>0){
				for(WebElement element : lst){
					if(element.getText().equals("selenium python")){
						element.click();
						break;					}
				}
			}
		}catch(NoSuchElementException e){
			System.out.println("List is not Present");
		}
	}
}