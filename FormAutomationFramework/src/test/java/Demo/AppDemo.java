package Demo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class AppDemo {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "SmallPhoneAPITiramisuPrivacySandbox");
        capabilities.setCapability("appPackage", "com.eekifoods.dev");
        capabilities.setCapability("appActivity", "com.eekifoods.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, capabilities);

        System.out.println("Appium session started");
        driver.quit();
		/*
		 * driver.findElement(By.id("")).click();
		 * 
		 * driver.findElement(By.id("")).sendKeys("iphone 16 pro");
		 * 
		 * driver.findElement(By.id("")).click();
		 * 
		 * driver.findElement(By.id("")).clear(); driver.findElement(By.id("")).clear();
		 */
}
}
