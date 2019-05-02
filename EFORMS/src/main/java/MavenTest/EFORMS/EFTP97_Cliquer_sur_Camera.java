package MavenTest.EFORMS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import testlink.api.java.client.TestLinkAPIClient;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class EFTP97_Cliquer_sur_Camera {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "EFTP97_Cliquer_sur_Camera";
  
  public static String DEVKEY="4ebd72f18419c2c137c5219c172d28bb";
  public static String URL="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

  protected AndroidDriver<AndroidElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  public static void reportResult(String TestProject,String TestPlan,String Testcase,String Build,String Notes,String Result) throws TestLinkAPIException{
	  TestLinkAPIClient api=new TestLinkAPIClient(DEVKEY, URL);
	  api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build, Notes, Result);
	  }

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
  public void EFTP97()  throws TestLinkAPIException {  
	  String testProject="Gmail";
	  String testPlan="SampleTestPlan";
	  String testCase="GmailLogin1";
	  String build="SampleBuild";
	  String notes=null;
	  String result=null;

	  try {
	  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1340Adm");
      driver.findElement(By.xpath("//*[@text='OK']")).click();
      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='CONFIGURATION']")));
      driver.findElement(By.xpath("//*[@text='CONFIGURATION']")).click();
      driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 2000, \"NATIVE\", \"//*[@text='Plate Recognition']\", 0, 1000, 7, false)");
      String attribute1 = driver.findElement(By.xpath("//*[@resource-id='com.eforms.android:id/switch_recognition']")).getAttribute("checked");
      
      if("false".equals(attribute1)) {
    	  driver.findElement(By.xpath("//*[@resource-id='com.eforms.android:id/switch_recognition']")).click();}
      driver.findElement(By.xpath("//*[@text='OK']")).click();
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='STATIONNEMENT']")));
      driver.findElement(By.xpath("//*[@text='STATIONNEMENT']")).click();
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='camera_button']")));
      driver.findElement(By.xpath("//*[@id='camera_button']")).click();
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.FrameLayout' and ./*[@class='android.widget.LinearLayout']]")));
      System.out.println("==> found  <==");
      //TestLinkIntegration.updateResults("Cliquer sur Camera", null, TestLinkAPIResults.TEST_PASSED);
      System.out.println("==> found 2 <==");
      
      result= TestLinkAPIResults.TEST_PASSED;
      notes="Executed successfully";

	  }
	  catch (Exception e){
	  //TestLinkIntegration.updateResults("Cliquer sur Camera", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
	  System.out.println("==> TEST_FAILED  <==");
	  
	  result=TestLinkAPIResults.TEST_FAILED;
	  notes="Execution failed";

	  }
	 // a.reportResult(testProject, testPlan, testCase, build, notes, result);
  }

  @AfterMethod
  public void tearDown() {
	  
      driver.quit();
      System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));
  }
}