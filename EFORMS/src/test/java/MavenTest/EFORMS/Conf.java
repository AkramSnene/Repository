package MavenTest.EFORMS;
import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.logging.Level;

import org.openqa.selenium.remote.DesiredCapabilities;

//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;

public class Conf {
	public static final String deviceName="Samsung Galaxy Grand Prime";
	public static final String udid="4b132e267da4b200";
	public static final String platformName="Android";
	public static final String platformVersion="5.1.1";
	public static final String appPackage="com.eforms.android";
	public static final String appActivity="com.eforms.android.ui.activity.LauncherActivity";
	public static final String noReset="true";
	
	
	public static void config() throws MalformedURLException  {
		
	//Set the Desired Capabilities
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability("deviceName",deviceName);  
	dc.setCapability("udid", udid); 
	dc.setCapability("platformName", platformName);  
	dc.setCapability("platformVersion", platformVersion);  
	dc.setCapability("appPackage", appPackage); 
	dc.setCapability("appActivity", appActivity);
	dc.setCapability("noReset", noReset);
	
	
	}
	
}
