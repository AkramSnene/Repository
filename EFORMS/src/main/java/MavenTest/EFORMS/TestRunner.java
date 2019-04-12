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
	import java.net.MalformedURLException;
	import java.util.logging.Level;

	public class TestRunner {
	    private String reportDirectory = "reports";
	    private String reportFormat = "xml";
	    private String testName = "2";
	    protected AndroidDriver<AndroidElement> driver = null;

	    DesiredCapabilities dc = new DesiredCapabilities();
	    
	    @BeforeMethod
	    public void setUp() throws MalformedURLException {
	        dc.setCapability("reportDirectory", reportDirectory);
	        dc.setCapability("reportFormat", reportFormat);
	        dc.setCapability("testName", testName);
	        dc.setCapability(MobileCapabilityType.UDID, "4b132e267da4b200");
	        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);
	    }

	    @Test
	    public void test_2() {
	        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1340Adm");
	        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='OK']")));
	        driver.findElement(By.xpath("//*[@text='OK']")).click();
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='CONFIGURATION']")));
	        driver.findElement(By.xpath("//*[@text='CONFIGURATION']")).click();
	        driver.executeScript("seetest:client.elementListSelect(\"\", \"//*[@resource-id='com.eforms.android:id/switch_stationnement']\", 0, true)");
	        driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 150, 1000, \"NATIVE\", \"//*[@resource-id='com.eforms.android:id/switch_stationnement']\", 0, 500, 7, false)");
	        String text1 = driver.findElement(By.xpath("//*[@resource-id='com.eforms.android:id/switch_stationnement']")).getText();
	        driver.findElement(By.xpath("//*[@text='OK']")).click();
	        driver.findElement(By.xpath("//*[@text='STATIONNEMENT']")).click();
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}