package tests;

import org.testng.annotations.*;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import COM.Drivers.DriverManager;
import COM.Page.AddSpecimenPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddSpecimenTest {

    AddSpecimenPage specimenPage;

    @BeforeClass
    public void setUp() throws Exception {
        DriverManager.getDriver();
        specimenPage = new AddSpecimenPage(DriverManager.driver);
    }

    @Test
    public void testSpecimenForm() {
        specimenPage.openSpecimenForm();
        specimenPage.fillSpecimenForm("Dome1", "Line1", "Set1", "Chamber1", "Position1");
        specimenPage.submitForm();
        specimenPage.goBackHome();
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
