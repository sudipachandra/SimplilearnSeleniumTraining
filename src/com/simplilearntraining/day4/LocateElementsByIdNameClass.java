package com.simplilearntraining.day4;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementsByIdNameClass {
	static WebDriver driver = null;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/bmi-calculator.html");
		//identifying AgeTextbox by id locator 
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		//perform operations
		ageTextbox.clear();
		ageTextbox.sendKeys("45");
		//get all the attribute information for AgeTextbox
		System.out.println("Attribute value of Type = " + ageTextbox.getAttribute("type"));
		System.out.println("Attribute value of Name = " + ageTextbox.getAttribute("name"));

		System.out.println("Attribute value of class = " + ageTextbox.getAttribute("class"));
		System.out.println("Attribute value of Id = " + ageTextbox.getAttribute("id"));
		//The data which is available in the AgeTextbox
		System.out.println("Attribute value of value = " + ageTextbox.getAttribute("value"));
		System.out.println("Tagname of AgeTexbo = " + ageTextbox.getTagName());
		System.out.println("Get Css Value of width = " + ageTextbox.getCssValue("width"));
		WebElement height=driver.findElement(By.name("cheightmeter"));
		height.sendKeys("56");
        WebElement agebox=driver.findElement(By.className("inhalf"));
        agebox.sendKeys("67");
        //import java.util.list
        List<WebElement> genderList  = driver.findElements(By.name("csex"));
        System.out.println("Size of genderList = " + genderList.size());
        if(genderList.size() > 0) //Checking for list size
        {
        	for(WebElement gender: genderList){
        	if(gender.getAttribute("value").equals("f")){
        		if(!gender.isSelected()){
        			gender.click();
        			break;
        		}
        	}
        }
        //Extract WebTable  + identify by class + tagname
    	WebElement tableElement = driver.findElement(By.className("cinfoT"));
        List<WebElement> rows= tableElement.findElements(By.tagName("tr"));
        for(WebElement row:rows){
            List<WebElement> cols=row.findElements(By.tagName("td"));
                for(WebElement col:cols){
                    System.out.print(col.getText() +"\t");
                }
                System.out.println("");
        }
        	
       }
	}
}