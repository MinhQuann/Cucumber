package org.apache;

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
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/report.html")


//@CucumberOptions(
//        //Tệp tính năng, Vị trí cá feature
//        features = "org.apache",
//        glue = "StepsDefinitions",
//        plugin = {"pretty", "html:target/report.html"}
//)

@Test
public class RunCucumberTests {


}
