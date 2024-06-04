package com.app.SpringBootSeleniumCucumberProj.bdd.steps.registration_login;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.page.login_register_form.LoginFormPage;
import com.app.SpringBootSeleniumCucumberProj.page.MyAccountPage;
import com.app.SpringBootSeleniumCucumberProj.page.StoreHomePage;
import com.app.SpringBootSeleniumCucumberProj.persistance.repositories.feature.login_registration.LoginRegistrationCredentialsRepo;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginRegistrationSteps {
    @LazyAutowired
    private LoginFormPage loginFormPage;
    @LazyAutowired
    private MyAccountPage myAccountPage;
    @LazyAutowired
    private StoreHomePage storeHomePage;
    @LazyAutowired
    private LoginRegistrationCredentialsRepo loginRegistrationCredentialsRepo;


    @When("I click on the MyAccount button")
    public void goToStore() {
        storeHomePage.goToLoginForm();
    }

    @Then("I am on the login form page")
    public void isAtLoginForm() {
        loginFormPage.isAt();
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

    @When("I provide email and password to register from {int} row")
    public void iProvideEmailAndPasswordToRegisterFromCsvRowRow(int csvRow) {
        var testData = loginRegistrationCredentialsRepo.findByIndex(csvRow);
        loginFormPage.registerUser(testData.getEmail(), testData.getPassword());
    }

    @Then("I am successfully logged into my account {int}")
    public void iAmSuccessfullyLoggedIntoMyAccountCsvRow(int csvRow) {
        myAccountPage.isAt();
        var userName = loginRegistrationCredentialsRepo.findByIndex(csvRow).getEmail().split("@")[0];
        Assert.assertTrue(myAccountPage.hasSpecifiedName(userName));
    }

    @And("I log in with the same email and password from {int} row")
    public void iLogInWithTheSameEmailAndPasswordFromCsvRowRow(int csvRow) {
        var testData = loginRegistrationCredentialsRepo.findByIndex(csvRow);
        loginFormPage.isAt();
        loginFormPage.logIn(testData.getEmail(), testData.getPassword());

    }

    @Then("I get specified error message from {int} row")
    public void iGetSpecifiedErrorMessageFromCwvRowRow(int csvRow) {
        Assert.assertEquals(loginFormPage.getErrorComponent().getErrorMessage(), loginRegistrationCredentialsRepo.findByIndex(csvRow).getErrorMessage());
    }


}


