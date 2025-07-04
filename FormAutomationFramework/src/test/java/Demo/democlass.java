package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class democlass {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		   DesiredCapabilities capabilities = new DesiredCapabilities();

		   capabilities.setCapability("deviceName","OPPO CPH2385");
	        capabilities.setCapability("platformname", "Android");
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "14.0");
	        //io.appium.android.apis/io.appium.android.apis.ApiDemos
	        capabilities.setCapability("appPackage","io.appium.android.apis");
	        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");


	        URL url = URI.create("http://0.0.0.0:4723/wd/hub").toURL();

	        AndroidDriver driver = new AndroidDriver(url, capabilities);

	        Thread.sleep(2000);

	        System.out.println("Application Started");


	        //find view button
	       WebElement viewBtn =  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
	       viewBtn.click(); //perform click action on view button

	       //find drag and drop button
	       WebElement dragAndDropBtn =  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]"));
	       dragAndDropBtn.click(); //perform click action on view button

	       WebElement source =  driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));

	       WebElement destination =  driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]"));


	}
}
