package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtil {
	public static WebDriver driver;
		
	
	/**
	 * This method is used to open the browsers based on arguments passed while calling method
	 * @param browerName
	 * @return
	 *@usage -launchBroser("Chrome")
	 * @param- Chrome/IE/ Firefox
	 */
	
	public  WebDriver launchBrowser(String browerName) {
		//open the browsers based on arguments passed 
		if (browerName.equalsIgnoreCase("Chrome")) {//opening chrome
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		} else if (browerName.equalsIgnoreCase("IE")) {//opening IE
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true); 
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability("ignorZoomSetting", true);//Video 13 in last part
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);//Video 14 in start 
				
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver(caps);
			 
		} else if (browerName.equalsIgnoreCase("FireFoxe")){//opening FireFoxe
				WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
	}else {
		System.out.println("Browse is not matching");
			}
		 driver.manage().deleteAllCookies();//To delete all the cookies
		
		//Implicit Wait
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.manage().window().maximize(); //Maximising the application 
		return driver; // return driver out of this method

	//Mehhod OVerloading Concept --> Plymorphisam (compiletime poly)
//Passing String
	/***
	 * To select the values from drop dowm based on element details passed and int value passed
	 * @param 
	 * @param elemDetails
	 * @param value
	 */
	//public void selectValuefromDropDown(WebElement elemDetails,String value) {
		//Select s = new slect(elemDetail);
			//	s.selectByVisibleText(value);
	
//Passing int 
//public void selectValuefromDropDown(WebElement elemDetails,int value) {
		//Select s = new select(elemDetails);
		//s.selectByIndex(value);
	
	
	}
}

