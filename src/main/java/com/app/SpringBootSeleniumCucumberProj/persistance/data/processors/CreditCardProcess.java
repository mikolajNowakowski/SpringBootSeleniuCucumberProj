package com.app.SpringBootSeleniumCucumberProj.persistance.data.processors;

import com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.CreditCardFactory;
import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreditCardProcess implements Processor<List<CreditCard>>{

    @Value("csv.testData.creditCard")
    String csvFilePath;

    private final CreditCardFactory creditCardFactory;

    @Override
    public List<CreditCard> process() {
        var data = creditCardFactory.createLoader().load(csvFilePath);
        return creditCardFactory.createConverter().convert(data);
    }
}
