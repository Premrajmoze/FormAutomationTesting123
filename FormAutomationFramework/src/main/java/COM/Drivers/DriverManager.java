package COM.Drivers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	
    public static AndroidDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Demo");
        caps.setCapability("app", System.getProperty("user.dir") + "/apk/app-debug.apk");
        caps.setCapability("automationName", "UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
