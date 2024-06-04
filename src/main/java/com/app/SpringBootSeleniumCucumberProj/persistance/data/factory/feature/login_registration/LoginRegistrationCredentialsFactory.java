package com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.feature.login_registration;

import com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.login_registration.LoginRegistrationCredentials;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.Converter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.feature.login_registration.LoginRegistrationCredentialsConverter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.Factory;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.Loader;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.csv.CsvDataLoader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LoginRegistrationCredentialsFactory implements Factory<List<Map<String,String>>, List<LoginRegistrationCredentials>> {
    @Override
    public Loader<List<Map<String, String>>> createLoader() {
        return new CsvDataLoader();
    }

    @Override
    public Converter<List<Map<String, String>>, List<LoginRegistrationCredentials>> createConverter() {
        return new LoginRegistrationCredentialsConverter();
    }
}
