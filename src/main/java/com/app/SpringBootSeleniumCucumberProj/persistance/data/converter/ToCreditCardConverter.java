package com.app.SpringBootSeleniumCucumberProj.persistance.data.converter;

import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ToCreditCardConverter implements Converter<List<Map<String, String>>, List<CreditCard>>{
    @Override
    public List<CreditCard> convert(List<Map<String, String>> data) {
        return data.stream().map(map ->
         CreditCard.builder()
                .cardNumber(map.get("cardNumber"))
                .cardExpirationDate(map.get("cardExpirationDate"))
                .cvcNumber(map.get("cvcNumber"))
                .build()

        ).toList();
    }
}
