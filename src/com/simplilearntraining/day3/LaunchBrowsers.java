package com.simplilearntraining.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowsers {
	static String browser = "chrome";
	static WebDriver driver = null; // it is an interface implementing all the browser classes - ChromeDriver,FirefoxDriver,InternetExplorer
	public static void main(String[] args) throws InterruptedException {
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
				
		}else if(browser.equals("firefox")){
			//Launch Firefox
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
				
		}
		else if(browser.equals("ie")){
			//in ie - there are 2 additional settings that needs to be done
			System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		//shortcut is Ctrl+Shift+O
		driver.get("http://www.google.com");
		Thread.sleep(3000);
		driver.close();
		//Launch internet Explorer
	}
}