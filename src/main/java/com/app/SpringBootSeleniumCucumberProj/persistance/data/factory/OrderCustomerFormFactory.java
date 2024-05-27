package com.app.SpringBootSeleniumCucumberProj.persistance.data.factory;

import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.Converter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.ToOrderCustomerOrderFormConverter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.CsvDataLoader;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.Loader;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;
@Component
public class OrderCustomerFormFactory implements Factory<List<Map<String, String>>, List<CustomerOrderForm>>{
    @Override
    public Loader<List<Map<String, String>>> createLoader() {
        return new CsvDataLoader();
    }

    @Override
    public Converter<List<Map<String, String>>, List<CustomerOrderForm>> createConverter() {
        return new ToOrderCustomerOrderFormConverter();
    }
}
