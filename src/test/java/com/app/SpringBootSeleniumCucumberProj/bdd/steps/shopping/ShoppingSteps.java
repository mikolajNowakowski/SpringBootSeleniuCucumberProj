package com.app.SpringBootSeleniumCucumberProj.bdd.steps.shopping;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.page.StoreHomePage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.CartPage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.CategoryPage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.CustomerOrderFormPage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.ShopPage;
import com.app.SpringBootSeleniumCucumberProj.persistance.repositories.feature.shopping.ProductPurchaseRepo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShoppingSteps {

    @LazyAutowired
    private StoreHomePage storeHomePage;
    @LazyAutowired
    private ShopPage shopPage;
    @LazyAutowired
    private CategoryPage categoryPage;
    @LazyAutowired
    private CartPage cartPage;
    @LazyAutowired
    private CustomerOrderFormPage customerOrderFormPage;

    @LazyAutowired
    private ProductPurchaseRepo productPurchaseRepo;

    @When("I click store button")
    public void iClickStoreButton() {
        storeHomePage.goToShop();
    }

    @And("I click on sport type from csv file at {int} row")
    public void iClickOnSportTypeFromCsvFileAtRow(int csvRow) {
        shopPage
                .clickOnSpecificCategory(productPurchaseRepo
                        .findByIndex(csvRow)
                        .getSportTypeRegion()
                        .getSportType());
    }

    @And("I add specific sport in specific region from {int} row to cart")
    public void iAddSpecificSportInSpecificRegionFromCsvRowRowToCart(int csvRow) {
        categoryPage
                .addSpecifiedProductToCart(productPurchaseRepo
                        .findByIndex(csvRow)
                        .getSportTypeRegion()
                        .getRegion());
    }


    @And("I go to cart")
    public void iGoToCart() {
        categoryPage.goToCart();
    }


    @Then("I will be able to see {int} in my cart")
    public void iWillBeAbleToSeeCsvRowInMyCart(int csvRow) {
        var productDetails = productPurchaseRepo.findByIndex(csvRow).getSportTypeRegion();
        Assert.assertTrue(cartPage.isSpecificPositionInCart(productDetails.getRegion()));
    }


    @When("I proceed with shopping")
    public void iProceedWithShopping() {
        cartPage.goToPayment();

    }

    @Then("I will go to order form")
    public void iWillGoToOrderForm() {
        customerOrderFormPage.isAt();
    }

    @When("I complete customer form with data from csv file at {int} row")
    public void iCompleteCustomerFormWithDataFromCsvFileAtRow(int csvRow) {
        customerOrderFormPage.fillCustomerForm(productPurchaseRepo.findByIndex(csvRow).getCustomerOrderForm());
    }

    @And("Confirm order")
    public void confirmOrder() {

    }

    @Then("I will get confirmation of my order")
    public void iWillGetConfirmationOfMyOrder() {

    }




    @And("I complete payment details with data from csv file at {int} row")
    public void iCompletePaymentDetailsWithDataFromCsvFileAtRow(int csvRow) {
    }

    @And("I add {int} to cart")
    public void iAddCsvRowToCart(int csvRow) {
    }


    @And("I add specific sport in specific region from <csvRow> row to cart")
    public void iAddSpecificSportInSpecificRegionFromCsvRowRowToCart() {
    }


}
