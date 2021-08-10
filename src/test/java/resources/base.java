package resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;

	public WebDriver intializeDriver() throws Exception {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\eclipse-workspace\\End2EProject\\src\\test\\java\\resources\\Data.properties");

		prop.load(fis);
		String broserName = prop.getProperty("browser");

		if (broserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\udemy Learning\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (broserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.geecko.driver", ".\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (broserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	public void getScreenShot(String testcasename,WebDriver driver) throws Exception {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination =System.getProperty("user.dir") + "\\reports\\"+testcasename+".png";
		FileUtils.copyFile(src, new File(destination));
	}
}
