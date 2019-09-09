package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValuesPage extends BasePage {

	public ValuesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[id*='lbl_val']")
	private List<WebElement> valueLabelList;

	@FindBy(css = "[id*='txt_val']")
	private List<WebElement> valueList;

	@FindBy(id = "lbl_ttl_val")
	private WebElement totalBalanceLabel;

	@FindBy(id = "txt_ttl_val")
	private WebElement totalBalance;

	public void verifyCountOfValues(WebDriver driver, int valueCount) {

		assertEquals(valueLabelList.size(), valueCount, "The count of value labels doesn't match the expected count");
		for (WebElement valueLabel : valueLabelList) {
			assertTrue(!valueLabel.getText().isEmpty(), "Value label is blank");
		}

		assertEquals(valueList.size(), valueCount, "The count of values doesn't match the expected count");
		for (WebElement value : valueList) {
			assertTrue(!value.getText().isEmpty(), "Currency value is blank");
		}
	}

	public void verifyValuesAreGreaterThan(WebDriver driver, int num) throws ParseException {

		NumberFormat format = NumberFormat.getCurrencyInstance();

		for (WebElement value : valueList) {
			String currencyValue = value.getText().trim();
			Number number = format.parse(currencyValue);
			assertTrue(number.floatValue() > num, "Currency value " + currencyValue + " is not greater than zero");
		}

		String totalBal = totalBalance.getText().trim();
		Number number = format.parse(totalBal);
		assertTrue(number.floatValue() > num, "Total currency value is not greater than zero");
	}

	public void verifyTotalBalanceIsCorrect(WebDriver driver) throws ParseException {

		float totalValue = 0;
		NumberFormat format = NumberFormat.getCurrencyInstance();

		for (WebElement value : valueList) {
			String currencyValue = value.getText().trim();
			Number currencyValueNumber = format.parse(currencyValue);
			totalValue += currencyValueNumber.floatValue();
		}

		String totalBal = totalBalance.getText().trim();
		Number totalBalanceNumber = format.parse(totalBal);
		assertEquals(totalValue, totalBalanceNumber.floatValue(), "Total balance is not correct based on the values listed on the screen");
	}

	public void verifyValuesAreFormatted(WebDriver driver) {

		for (WebElement value : valueList) {
			String currencyValue = value.getText().trim();
			boolean b = Pattern.matches("^\\$[0-9]{1,3}(\\,[0-9]{3})*\\.[0-9]{2}$", currencyValue);
			assertTrue(b, "Value " + currencyValue + " is not formatted as currency");
		}

		String totalBal = totalBalance.getText().trim();
		boolean b = Pattern.matches("^\\$[0-9]{1,3}(\\,[0-9]{3})*\\.[0-9]{2}$", totalBal);
		assertTrue(b, "Total balance value is not formatted as currency");
	}

	public void verifyTotalBalanceMatches(WebDriver driver) throws ParseException {

		float totalValue = 0;
		NumberFormat format = NumberFormat.getCurrencyInstance();

		for (WebElement value : valueList) {
			String currencyValue = value.getText().trim();
			Number currencyValueNumber = format.parse(currencyValue);
			totalValue += currencyValueNumber.floatValue();
		}

		String totalBal = totalBalance.getText().trim();
		Number totalBalanceNumber = format.parse(totalBal);
		assertEquals(totalValue, totalBalanceNumber.floatValue(), "Total balance doesn't match the sum of the values on the screen");
	}

}