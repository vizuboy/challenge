package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "Features/TestCase01.feature", "Features/TestCase02.feature" }, glue = {
		"stepdefinition" }, dryRun = false, plugin = { "pretty", "html:target/site/cucumber-pretty",
				"json:target/cucumber/cucumber.json" })
@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}