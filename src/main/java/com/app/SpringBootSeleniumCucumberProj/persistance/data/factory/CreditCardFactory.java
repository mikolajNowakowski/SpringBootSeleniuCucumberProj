package com.app.SpringBootSeleniumCucumberProj.persistance.data.factory;

import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.Converter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.ToCreditCardConverter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.CsvDataLoader;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.Loader;
import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class CreditCardFactory implements Factory<List<Map<String,String>>,List<CreditCard>>{
    @Override
    public Loader<List<Map<String, String>>> createLoader() {
        return new CsvDataLoader();
    }

    @Override
    public Converter<List<Map<String, String>>, List<CreditCard>> createConverter() {
        return new ToCreditCardConverter();
    }
}
