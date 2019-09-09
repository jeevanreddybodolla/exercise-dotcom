package pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriver driver;
	public final static int WAIT_SECONDS = 20;
	protected String pageTitle;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void printLog(String text) {
		Logger logger = LogManager.getLogger(getClass().getName());
		logger.info(text);
	}
	
	public void printErrorLog(String text) {
		Logger logger = LogManager.getLogger(getClass().getName());
		logger.error(text);
	}

	public WebDriverWait waitFor(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
		return wait;
	}

	public WebDriverWait waitFor(WebDriver driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		return wait;
	}

	public void pauseWebDriver(int seconds) throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
			printLog("Cannot pause web driver.");
			throw e;
		} finally {
			printLog("End of pauseWebDriver");
		}
	}
}
