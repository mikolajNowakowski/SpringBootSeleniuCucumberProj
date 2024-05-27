package com.app.SpringBootSeleniumCucumberProj.persistance.data.converter;

import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ToOrderCustomerOrderFormConverter implements Converter<List<Map<String, String>>, List<CustomerOrderForm>> {
    @Override
    public List<CustomerOrderForm> convert(List<Map<String, String>> data) {
        return data.stream().map(map ->
                CustomerOrderForm.builder()
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
                        .build()

        ).toList();
    }
}
