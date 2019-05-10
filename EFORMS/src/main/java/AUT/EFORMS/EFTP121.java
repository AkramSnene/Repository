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

public class EFTP121 {
	  private String reportDirectory = "reports";
	  private String reportFormat = "xml";
	  private String testName = "EFTP121 Remplir le champ Commentaire";
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
	      driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
	      driver.setLogLevel(Level.INFO);
	  }
	  @Test
	  public void TEST121() {
	  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
	  driver.findElement(By.xpath("//*[@id='forms_spinner']")).click();
	  driver.findElement(By.xpath("//*[@text='Finky-acc']")).click();
  
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123");
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Configuration']"))); //Connect 
      driver.findElement(By.xpath("(//*[@id='list_forms']/*/*[@id='label_form'])[5]")).click();
      
      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Informations générales']")));  
      driver.findElement(By.xpath("//*[@id='licence_plate_1']")).sendKeys("1234");
      driver.findElement(By.xpath("//*[@id='licence_plate_2']")).sendKeys("1234");
      
      driver.findElement(By.xpath("//*[@id='country_spinner']")).click();
      driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 2000, \"NATIVE\", \"//*[@text='Belgique']\", 0, 1000, 7, false)");
      driver.findElement(By.xpath("//*[@text='Belgique']")).click();
      
      driver.findElement(By.xpath("//*[@id='streets_searchable_spinner']")).click();
      driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 2000, \"NATIVE\", \"//*[@text='Impasse des Chansons']\", 0, 1000, 7, false)");
      driver.findElement(By.xpath("//*[@text='Impasse des Chansons']")).click();
      
      driver.findElement(By.xpath("//*[@id='address_house_nr_edit_text']")).sendKeys("1234");
      driver.findElement(By.xpath("//*[@id='address_box_edit_text']")).sendKeys("12345");
      driver.hideKeyboard();
      

      driver.findElement(By.xpath("//*[@text='Validation']")).click();
      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='eForms']")));  
      
      driver.findElement(By.xpath("//*[@id='parking_spinner']")).click();
      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Disque non conforme']"))); 
      driver.findElement(By.xpath("//*[@text='Disque non conforme']")).click();
      
      driver.findElement(By.xpath("//*[@id='brand_searchable_spinner']")).click();
      driver.findElement(By.xpath("//*[@text='Audi']")).click();
      
      driver.findElement(By.xpath("//*[@id='color_spinner']")).click();
      driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 2000, \"NATIVE\", \"//*[@text='BRUN']\", 0, 1000, 7, false)");
      driver.findElement(By.xpath("//*[@text='BRUN']")).click();
      
      driver.findElement(By.xpath("//*[@text='Suivant']")).click();
      
      try{Thread.sleep(2000);} catch(Exception ignore){}
      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='comment_edit_text']"))); 
      driver.findElement(By.xpath("//*[@id='comment_edit_text']")).sendKeys("123");
      
      try{Thread.sleep(2000);} catch(Exception ignore){}
	  System.out.println("==> TEST_PASSED <==");
	  }
	  @AfterMethod
	  public void tearDown()  {
		  
	      driver.quit();
	      System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));
	      

	  }
}
