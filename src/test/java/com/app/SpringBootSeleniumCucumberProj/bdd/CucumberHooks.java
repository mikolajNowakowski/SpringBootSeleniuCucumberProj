package com.app.SpringBootSeleniumCucumberProj.bdd;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;


import io.cucumber.java.*;
import io.cucumber.spring.CucumberContextConfiguration;

import org.openqa.selenium.WebDriver;

import org.springframework.boot.test.context.SpringBootTest;


@CucumberContextConfiguration
@SpringBootTest
public class CucumberHooks {
    @LazyAutowired
    private WebDriver driver;

    @After
    public void teardown() {
        driver.quit();
    }
}
