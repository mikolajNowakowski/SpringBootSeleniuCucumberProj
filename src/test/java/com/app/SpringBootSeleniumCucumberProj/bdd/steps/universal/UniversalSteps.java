package com.app.SpringBootSeleniumCucumberProj.bdd.steps.universal;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.page.StoreHomePage;
import io.cucumber.java.en.Given;

public class UniversalSteps {

@LazyAutowired
private StoreHomePage storeHomePage;

    @Given("I am on the store home page")
    public void goToHomePage() {
        storeHomePage.goTo();
    }
}
