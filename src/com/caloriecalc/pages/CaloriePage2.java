package com.caloriecalc.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.caloriecalc.objectmap.ObjectRepos;
import com.caloriecalc.utils.PropertyReader;

public class CaloriePage2 {
	@FindBy(id=ObjectRepos.CaloriePage.cp_age_by_id)
	//@FindBy(id="cage")
	public WebElement ageTextbox ;
	@FindBy(name=ObjectRepos.CaloriePage.cp_genderList_by_name)
	//@FindBy(name="csex")
	public List<WebElement> genderList;
	
	@FindBy(xpath="//*[@id='cheightmeter']")
	public WebElement heightmeterTextbox;

	@FindBy(xpath=ObjectRepos.CaloriePage.cp_heightfeet_by_xpath)
	public WebElement heightfeetTextbox;
	
	//@FindBy(linkText = "BMI")
	@FindBy(linkText = ObjectRepos.CaloriePage.cp_bmi_linktext)
	public WebElement BMILink;
	
	WebDriver driver = null; //locally declared in each page class
	 
	public CaloriePage2(WebDriver driver) {
	  this.driver = driver;
	  //PageFactory Initialization
	  PageFactory.initElements(driver, this);
	}

	public void EnterCalorieDetails(String age,String sex, String heightfeet){
	//	ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
	//       List<WebElement> genderList  = driver.findElements(By.name("csex"));
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
	        	
	//   WebElement heightmeterTextbox = driver.findElement(By.id("cheightmeter"));
	 //  heightmeterTextbox.clear();
	 //  heightmeterTextbox.sendKeys(heightmeter);
	 	heightfeetTextbox.clear();
	 	heightfeetTextbox.sendKeys(heightfeet);
	   }
	    
	}

	   public BMIPage BMILinkClick() {
		   BMILink.click();
		   return new BMIPage(driver);
	   }

}