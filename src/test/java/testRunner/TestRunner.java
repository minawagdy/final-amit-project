package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/main/resources/features",

    glue = "stepDefs",

    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

    tags = "@Smoke_Testing"

)
public class TestRunner extends AbstractTestNGCucumberTests {}
