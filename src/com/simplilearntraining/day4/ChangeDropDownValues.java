package com.simplilearntraining.day4;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangeDropDownValues {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		WebElement activity = driver.findElement(By.id("cactivity"));
		//select dropdown values
		Select dd = new Select(activity);
		//Retrieve the default displayed value
		System.out.println("Default selected dropdown value = " + dd.getFirstSelectedOption().getText());

		//Basal Metabolic Rate (BMR)
		dd.selectByIndex(0);
		Thread.sleep(2000);
		System.out.println("Changed dropdown value by index = 0 - Basal =  " + dd.getFirstSelectedOption().getText());

		//Light: exercise 1-3 times/week
		dd.selectByValue("1.375");
		//Extra Active: very intense exercise daily, or physical job
		Thread.sleep(2000);
		System.out.println("Changed dropdown value by value = 1.375 - Light Exercise =  " + dd.getFirstSelectedOption().getText());

		dd.selectByVisibleText("Extra Active: very intense exercise daily, or physical job");
		Thread.sleep(2000);
		System.out.println("Changed dropdown value by Viisble Text - Extra Active =  " + dd.getFirstSelectedOption().getText());
		//if it is multiselect dropdown or not
		System.out.println("Is dropdown multiselect = " + dd.isMultiple());
		//in the dropdown select tag - if you find multiple = true - then it is multi select dropdown
		//if you are using multi select dropdown - then you will make use of deselect methods
		//dd.deselectAll();
		//dd.deselectByIndex(arg0);
		WebElement sedentryOpt = driver.findElement(By.xpath("//*[@id='cactivity']/option[text()='Sedentary: little or no exercise']"));
		System.out.println(sedentryOpt.getText());
		WebElement activeOpt = driver.findElement(By.xpath("//*[@id='cactivity']/option[starts-with(text(),'Active')]"));
		System.out.println(activeOpt.getText());
		
		List<WebElement> activeOptLst = driver.findElements(By.xpath("//*[@id='cactivity']/option[contains(text(),'Active')]"));
		for(WebElement active:activeOptLst){
			System.out.println(active.getText());
		}
	}
}