package com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.feature.shopping;

import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.shopping.ProductPurchase;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.feature.shopping.ProductPurchaseFactory;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.Processor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductPurchaseProcessor implements Processor<List<ProductPurchase>> {
    @Value("${csv.testData.productPurchase}")
    String csvFilePath;

    private final ProductPurchaseFactory productPurchaseFactory;

    @Override
    public List<ProductPurchase> process() {
        var data = productPurchaseFactory.createLoader().load(csvFilePath);
        return productPurchaseFactory.createConverter().convert(data);
    }
}
