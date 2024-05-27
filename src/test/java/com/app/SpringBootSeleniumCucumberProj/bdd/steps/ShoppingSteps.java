package com.app.SpringBootSeleniumCucumberProj.bdd.steps;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.page.StoreHomePage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.CartPage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.CategoryPage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.ShopPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bson.io.BsonOutput;

public class ShoppingSteps {

    @LazyAutowired
    private StoreHomePage storeHomePage;
    @LazyAutowired
    private ShopPage shopPage;
    @LazyAutowired
    private CategoryPage categoryPage;
    @LazyAutowired
    private CartPage cartPage;

    @When("I click store button")
    public void iClickStoreButton() {

    }

    @And("I click on {string}")
    public void iClickOn(String category) {

    }

    @And("I add {string} {string} to cart")
    public void iAddToCart(String region, String sportType) {

    }

    @And("I go to cart")
    public void iGoToCart() {
        categoryPage.goToCart();
    }

    @Then("I will be able to see {string} windsurfing in my cart")
    public void iWillBeAbleToSeeWindsurfingInMyCart(String region) {

    }

    @When("I proceed with shopping")
    public void iProceedWithShopping() {

    }

    @Then("I will go to order form")
    public void iWillGoToOrderForm() {

    }

    @When("I complete customer form")
    public void iCompleteCustomerForm(CustomerOrderForm customerOrderForm) {
        System.out.println(customerOrderForm.toString());
    }

    @And("I complete payment details")
    public void iCompletePaymentDetails(CreditCard creditCard) {
        System.out.println(creditCard.toString());
    }

    @And("Confirm order")
    public void confirmOrder() {

    }

    @Then("I will get confirmation of my order")
    public void iWillGetConfirmationOfMyOrder() {

    }

}
