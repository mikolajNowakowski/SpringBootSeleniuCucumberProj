package com.app.SpringBootSeleniumCucumberProj.config.repository;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyBean;
import com.app.SpringBootSeleniumCucumberProj.annotation.LazyConfiguration;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.feature.shopping.ProductPurchaseProcessor;
import com.app.SpringBootSeleniumCucumberProj.persistance.repositories.feature.shopping.ProductPurchaseRepo;

@LazyConfiguration
public class ProductPurchaseRepoConfig {
    @LazyBean
    public ProductPurchaseRepo productPurchaseRepo(ProductPurchaseProcessor productPurchaseProcessor) {
        return new ProductPurchaseRepo(productPurchaseProcessor);
    }

}
