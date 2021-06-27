package com.simplilearntraining.day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpathPatternMatch {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		List<WebElement> startsiwthidcxpath =  driver.findElements(By.xpath("//*[starts-with(@id,'c')]"));
		System.out.println("identify all elements having attribute id starting with c");
		System.out.println(startsiwthidcxpath.size());
		for(WebElement element :startsiwthidcxpath ){
			System.out.println(element.getAttribute("id"));
		}

		List<WebElement> containsnameheightxpath =  driver.findElements(By.xpath("//*[contains(@name,'height')]"));
		System.out.println("identify all elements havint attribute name containing height");
		System.out.println(containsnameheightxpath.size());
		for(WebElement element :containsnameheightxpath ){
			System.out.println(element.getAttribute("name"));
		}

/*		List<WebElement> endswitidweightxpath =  driver.findElements(By.xpath("//*[ends-with(@id,'weight')]"));
		System.out.println("identify all elements having attribute id ending with weight");
		System.out.println(endswitidweightxpath.size());
		for(WebElement element :endswitidweightxpath ){
			System.out.println(element.getAttribute("id"));
		}
*/	
	}

}