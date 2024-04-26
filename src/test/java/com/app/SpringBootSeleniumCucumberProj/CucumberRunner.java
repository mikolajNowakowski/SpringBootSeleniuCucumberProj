package com.app.SpringBootSeleniumCucumberProj;



import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "classpath:features",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty"},
        tags = "@alreadyRegisteredError",
        monochrome = true)
@RunWith(Cucumber.class)
public class CucumberRunner {



}
