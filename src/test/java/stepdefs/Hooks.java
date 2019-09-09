package stepdefs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.ScreenshotFactory;

public class Hooks {

	private Properties config;
	public static WebDriver driver;

	@Before
	public void setup(Scenario scenario) throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		config.load(ip);
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			System.setProperty("webdriver.chrome.driver", "./selenium-drivers/chromedriver.exe");
		} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "./selenium-drivers/chromedriver");
		}
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = config.getProperty("siteUrl");
		driver.get(baseUrl);
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			ScreenshotFactory.captureScreenshot(driver, scenario.getName());
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		driver.quit();
	}
}
