package tests;

import COM.Drivers.DriverManager;
import COM.Page.AddHarvestingPage;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddHarvestingTest {

    AddHarvestingPage harvestingPage;

    @BeforeClass
    public void setUp() throws Exception {
        DriverManager.getDriver();
        harvestingPage = new AddHarvestingPage(DriverManager.driver);
    }

    @Test
    public void testHarvestingForm() {
        harvestingPage.openHarvestingForm();
        harvestingPage.fillHarvestingForm("Dome2", "Line2", "Set2", "Chamber2", "Position2", "Plant2", "Fruit2", "2025-07-04");
        harvestingPage.submitForm();
        harvestingPage.goBackHome();
    }

    @AfterMethod
    public void captureFailureScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) DriverManager.driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String screenshotName = "screenshot_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
            File dest = new File("screenshots/" + screenshotName);
            try {
                Files.createDirectories(dest.getParentFile().toPath());
                Files.copy(src.toPath(), dest.toPath());
                System.out.println("Screenshot saved: " + dest.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
