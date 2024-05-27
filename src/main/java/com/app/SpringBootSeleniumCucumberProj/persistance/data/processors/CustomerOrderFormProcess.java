package com.app.SpringBootSeleniumCucumberProj.persistance.data.processors;

import com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.OrderCustomerFormFactory;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CustomerOrderFormProcess implements Processor<List<CustomerOrderForm>> {

    @Value("csv.testData.customerOrderForm")
    String csvFilePath;


    private final OrderCustomerFormFactory orderCustomerFormFactory;

    @Override
    public List<CustomerOrderForm> process() {
        var data = orderCustomerFormFactory.createLoader().load(csvFilePath);
        return orderCustomerFormFactory.createConverter().convert(data);
    }
}
