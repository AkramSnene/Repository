package MavenTest.EFORMS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class App {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "First";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("deviceName", "Samsung Galaxy Grand Prime");
		dc.setCapability("udid", "4b132e267da4b200");
		dc.setCapability("platformName", "Android");  
		dc.setCapability("platformVersion", "5.1.1");
    	dc.setCapability("appPackage", "com.eforms.android"); 
		dc.setCapability("appActivity", "com.eforms.android.ui.activity.LauncherActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4799/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testFirst() {
        // new TouchAction(driver).press(35, 373).waitAction(Duration.ofMillis(593)).moveTo(692, 557).release().perform();
        // new TouchAction(driver).press(82, 596).waitAction(Duration.ofMillis(545)).moveTo(496, 407).release().perform();
        // new TouchAction(driver).press(250, 806).waitAction(Duration.ofMillis(406)).moveTo(192, 315).release().perform();
        // driver.findElement(By.xpath("//*[@id='time_min1']")).click();
        // new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Applications']")));
        // driver.findElement(By.xpath("//*[@text='Applications']")).click();
        // new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu_container']")));
        // driver.findElement(By.xpath("//*[@id='menu_container']")).click();
        driver.findElement(By.xpath("//*[@text='eForms']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']")));
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1340Adm");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='OK']")));
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='Configuration']")).click();
      //  new TouchAction(driver).press(239, 420).waitAction(Duration.ofMillis(601)).moveTo(239, 354).release().perform();
      //  new TouchAction(driver).press(239, 420).waitAction(Duration.ofMillis(725)).moveTo(239, 223).release().perform();
        driver.findElement(By.xpath("//*[@id='switch_stationnement']")).click();
        driver.findElement(By.xpath("//*[@id='switch_stationnement']")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}