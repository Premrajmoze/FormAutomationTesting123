package tests;

import COM.Drivers.DriverManager;
import COM.Page.AddMediaMoisturePage;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddMediaMoistureTest {

    AddMediaMoisturePage mediaPage;

    @BeforeClass
    public void setUp() throws Exception {
        DriverManager.getDriver();
        mediaPage = new AddMediaMoisturePage(DriverManager.driver);
    }

    @Test
    public void testMediaMoistureForm() {
        mediaPage.openMediaMoistureForm();
        mediaPage.fillMediaMoistureForm("Dome3", "Line3", "Set3", "Chamber3", "Position3", "65", "2025-07-04");
        mediaPage.submitForm();
        mediaPage.goBackHome();
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
