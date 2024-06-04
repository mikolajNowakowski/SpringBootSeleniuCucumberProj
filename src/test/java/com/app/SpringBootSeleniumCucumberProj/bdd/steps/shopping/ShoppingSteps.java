package com.app.SpringBootSeleniumCucumberProj.bdd.steps.shopping;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.page.StoreHomePage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.*;
import com.app.SpringBootSeleniumCucumberProj.persistance.repositories.feature.shopping.ProductPurchaseRepo;
import com.app.SpringBootSeleniumCucumberProj.utils.SeleniumHelper;
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
    private OrderConfirmationPage orderConfirmationPage;
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
        customerOrderFormPage.fillWholeCustomerForm(productPurchaseRepo.findByIndex(csvRow).getCustomerOrderForm());
    }

    @And("I complete payment details with data from csv file at {int} row")
    public void iCompletePaymentDetailsWithDataFromCsvFileAtRow(int csvRow) {
        customerOrderFormPage.fillPaymentDetails(productPurchaseRepo.findByIndex(csvRow).getCreditCard());
    }


    @And("Confirm order")
    public void confirmOrder() {
        customerOrderFormPage
                .acceptTerms()
                .submitOrder();
    }

    @Then("I will get confirmation of my order")
    public void iWillGetConfirmationOfMyOrder() {
        orderConfirmationPage.isAt();
    }


    @And("I will see order details from {int}")
    public void iWillSeeOrderDetailsFromCswRow(int csvRow) {
        var testData = productPurchaseRepo.findByIndex(csvRow);

        Assert.assertTrue(orderConfirmationPage.anyProductContainsInName(testData.getSportTypeRegion().getRegion()));
        Assert.assertTrue(orderConfirmationPage.areSpecificNumberOfProductsInSummary(1));
    }
}
