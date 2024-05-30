package com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.feature.shopping;

import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.shopping.ProductPurchase;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.Converter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.feature.shopping.ProductPurchaseConverter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.Factory;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.csv.CsvDataLoader;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.Loader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProductPurchaseFactory implements Factory<List<Map<String,String>>, List<ProductPurchase>> {

    @Override
    public Loader<List<Map<String, String>>> createLoader() {
        return new CsvDataLoader();
    }

    @Override
    public Converter<List<Map<String, String>>, List<ProductPurchase>> createConverter() {
        return new ProductPurchaseConverter();
    }
}
