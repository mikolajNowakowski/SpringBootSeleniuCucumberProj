package com.app.SpringBootSeleniumCucumberProj.config.faker;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {
    @Bean
    public Faker faker(){
        return new Faker();
    }
}
