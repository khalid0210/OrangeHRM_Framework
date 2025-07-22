package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonsFunctions {
	//CommonsFunctions
	
	public static WebDriver driver=null;
	public static Properties properties=null;
	static Logger logger=Logger.getLogger(CommonsFunctions.class);
	public Properties loadPropertyFile() throws IOException {
		FileInputStream file=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(file);
		return properties;
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Orange HRM Test Begins");
		logger.info("Loading properties file...");
		properties=loadPropertyFile();
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("URL");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			  logger.info("Chrome Browser Launched");
	         driver = new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			 logger.info("Firefox Browser Launched");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		 logger.info("Navigating to application...");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@AfterSuite
	public void tearDown() {
		 logger.info("Closing the Browser");
		
	}

}
