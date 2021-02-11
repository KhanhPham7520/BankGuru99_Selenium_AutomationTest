package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/bankGuru/features", glue = "bankGuru.stepDefinitions", monochrome = true, snippets = SnippetType.CAMELCASE, 
         //dryRun = true, 
plugin = {"pretty", "html:target/site/cucumber-report-default",
		"json:target/site/cucumber.json" }, tags = { "@customer" })
public class BankGuruTestRunner {

}
