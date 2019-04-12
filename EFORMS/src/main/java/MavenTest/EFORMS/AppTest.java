package MavenTest.EFORMS;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testlink.api.java.client.TestLinkAPIResults;
 

public class AppTest {
	
	static DesiredCapabilities caps = new DesiredCapabilities();
	
	@BeforeClass public static void BeforeClass() throws MalformedURLException {	
		
		caps.setCapability("deviceName", "Samsung Galaxy Grand Prime");  //Device Name
		caps.setCapability("udid", "4b132e267da4b200"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");  
		caps.setCapability("platformVersion", "5.1.1");  //Android Version on device
		caps.setCapability("appPackage", "com.eforms.android"); //Play Store App 
		caps.setCapability("appActivity", "com.eforms.android.ui.activity.LauncherActivity");
		caps.setCapability("noReset", "true");
		
		
	 }	
	
	
		  @Test		
		    public void myFirstMethod() throws MalformedURLException{					
		        		
			  AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4799/wd/hub"), caps);
				WebDriverWait driverWait = new WebDriverWait(driver, 10);
				driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eforms.android:id/password")));
				driver.findElement(By.id("com.eforms.android:id/password")).sendKeys("1340Adm");
				driver.findElement(By.id("com.eforms.android:id/user_sign_in_button")).click();
				/*driver.close();*/
				driver.quit();
	
		//Instantiate Appium Driver
			  	
				
				
		
		
//		try {
//			TestLinkIntegration.updateResults("FirstTestCase", null, TestLinkAPIResults.TEST_FAILED);
//			System.out.println("==> TEST_FAILED <==");
//			}
//			catch (Exception e){
//				TestLinkIntegration.updateResults("FirstTestCase", e.getMessage(), TestLinkAPIResults.TEST_PASSED);
//				System.out.println("==> TEST_PASSED <==");
//				}
//		
	}
	
	 @AfterClass public static void AfterClass()	
	 {	
		 System.out.println("==> done <==");
		 
	 }	
 
}