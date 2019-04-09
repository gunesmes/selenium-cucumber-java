package com.wallethub.assignment;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mesutgunes on 05/07/17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = {}
)

public class RunCukeTest {
}
