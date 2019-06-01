package com.virtusa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		glue={"com.virtusa.bddtests.step_definitions"}		
	)
public class TestRunner {

}
