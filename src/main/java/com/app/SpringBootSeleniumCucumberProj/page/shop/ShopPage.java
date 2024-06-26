package com.app.SpringBootSeleniumCucumberProj.page.shop;

import com.app.SpringBootSeleniumCucumberProj.annotation.Page;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class ShopPage extends BasePage {
    @FindBy(xpath = "//h2[@class = 'woocommerce-loop-category__title']")
    private List<WebElement> categories;

    public ShopPage clickOnSpecificCategory(String category) {
        categories.stream().filter(element -> element.getText().toLowerCase().contains(category.toLowerCase()))
                .findFirst()
                .orElseThrow()
                .click();

        return this;
    }


    @Override
    public boolean isAt() {
        return wait.until((d) -> !categories.isEmpty());
    }
}
