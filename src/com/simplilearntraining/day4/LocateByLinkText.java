package com.simplilearntraining.day4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LocateByLinkText {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/bmi-calculator.html");
		WebElement BMILink = driver.findElement(By.linkText("BMI"));
		BMILink.click();
		Thread.sleep(2000);
		System.out.println("Title of the Current Page = " + driver.getTitle());
		System.out.println("Title of the Current Url = " + driver.getCurrentUrl());
		String PageSource = driver.getPageSource();
		System.out.println("BMI Page Source = " + PageSource);
		WebElement WeightLink = driver.findElement(By.partialLinkText("Weight"));
		WeightLink.click();
		System.out.println("Title of the Current Page = " + driver.getTitle());
		System.out.println("Title of the Current Url = " + driver.getCurrentUrl());
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("Title of the Current Page = " + driver.getTitle());
		System.out.println("we are in BMI Calculator");
		
		driver.navigate().forward();
		Thread.sleep(2000);
		System.out.println("we are in Ideal Weight Calculator");
		System.out.println("Title of the Current Page = " + driver.getTitle());

		//Lets identify an element Ideal Weight
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.sendKeys("45");
		Thread.sleep(2000);
		//refresh the page
		driver.navigate().refresh();//reload the page
		ageTextbox = driver.findElement(By.id("cage")); //if you include this step after refresh 
		//then we do not get StaleElementReferenceException and can operations on the identified element
		ageTextbox.sendKeys("67"); //This is going to give StaleElementReferenceEzception
		//element is not attached the DOM - after you reload - we require to perform a fresh identification
		
	}
}