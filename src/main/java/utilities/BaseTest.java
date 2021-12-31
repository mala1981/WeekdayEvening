package utilities;

import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	
	public void openApplication() {
		
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./Config/Application.properties");//location of properties file
			prop.load(fis);//load the properties file
			String browserName= prop.getProperty("browsername");//To capture browsername from properties file
			//Chrome 
			if (browserName.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
				//IE
			} else if(browserName.equalsIgnoreCase("IE")) 
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				}
			//Firefox
			else if(browserName.equalsIgnoreCase("FireFox")) 
			{
				WebDriverManager.firefoxdriver().setup();
			
				driver = new FirefoxDriver();
			}
			//No browser maching 
			else
			{
				System.out.println("No browser of your need");
			{
			} 
			driver.manage().deleteAllCookies();//deleting all cookies 
			driver.manage().window().maximize();//maximize application 
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//synchronization time 
			driver.get(prop.getProperty("url"));//Opeaning application
			
					}
				

			}
		 catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		}
	
}




