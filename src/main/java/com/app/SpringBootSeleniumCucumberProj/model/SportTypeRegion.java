package com.app.SpringBootSeleniumCucumberProj.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportTypeRegion implements TestDataObj {
    private String sportType;
    private String region;
}
