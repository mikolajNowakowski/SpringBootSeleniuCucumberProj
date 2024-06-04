package com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.feature.login_registration;

import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.login_registration.LoginRegistrationCredentials;
import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.shopping.ProductPurchase;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.feature.login_registration.LoginRegistrationCredentialsFactory;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.feature.shopping.ProductPurchaseFactory;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.Processor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoginRegistrationCredentialsProcessor implements Processor<List<LoginRegistrationCredentials>> {
    @Value("${csv.testData.LoginRegistrationCredentials}")
    String csvFilePath;

    private final LoginRegistrationCredentialsFactory loginRegistrationCredentialsFactory;

    @Override
    public List<LoginRegistrationCredentials> process() {
        var data = loginRegistrationCredentialsFactory.createLoader().load(csvFilePath);
        return loginRegistrationCredentialsFactory.createConverter().convert(data);
    }
}
