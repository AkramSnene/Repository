package MavenTest.EFORMS;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MavenTest.EFORMS.Conf;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testlink.api.java.client.TestLinkAPIResults;

public class EFTP95ActiverLeBoutonStationnement {
	
public void configuration() throws Exception {

	Conf f=new Conf();
	f.config();
	DesiredCapabilities caps = new DesiredCapabilities();
	try {
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eforms.android:id/password")));
		driver.findElement(By.id("com.eforms.android:id/password")).sendKeys("1340Adm");
		driver.findElement(By.id("com.eforms.android:id/user_sign_in_button")).click();
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eforms.android:id/setting_btn")));
		driver.findElement(By.id("com.eforms.android:id/setting_btn")).click();
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eforms.android:id/switch_stationnement")));
	
		
		driver.findElement(By.id("com.eforms.android:id/switch_stationnement")).click();
		
		
	
		/*driver.close();*/
		driver.quit();
} catch (MalformedURLException e) {
	System.out.println(e.getMessage());
}

try {
	TestLinkIntegration.updateResults("FirstTestCase", null, TestLinkAPIResults.TEST_FAILED);
	}
	catch (Exception e){
		TestLinkIntegration.updateResults("FirstTestCase", e.getMessage(), TestLinkAPIResults.TEST_PASSED);
	}
System.out.println("==> done1 <==");
	
}
}