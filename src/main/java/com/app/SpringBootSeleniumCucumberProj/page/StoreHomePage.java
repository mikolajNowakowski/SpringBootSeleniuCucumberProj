package com.app.SpringBootSeleniumCucumberProj.page;

import com.app.SpringBootSeleniumCucumberProj.annotation.Page;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

@Page
public class StoreHomePage extends BasePage {
    @FindBy(css = ".custom-logo-link > img[alt='FakeStore']")
    private WebElement storeLogo;

    @FindBy(id = "menu-item-198")
    private WebElement shopButton;

    @FindBy(id = "menu-item-200")
    private WebElement cartButton;

    @FindBy(id = "menu-item-201")
    private WebElement myAccountButton;

    @FindBy(id = "menu-item-248")
    private WebElement wishListButton;

    @Value("${store.url}")
    private String url;

    public void goTo() {
        driver.get(url);
    }

    public StoreHomePage goToWishList(){
        wishListButton.click();
        return this;
    }

    public StoreHomePage goToLoginForm(){
        myAccountButton.click();
        return this;
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> Integer.parseInt(storeLogo.getAttribute("height")) > 0);
    }
}
