package com.app.SpringBootSeleniumCucumberProj.bdd.steps.registration_login;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.page.login_register_form.LoginFormPage;
import com.app.SpringBootSeleniumCucumberProj.page.MyAccountPage;
import com.app.SpringBootSeleniumCucumberProj.page.StoreHomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginRegistrationSteps {
    @LazyAutowired
    private LoginFormPage loginFormPage;
    @LazyAutowired
    private MyAccountPage myAccountPage;
    @LazyAutowired
    private StoreHomePage storeHomePage;



    @When("I click on the MyAccount button")
    public void goToStore() {
        storeHomePage.goToLoginForm();
    }

    @Then("I am on the login form page")
    public void isAtLoginForm() {
        loginFormPage.isAt();
    }

    @When("I provide {string} and {string} to register")
    public void provideCredentials(String email, String password) {
        loginFormPage.registerUser(email, password);
    }

    @Then("I am successfully logged in to my account {string}")
    public void isLoggedOnSpecifiedAccount(String email) {
        myAccountPage.isAt();
        var userName = email.split("@")[0];
        Assert.assertTrue(myAccountPage.hasSpecifiedName(userName));
    }

    @When("I log out from my account")
    public void logOut() {
        myAccountPage.logOut();
    }

    @When("I log in with the same {string} and {string}")
    public void logInWithSpecifiedCredentials(String email, String password) {
        loginFormPage.isAt();
        loginFormPage.logIn(email, password);
    }

    @And("I see only one error message")
    public void iSeeOnlyOneErrorMessage() {
        loginFormPage.getErrorComponent().NAlertsAreDisplayed(1);
    }

    @Then("I get specified error message {string}")
    public void iGetSpecifiedErrorMessage(String arg0) {
        Assert.assertEquals(loginFormPage.getErrorComponent().getErrorMessage(), arg0);
    }
}


