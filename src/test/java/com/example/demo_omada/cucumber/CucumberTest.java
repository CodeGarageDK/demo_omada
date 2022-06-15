package com.example.demo_omada.cucumber;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.EXECUTION_DRY_RUN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.ANSI_COLORS_DISABLED_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


//@Cucumber
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.mycompany.cucumber")

@Suite
@IncludeEngines("cucumber")
//@SelectDirectories("src/test/java/com/swtestacademy/springbootselenium/cucumber/features")
@SelectDirectories("src/test/resources/features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.swtestacademy.springbootselenium.cucumber")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.example.demo_omada.cucumber")
//@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "true")
//@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
public class CucumberTest {
}
