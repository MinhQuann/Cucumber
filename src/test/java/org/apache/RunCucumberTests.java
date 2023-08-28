package org.apache;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.testng.annotations.Test;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("org/apache")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")

@CucumberOptions(
        //Tệp tính năng, Vị trí cá feature
        features = "C:\\Users\\Admin\\IdeaProjects\\Cucumber\\src\\test\\resources\\org\\apache",
        glue = "C:\\Users\\Admin\\IdeaProjects\\Cucumber\\src\\test\\java\\org\\apache",
        plugin = {"pretty", "html : target/cucumber-html-report.html"}
)

@Test
public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
