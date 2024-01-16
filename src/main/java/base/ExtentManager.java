package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;

public class ExtentManager extends BasePage{

    public static ExtentReports extentReport;
    public static String extentReportPrefix;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public ExtentManager() throws IOException {
        super();
    }

    public static ExtentReports getReport(){
        if(extentReport==null){
            setupExtentReport("Live Project 1");
        }
        return extentReport;
    }
    public static ExtentReports setupExtentReport(String testName){
        extentReport = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/report/"+extentReportsPrefix_Name(testName)+".html");
        extentReport.attachReporter(sparkReporter);
    }
}
