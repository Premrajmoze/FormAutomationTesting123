package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void initReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Platform", "Android");
        extent.setSystemInfo("Tester", "QA Tester");
    }

    public static void flushReport() {
        extent.flush();
    }

    public static ExtentTest createTest(String testName) {
        return test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

	public static ExtentReportManager getInstance() {
		
		return null;
	}
}
