package com.app.SpringBootSeleniumCucumberProj.page.shop;

import com.app.SpringBootSeleniumCucumberProj.annotation.Page;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class CartPage extends BasePage {

    @FindBy(xpath = "//img[@class = 'custom-logo']")
    private WebElement logoImg;

    @FindBy(xpath = "//tr[@class = 'woocommerce-cart-form__cart-item cart_item']")
    private List<WebElement> productsInCart;

    public boolean isSpecificPositionInCart(String productKeyWord) {
        return productsInCart
                .stream()
                .anyMatch(webElement -> webElement
                        .findElement(By.xpath("//td[@class = 'product-name']/a"))
                        .getText()
                        .contains(productKeyWord));
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> Integer.parseInt(logoImg.getAttribute("width")) > 0);
    }

}
