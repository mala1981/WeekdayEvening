

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseUtil;

public class TC003_LoginIntoSurveryMonkeyApplication extends BaseUtil {
	BaseUtil b = new BaseUtil();
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.xpath("//Button[@type='submit']");
	By dashboardLnk = By.linkText("Dashboard");
	
	
	@Test (priority = 1)
		public void invokeApplication() {
			b.launchBrowser("Chrome");
			driver.get("https://www.surveymonkey.com/user/sign-in/?ut_ctatext=Log%20in&ut_source=sem_lp&ut_source2=sem&ut_source3=megamenu");
			driver.manage().deleteAllCookies();
	}
	@Test (priority = 2)
		public void loginIntoApplication() {
			driver.findElement(username).sendKeys("seleniumtraining1");
			driver.findElement(password).sendKeys("selenium1234");
			driver.findElement(loginBtn).click();
			String expVal = "Dashboard";
			String actVal =  ((WebElement) driver.findElements(dashboardLnk)).getText();
			 
			Assert.assertEquals(actVal,expVal);
			
			// Check that login is successful
			/* String actVal =  driver.findElements(dashboardLnk).getText();
			 		
			if (actVal.equalsIgnoreCase(expVal)) {
				System.out.println("Logged in successfully");
			} else {
				System.out.println("Login failed");
*/
			}
	@Test (priority = 3)
			public void logout() {
				driver.quit();
			}
		}
		
		

