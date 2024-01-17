package resource;

import java.io.IOException;

import base.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BasePage;

public class Listeners extends BasePage implements ITestListener {

	public Listeners() throws IOException {
		super();
	}

	public synchronized void onStart(ITestContext context){
		ExtentManager.getReport();
		ExtentManager.createTest(context.getName(),context.getName());
	}
	public void onTestFailure(ITestResult result) {
ExtentManager.getTest().fail(result.getThrowable());
		try {
			System.out.println("Test failed: "+ result.getName());
			takeSnapShot(result.getMethod().getMethodName());
			ExtentManager.attachImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void onFinish(ITestContext context){
		ExtentManager.flushReport();
	}

}
