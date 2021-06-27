package com.caloriecalc.grid;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.caloriecalc.objectmap.EnvSettings;
import com.caloriecalc.pages.CaloriePage2;
public class CalorieCalculatorGridTestCase {
	
	DesiredCapabilities cap = null;
	WebDriver driver = null;
	@Parameters("browser")
	@Test
	public void CalorieGridTest(String b) throws MalformedURLException, InterruptedException{
		System.out.println("browser type = " + b);
		if(b.equals("chrome")){
			cap = DesiredCapabilities.chrome();
			
			cap.setBrowserName("chrome");
			//cap.setPlatform(Platform.MAC);
			//cap.setCapability("webdriver.chrome.args", Arrays.asList("-whitelisted-ips=10.0.0.5,10.0.0.7"));
			//cap.setVersion("");
		}
		else if(b.equals("firefox")){
			cap = DesiredCapabilities.firefox();
		}
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//driver = new ChromeDriver();
		driver = new RemoteWebDriver(new URL("http://10.0.0.5:4444/wd/hub"),cap);
		driver.get(EnvSettings.QAEnv.appurl);
		CaloriePage2 cp = new CaloriePage2(driver);
		cp.EnterCalorieDetails("56","f","8");
		Thread.sleep(3000);
		driver.close();
	}
}
