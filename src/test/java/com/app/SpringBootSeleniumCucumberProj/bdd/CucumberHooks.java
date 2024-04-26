package com.app.SpringBootSeleniumCucumberProj.bdd;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;


import io.cucumber.java.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberHooks {
    @LazyAutowired
    private WebDriver driver;

    @Value("${report.path}")
    private static String reportPath;

    @Value("${report.config.path}")
    private static String configPath;


//    public static ExtentReports extentReports;
//    public static ExtentHtmlReporter htmlReporter;
//    public static ExtentTest extentTest;

//    @BeforeAll
//    public static void beforeAll() {
//        htmlReporter = new ExtentHtmlReporter("index.html");
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(htmlReporter);
//        extentTest = extentReports.createTest("Test: %s".formatted(reportPath));
//    }
//
//    @AfterAll
//    public static void afterAll() {
//        htmlReporter.flush();
//        extentReports.flush();
//    }
//
//    @AfterStep
//    public void afterStep(Scenario scenario) {
//
//    }
    @AfterAll
    public static void writeExtentReport() {

    }
    @After
    public void teardown() {
        driver.quit();
    }
}
