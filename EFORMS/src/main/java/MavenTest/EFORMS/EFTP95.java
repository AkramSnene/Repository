package MavenTest.EFORMS;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import testlink.api.java.client.*;
 

public class EFTP95 {
	static DesiredCapabilities caps = new DesiredCapabilities();
	
	 @BeforeMethod
	  public void beforeMethod() {
		  	caps.setCapability("deviceName", "Samsung Galaxy Grand Prime"); 
			caps.setCapability("udid", "4b132e267da4b200"); 
			caps.setCapability("platformName", "Android");  
			caps.setCapability("platformVersion", "5.1.1");  
			caps.setCapability("appPackage", "com.eforms.android"); 
			caps.setCapability("appActivity", "com.eforms.android.ui.activity.LauncherActivity");
			caps.setCapability("noReset", "true");
	 		}
	 
	 @Test
	 public void f() throws MalformedURLException {
	  
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		WebDriverWait driverWait = new WebDriverWait(driver, 10);

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eforms.android:id/password")));
		driver.findElement(By.id("com.eforms.android:id/password")).sendKeys("1340Adm");
		driver.findElement(By.id("com.eforms.android:id/user_sign_in_button")).click();
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eforms.android:id/setting_btn")));
		driver.findElement(By.id("com.eforms.android:id/setting_btn")).click();
		

        driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 2000, \"NATIVE\", \"//*[@resource-id='com.eforms.android:id/switch_stationnement']\", 0, 1000, 7, false)");
        String stationnement = driver.findElement(By.xpath("//*[@resource-id='com.eforms.android:id/switch_stationnement']")).getText();
        assertEquals(stationnement, "Stationnement DÉSACTIVÉ");
        
        driver.findElement(By.xpath("//*[@resource-id='com.eforms.android:id/switch_stationnement']")).click();
        driver.findElement(By.xpath("//*[@resource-id='com.eforms.android:id/validate_btn']")).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.eforms.android:id/label_form']")));
		driver.quit();
  }
 

  @AfterMethod
  public void afterMethod() throws TestLinkAPIException {
	  
		try {
		TestLinkIntegration.updateResults("FirstTestCase", null, TestLinkAPIResults.TEST_PASSED);
		System.out.println("==> TEST_PASSED <==");
		}
		catch (Exception e){
		TestLinkIntegration.updateResults("FirstTestCase", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		System.out.println("==> TEST_FAILED  <==");
		}
	    System.out.println("==> done <==");
	  
  }

}
