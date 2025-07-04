package COM.Base;

import java.time.Duration;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.ModuleElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class BasePage {

    public AppiumDriver driver;
    public WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public Element waitForVisibility(By locator) {
        return (ModuleElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        ((WebElement) waitForVisibility(locator)).click();
    }

    public void sendKeys(By locator, String text) {
        ExecutableElement element = (ExecutableElement) waitForVisibility(locator);
        ((WebElement) element).clear();
        ((WebElement) element).sendKeys(text);
    }

    public String getText(By locator) {
        return ((WebElement) waitForVisibility(locator)).getText();
    }
}
