package com.app.SpringBootSeleniumCucumberProj.utils;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SeleniumHelper {

    @LazyAutowired
    AnnotationConfigApplicationContext context;

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) context.getBean(WebDriver.class)).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
