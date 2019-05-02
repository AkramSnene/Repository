package MavenTest.EFORMS;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class EFTP95 {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "EFTP96_Cliquer_sur_la_thematique_Stationnement";
  protected AndroidDriver<AndroidElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  @BeforeMethod
  public void setUp() throws MalformedURLException {
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.UDID, "4b132e267da4b200");
	  dc.setCapability("appPackage", "com.eforms.android"); 
	  dc.setCapability("appActivity", "com.eforms.android.ui.activity.LauncherActivity");
      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
      driver.setLogLevel(Level.INFO);
  }

  @Test
  public void EFTP96() {
	  try {
		  
		  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
		  driver.findElement(By.xpath("//*[@id='forms_spinner']")).click();
		  driver.findElement(By.xpath("//*[@text='Finky-acc']")).click();
      
      driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123");
      driver.findElement(By.xpath("//*[@text='OK']")).click();
      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='STATIONNEMENT']")));
      driver.findElement(By.xpath("//*[@text='STATIONNEMENT']")).click();
      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='General Information']")));
      String GeneralInfo = driver.findElement(By.xpath("//*[@text='General Information']")).getText();
      assertEquals(GeneralInfo,"General Information");
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='Revenir en haut de la page']")));
      driver.findElement(By.xpath("//*[@contentDescription='Revenir en haut de la page']")).click();
	  System.out.println("==> TEST_PASSED <==");
	  }
	  catch (Exception e){
	 
	  System.out.println("==> TEST_FAILED  <==");
	 
	  }
  }

  @AfterMethod
  public void tearDown()  {
	  
      driver.quit();
      System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));
      

  }
}