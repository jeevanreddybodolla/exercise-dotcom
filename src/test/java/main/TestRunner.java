package main;
import org.testng.annotations.AfterSuite;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import util.CucumberReports;


@CucumberOptions(
		features = "src/test/resources/features", 
		glue = { "stepdefs" }, 
		tags = { "@ValidateValues" }, 
		plugin = { "pretty", "html:target/cucumber-reports", "json:target/cucumber.json" }
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@AfterSuite()
	public void generateHTMLReports() {
		CucumberReports.generateCucumberReport();
	}
}
