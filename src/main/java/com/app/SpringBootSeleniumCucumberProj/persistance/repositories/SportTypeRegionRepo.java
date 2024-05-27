package com.app.SpringBootSeleniumCucumberProj.persistance.repositories;

import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.SportTypeRegion;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.CreditCardProcess;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.processors.SportTypeRegionProcess;

import java.util.List;

public class SportTypeRegionRepo implements Repository<SportTypeRegion> {

    private final List<SportTypeRegion> sportTypeRegionList;
    public SportTypeRegionRepo(SportTypeRegionProcess sportTypeRegionProcess) {
        sportTypeRegionList = sportTypeRegionProcess.process();
    }
    @Override
    public SportTypeRegion findByIndex(int index) {
        if (index >= sportTypeRegionList.size()) {
            throw new IllegalArgumentException("Impossible to load sport type and region data.");
        }
        return sportTypeRegionList.get(index);
    }
}
