package com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.feature.login_registration;

import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.login_registration.LoginRegistrationCredentials;
import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.shopping.ProductPurchase;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LoginRegistrationCredentialsConverter implements Converter<List<Map<String, String>>, List<LoginRegistrationCredentials>> {
    @Override
    public List<LoginRegistrationCredentials> convert(List<Map<String, String>> data) {
        return data.stream().map(map -> LoginRegistrationCredentials.builder()
                .email(map.get("email"))
                .password(map.get("password"))
                .errorMessage(map.get("errorMessage"))
                .build())
                .toList();
    }
}
