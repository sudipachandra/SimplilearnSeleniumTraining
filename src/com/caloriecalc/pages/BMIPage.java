package com.caloriecalc.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.caloriecalc.objectmap.ObjectRepos;

public class BMIPage {
	//@FindBy(id="cage")
	@FindBy(id=ObjectRepos.BMIPage.bp_age_by_id)
	public WebElement ageTextbox;
	public WebDriver driver = null;
	

	public  BMIPage(WebDriver driver){
		this.driver = driver;
	//	PageFactory.initElements(driver, this);
	}

	public void setAge(String age){
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
	}
}