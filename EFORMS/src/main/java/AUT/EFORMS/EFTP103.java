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

public class EFTP103 {
	
	  private String reportDirectory = "reports";
	  private String reportFormat = "xml";
	  private String testName = "EFTP103 Sélectionner une adresse";
	  protected AndroidDriver<AndroidElement> driver = null;
	  DesiredCapabilities dc = new DesiredCapabilities();
	  
	  @BeforeMethod
	  public void setUp() throws MalformedURLException {
	      dc.setCapability("reportDirectory", reportDirectory);
	      dc.setCapability("reportFormat", reportFormat);
	      dc.setCapability("testName", testName);
	      dc.setCapability(MobileCapabilityType.UDID, "W3D7N16321018979");
		  dc.setCapability("appPackage", "com.eforms.android"); 
		  dc.setCapability("appActivity", "com.eforms.android.ui.activity.LauncherActivity");
	      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	      driver.setLogLevel(Level.INFO);
	  }
	  
	  @Test
	  public void TEST103() {
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
		  driver.findElement(By.xpath("//*[@id='forms_spinner']")).click();
		  driver.findElement(By.xpath("//*[@text='Finky-acc']")).click();
      
		  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123");
		  driver.findElement(By.xpath("//*[@text='OK']")).click();
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Configuration']"))); //Connect 

	      driver.findElement(By.xpath("(//*[@id='list_forms']/*/*[@id='label_form'])[5]")).click();
	      
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='streets_searchable_spinner']")));
	      driver.findElement(By.xpath("//*[@id='streets_searchable_spinner']")).click();
		  
	      driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 2000, \"NATIVE\", \"//*[@text='Rue du Cardinal Mercier']\", 0, 1000, 7, false)");
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Rue du Cardinal Mercier']")));
	      driver.findElement(By.xpath("//*[@text='Rue du Cardinal Mercier']")).click();
	      
	      try{Thread.sleep(1000);} catch(Exception ignore){}
		  System.out.println("==> TEST_PASSED <==");
    	  
	  }
	  @AfterMethod
	  public void tearDown()  {
		  
	      driver.quit();
	      System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));
	      

	  }
}
