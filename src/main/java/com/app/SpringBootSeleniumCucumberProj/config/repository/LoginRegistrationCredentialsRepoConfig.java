package com.app.SpringBootSeleniumCucumberProj.config.repository;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyBean;
import com.app.SpringBootSeleniumCucumberProj.annotation.LazyConfiguration;
import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.login_registration.LoginRegistrationCredentials;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.feature.login_registration.LoginRegistrationCredentialsProcessor;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.feature.shopping.ProductPurchaseProcessor;
import com.app.SpringBootSeleniumCucumberProj.persistance.repositories.feature.login_registration.LoginRegistrationCredentialsRepo;
import com.app.SpringBootSeleniumCucumberProj.persistance.repositories.feature.shopping.ProductPurchaseRepo;

@LazyConfiguration
public class LoginRegistrationCredentialsRepoConfig {

    @LazyBean
    public LoginRegistrationCredentialsRepo loginRegistrationCredentialsRepo(LoginRegistrationCredentialsProcessor loginRegistrationCredentialsProcessor) {
        return new LoginRegistrationCredentialsRepo(loginRegistrationCredentialsProcessor);
    }

}
