package com.app.SpringBootSeleniumCucumberProj.persistance.repositories;

import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.CustomerOrderFormProcess;

import java.util.List;

public class CustomerOrderFormRepo implements Repository<CustomerOrderForm> {

    private final List<CustomerOrderForm> customerOrderFormList;
    public CustomerOrderFormRepo(CustomerOrderFormProcess customerOrderFormProcess) {
        customerOrderFormList = customerOrderFormProcess.process();
    }
    @Override
    public CustomerOrderForm findByIndex(int index) {
        if (index >= customerOrderFormList.size()) {
            throw new IllegalArgumentException("Impossible to load customer data.");
        }
        return customerOrderFormList.get(index);
    }
}
