package com.caloriecalc.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaloriePage {
	
	public WebElement ageTextbox ;
	
	public List<WebElement> genderList;
	
	public WebElement heightmeter;
	WebDriver driver = null; //locally declared in each page class

	public CaloriePage(WebDriver driver) {
	  this.driver = driver;
	}

	public void EnterCalorieDetails(String age,String sex, String heightmeter){
		ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
	       List<WebElement> genderList  = driver.findElements(By.name("csex"));
	        System.out.println("Size of genderList = " + genderList.size());
	        if(genderList.size() > 0) //Checking for list size
	        {
	        	for(WebElement gender: genderList){
	        	if(gender.getAttribute("value").equals(sex)){
	        		if(!gender.isSelected()){
	        			gender.click();
	        			break;
	        		}
	        	}
	        }
	        	
	       WebElement heightmeterTextbox = driver.findElement(By.id("cheightmeter"));
	       heightmeterTextbox.clear();
	       heightmeterTextbox.sendKeys(heightmeter);
	 
		
	   }
	}
}