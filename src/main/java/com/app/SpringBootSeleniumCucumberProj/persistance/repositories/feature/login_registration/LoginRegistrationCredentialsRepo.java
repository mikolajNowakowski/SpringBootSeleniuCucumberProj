package com.app.SpringBootSeleniumCucumberProj.persistance.repositories.feature.login_registration;

import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.login_registration.LoginRegistrationCredentials;
import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.shopping.ProductPurchase;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.feature.login_registration.LoginRegistrationCredentialsProcessor;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.feature.shopping.ProductPurchaseProcessor;
import com.app.SpringBootSeleniumCucumberProj.persistance.repositories.Repository;

import java.util.List;

public class LoginRegistrationCredentialsRepo implements Repository<LoginRegistrationCredentials> {

    private final List<LoginRegistrationCredentials> loginRegistrationCredentials;
    public LoginRegistrationCredentialsRepo(LoginRegistrationCredentialsProcessor loginRegistrationCredentialsProcessor) {
        loginRegistrationCredentials = loginRegistrationCredentialsProcessor.process();
    }

    @Override
    public LoginRegistrationCredentials findByIndex(int index) {
        return loginRegistrationCredentials.get(index);
    }

    @Override
    public List<LoginRegistrationCredentials> getAll() {
        return loginRegistrationCredentials;
    }
}
