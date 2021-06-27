package com.simplilearntraining.day5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCssPatternMatch {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		List<WebElement> startsiwthidccss =  driver.findElements(By.cssSelector("[id^='c']"));
		System.out.println("identify all elements having attribute id starting with c");
		System.out.println(startsiwthidccss.size());
		for(WebElement element :startsiwthidccss ){
			System.out.println(element.getAttribute("id"));
		}
		List<WebElement> containsnameheightcss =  driver.findElements(By.cssSelector("[name*='height']"));
		System.out.println("identify all elements havint attribute name containing height");
		System.out.println(containsnameheightcss.size());
		for(WebElement element :containsnameheightcss ){
			System.out.println(element.getAttribute("name"));
		}

		List<WebElement> endswitidweightcss =  driver.findElements(By.cssSelector("[id$='weight']"));
		System.out.println("identify all elements having attribute id ending with weight");
		System.out.println(endswitidweightcss.size());
		for(WebElement element :endswitidweightcss ){
			System.out.println(element.getAttribute("id"));
		}
	
	}

}