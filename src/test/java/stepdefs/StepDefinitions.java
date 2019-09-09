package stepdefs;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.ValuesPage;

public class StepDefinitions {
	WebDriver driver = Hooks.driver;
	ValuesPage value = new ValuesPage(driver);

	@Given("^I am on https://www.exercise1.com/values page$")
	public void iAmOnValuesPage() throws IOException {
		value.printLog("User is on values page");
		assertTrue(!driver.getCurrentUrl().isEmpty(), "User is not on values page");
	}

	@Then("^The number of values on the screen should be (\\d+)$")
	public void verifyTheCountOfValues(int valueCount) throws Throwable {
		value.verifyCountOfValues(driver, valueCount);
	}

	@And("^The values on the screen should be greater than (\\d+)$")
	public void verifyTheValuesAreGreaterThan(int num) throws Throwable {
		value.verifyValuesAreGreaterThan(driver, num);
	}

	@And("^The total balance should be correct based on the values listed on the screen$")
	public void verifyTheTotalBalanceIsCorrect() throws Throwable {
		value.verifyTotalBalanceIsCorrect(driver);
	}

	@And("^The values should be formatted as currencies$")
	public void verifyTheValuesAreFormatted() throws Throwable {
		value.verifyValuesAreFormatted(driver);
	}

	@And("^The total balance should match the sum of the values$")
	public void verifyTheTotalBalanceMatches() throws Throwable {
		value.verifyTotalBalanceMatches(driver);
	}

}