package com.app.SpringBootSeleniumCucumberProj.persistance.data.converter;

public interface Converter<S,T> {
    T convert(S data);
}
