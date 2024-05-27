package com.app.SpringBootSeleniumCucumberProj.persistance.data.processors;

import com.app.SpringBootSeleniumCucumberProj.persistance.data.factory.SportTypeRegionFactory;
import com.app.SpringBootSeleniumCucumberProj.model.SportTypeRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SportTypeRegionProcess implements Processor<List<SportTypeRegion>>{

    @Value("csv.testData.sportTypeRegion")
    String csvFilePath;

    private final SportTypeRegionFactory sportTypeRegionFactory;

    @Override
    public List<SportTypeRegion> process() {
        var data = sportTypeRegionFactory.createLoader().load(csvFilePath);
        return sportTypeRegionFactory.createConverter().convert(data);
    }
}