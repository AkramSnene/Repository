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

public class EFTP98 {
	
	  private String reportDirectory = "reports";
	  private String reportFormat = "xml";
	  private String testName = "EFTP98 Cliquer sur Retry";
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
	  public void TEST98() {
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
		  driver.findElement(By.xpath("//*[@id='forms_spinner']")).click();
		  driver.findElement(By.xpath("//*[@text='Finky-acc']")).click();
      
		  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123");
		  driver.findElement(By.xpath("//*[@text='OK']")).click();
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Configuration']"))); //Connect 
		  driver.findElement(By.xpath("//*[@text='Configuration']")).click();
		  
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Programme']")));
		  driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 2000, \"NATIVE\", \"//*[@id='switch_recognition']\", 0, 1000, 7, false)");
	      String attribute1 = driver.findElement(By.xpath("//*[@id='switch_recognition']")).getAttribute("checked");
	      
	      if("false".equals(attribute1)) {
	    	  driver.findElement(By.xpath("//*[@id='switch_recognition']")).click();
	      }
	      driver.findElement(By.xpath("//*[@text='OK']")).click();
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='list_forms']/*/*[@id='label_form'])[5]")));
	      driver.findElement(By.xpath("(//*[@id='list_forms']/*/*[@id='label_form'])[5]")).click();
	      
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='camera_button']")));
	      driver.findElement(By.xpath("//*[@id='camera_button']")).click();
		  
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shutter_button']")));
	      driver.findElement(By.xpath("//*[@id='shutter_button']")).click();
	      
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btn_done']")));
	      driver.findElement(By.xpath("//*[@id='btn_cancel']")).click();
	      
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shutter_button']")));
	      
		  System.out.println("==> TEST_PASSED <==");
    	  
	  }
	  @AfterMethod
	  public void tearDown()  {
		  
	      driver.quit();
	      System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));
	      

	  }
}
