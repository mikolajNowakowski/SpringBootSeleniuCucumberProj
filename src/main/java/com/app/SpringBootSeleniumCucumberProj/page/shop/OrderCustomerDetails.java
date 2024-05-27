package com.app.SpringBootSeleniumCucumberProj.page.shop;

import com.app.SpringBootSeleniumCucumberProj.annotation.Page;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class OrderCustomerDetails extends BasePage {
    @FindBy(xpath = "//img[@class = 'custom-logo']")
    private WebElement logoImg;

    @FindBy(name = "billing_first_name")
    private WebElement firstName;

    @FindBy(name = "billing_last_name")
    private WebElement lastName;

    @FindBy(name = "billing_company")
    private WebElement companyName;

    @FindBy(id = "select2-billing_country-container")
    private WebElement country;

    @FindBy(name = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_address_2")
    private WebElement addressOptional;

    @FindBy(id = "billing_postcode")
    private WebElement postCode;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "billing_email")
    private WebElement mail;

    @FindBy(id = "createaccount")
    private WebElement createAccountCheckbox;

    @FindBy(id = "order_comments")
    private WebElement additionalComments;

    @FindBy(name = "cardnumber")
    private WebElement cardNumber;

    @FindBy(name = "exp-date")
    private WebElement cardExpirationDay;

    @FindBy(name = "cvc")
    private WebElement cardCvcNumber;

    @FindBy(name = "terms")
    private WebElement termsAcceptation;

    @FindBy(name = "place_order")
    private WebElement submitOrderButton;


    public OrderCustomerDetails fillCustomerForm(CustomerOrderForm customer){

        return this;
    }


    @Override
    public boolean isAt() {
        return wait.until((d) -> Integer.parseInt(logoImg.getAttribute("width")) > 0);
    }
}
