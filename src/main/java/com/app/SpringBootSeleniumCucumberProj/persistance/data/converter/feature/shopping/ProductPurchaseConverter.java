package com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.feature.shopping;

import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.model.SportTypeRegion;
import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.shopping.ProductPurchase;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProductPurchaseConverter implements Converter<List<Map<String, String>>, List<ProductPurchase>> {


    @Override
    public List<ProductPurchase> convert(List<Map<String, String>> data) {
        return data.stream().map(map -> ProductPurchase.builder()

                        .creditCard(CreditCard.builder()
                                .cardNumber(map.get("cardNumber"))
                                .cardExpirationDate(map.get("cardExpirationDate"))
                                .cvcNumber(map.get("cvcNumber"))
                                .build())

                        .customerOrderForm(CustomerOrderForm.builder()
                                .firstName(map.get("firstName"))
                                .lastName(map.get("lastName"))
                                .companyName(map.get("companyName"))
                                .country(map.get("country"))
                                .address1(map.get("address1"))
                                .address2(map.get("address2"))
                                .postCode(map.get("postCode"))
                                .city(map.get("city"))
                                .phoneNumber(map.get("phoneNumber"))
                                .email(map.get("email"))
                                .createAccount(Boolean.parseBoolean(map.get("createAccount")))
                                .additionalComments(map.get("additionalComments"))
                                .termsAcceptation(Boolean.parseBoolean(map.get("termsAcceptation")))
                                .build())

                        .sportTypeRegion(SportTypeRegion
                                .builder()
                                .sportType(map.get("sportType"))
                                .region(map.get("region"))
                                .build())
                        .build())
                .toList();
    }
}
