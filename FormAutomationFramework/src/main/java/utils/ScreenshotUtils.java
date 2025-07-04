package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {

    public static String captureScreenshot(AndroidDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = "test-output/screenshots/" + screenshotName + "_" + timestamp + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}