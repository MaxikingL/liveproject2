package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    private String url;
    private Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\config.properties");
        prop.load(data);
    }
    public WebDriver getDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(
                "C:\\Users\\malema\\workSpace\\Selenium\\liveproject1\\src\\main\\java\\resource\\config.properties");
        prop.load(data);

        if (prop.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\malema\\workSpace\\Selenium\\liveproject1\\src\\main\\java\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
//        } else if (prop.getProperty("browser").equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver",
//                    "C:\\Users\\malema\\workSpace\\Selenium\\liveproject1\\src\\main\\java\\driver\\chromedriver.exe");
//            driver = new FirefoxDriver();
//        } else {
//            System.setProperty("webdriver.edge.driver",
//                    "C:\\Users\\malema\\workSpace\\Selenium\\liveproject1\\src\\main\\java\\driver\\chromedriver.exe");
//            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public String getUrl() throws IOException {
        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(
                "C:\\Users\\malema\\workSpace\\Selenium\\liveproject1\\src\\main\\java\\resource\\config.properties");
        prop.load(data);
        url = prop.getProperty("url");
        return url;
    }

//	public void takeSnapShot(WebDriver webdriver) throws IOException {
//		File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
//
//		File destFile = new File("C:\\Users\\sbrun\\OneDrive - Learn Automation\\Desktop\\Resources\\screenshots\\"
//				+ timestamp() + ".png");
//
//		FileUtils.copyFile(srcFile, destFile);
//
//	}

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

}

