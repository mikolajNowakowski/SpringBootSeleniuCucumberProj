package com.app.SpringBootSeleniumCucumberProj.persistance.repositories.feature.shopping;

import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.shopping.ProductPurchase;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.feature.shopping.ProductPurchaseProcessor;
import com.app.SpringBootSeleniumCucumberProj.persistance.repositories.Repository;

import java.util.List;

public class ProductPurchaseRepo implements Repository<ProductPurchase> {
    private final List<ProductPurchase> productPurchase;
    public ProductPurchaseRepo(ProductPurchaseProcessor productPurchaseProcessor) {
        productPurchase = productPurchaseProcessor.process();
    }

    @Override
    public ProductPurchase findByIndex(int index) {
        if(index >=productPurchase.size()){
            throw new IllegalArgumentException();
        }
        return productPurchase.get(index);
    }

    @Override
    public List<ProductPurchase> getAll() {
        return productPurchase;
    }
}
