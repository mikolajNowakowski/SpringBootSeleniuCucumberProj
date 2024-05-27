package com.app.SpringBootSeleniumCucumberProj.persistance.repositories;

import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.CreditCardProcess;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.CustomerOrderFormProcess;

import java.util.List;

public class CreditCardRepo implements Repository<CreditCard> {

    private final List<CreditCard> creditCardList;
    public CreditCardRepo(CreditCardProcess creditCardProcess) {
        creditCardList = creditCardProcess.process();
    }
    @Override
    public CreditCard findByIndex(int index) {
        if (index >= creditCardList.size()) {
            throw new IllegalArgumentException("Impossible to load customer data.");
        }
        return creditCardList.get(index);
    }
}
