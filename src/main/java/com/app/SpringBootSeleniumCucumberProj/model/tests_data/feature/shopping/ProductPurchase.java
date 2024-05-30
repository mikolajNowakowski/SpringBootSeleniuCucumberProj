package com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.shopping;

import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.model.SportTypeRegion;
import com.app.SpringBootSeleniumCucumberProj.model.TestDataObj;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPurchase implements TestDataObj {
    private SportTypeRegion sportTypeRegion;
    private CustomerOrderForm customerOrderForm;
    private CreditCard creditCard;
}
