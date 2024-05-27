package com.app.SpringBootSeleniumCucumberProj.persistance.data.converter;

import com.app.SpringBootSeleniumCucumberProj.model.SportTypeRegion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ToSportRegionConverter implements Converter<List<Map<String,String>>, List<SportTypeRegion>>{

    @Override
    public List<SportTypeRegion> convert(List<Map<String, String>> data) {
        return data
                .stream()
                .map(map -> SportTypeRegion
                        .builder()
                        .sportType(map.get("sportType"))
                        .region(map.get("region"))
                        .build())
                .toList();
    }
}
