package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@TestRun",
        features = {"src/test/resources/features"},
        glue = {"org.example","com.playwright.stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/report/cucumber-report.html",
                "json:target/report/cucumber-report.json",
                "json:target/jsonReports/reports/cucumber.json"
        }
)
public class AppTest {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */


    /**
     * @return the suite of tests being tested
     */


    /**
     * Rigourous Test :-)
     */

}
