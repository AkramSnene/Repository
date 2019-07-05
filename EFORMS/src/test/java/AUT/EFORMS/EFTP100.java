package AUT.EFORMS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;

import java.net.MalformedURLException;
import java.util.logging.Level;

public class EFTP100 {
	
	  private String reportDirectory = "reports";
	  private String reportFormat = "xml";
	  private String testName = "EFTP100 Cliquer sur le champs Pays";
	  protected AndroidDriver<AndroidElement> driver = null;
	  DesiredCapabilities dc = new DesiredCapabilities();
	  
	  @BeforeMethod
	  public void setUp() throws MalformedURLException {
	      dc.setCapability("reportDirectory", reportDirectory);
	      dc.setCapability("reportFormat", reportFormat);
	      dc.setCapability("testName", testName);
	      dc.setCapability(MobileCapabilityType.UDID, "W3D7N16321018979");
	      dc.setCapability("deviceName","P8 LITE");
		  dc.setCapability("appPackage", "com.eforms.android"); 
		  dc.setCapability("appActivity", "com.eforms.android.ui.activity.LauncherActivity");
	      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	      driver.setLogLevel(Level.INFO);
	  }
	  
	  @Test
	  public void TEST100() {
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
		  driver.findElement(By.xpath("//*[@id='forms_spinner']")).click();
		  driver.findElement(By.xpath("//*[@text='Finky-acc']")).click();
      
		  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123");
		  driver.findElement(By.xpath("//*[@text='OK']")).click();
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Configuration']"))); //Connect 

	      driver.findElement(By.xpath("(//*[@id='list_forms']/*/*[@id='label_form'])[5]")).click();
	      
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='country_spinner']")));
	      driver.findElement(By.xpath("//*[@id='country_spinner']")).click();
		  
	      driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 2000, \"NATIVE\", \"//*[@text='Yougoslavie']\", 0, 1000, 7, false)");
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Yougoslavie']")));
	      
		  System.out.println("==> TEST_PASSED <==");
    	  
	  }
	  @AfterMethod
	  public void tearDown()  {
		  
	      driver.quit();
	      System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));
	      

	  }
}