package COM.Page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddHarvestingPage {

    private AndroidDriver driver;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Harvesting\"]")
    private WebElement harvesting;

    @FindBy(xpath = "//android.widget.TextView[@text=\"󰐕\"]")
    private WebElement iconButton;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"dome-0-0\"]")
    private WebElement domeField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"line-0-1\"]")
    private WebElement lineField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"set-0-2\"]")
    private WebElement setField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"chamber-0-3\"]")
    private WebElement chamberField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"position-0-4\"]")
    private WebElement positionField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"plant-0-5\"]")
    private WebElement plantField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"fruit-0-6\"]")
    private WebElement fruitField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"date-0-7\"]")
    private WebElement dateField;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Cancel\"]")
    private WebElement cancelButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"󰁍\"]")
    private WebElement backHome;

    public AddHarvestingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHarvestingForm() {
        harvesting.click();
        iconButton.click();
    }

    public void fillHarvestingForm(String dome, String line, String set, String chamber,
                                    String position, String plant, String fruit, String date) {
        domeField.sendKeys(dome);
        lineField.sendKeys(line);
        setField.sendKeys(set);
        chamberField.sendKeys(chamber);
        positionField.sendKeys(position);
        plantField.sendKeys(plant);
        fruitField.sendKeys(fruit);
        dateField.sendKeys(date);
    }

    public void submitForm() {
        submitButton.click();
    }

    public void cancelForm() {
        cancelButton.click();
    }

    public void goBackHome() {
        backHome.click();
    }
}
