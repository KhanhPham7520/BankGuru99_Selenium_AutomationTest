package cucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
glue = {"liveGuru.stepDefinitions" },
monochrome = true, snippets = SnippetType.UNDERSCORE, 
plugin = { "pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber.json" }, 
tags = { "@automation" })
public class CucumberTestRunner {

}
