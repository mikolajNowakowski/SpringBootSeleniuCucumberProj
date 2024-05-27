package com.app.SpringBootSeleniumCucumberProj.persistance.data.factory;

import com.app.SpringBootSeleniumCucumberProj.persistance.data.converter.Converter;
import com.app.SpringBootSeleniumCucumberProj.persistance.data.loader.Loader;

public interface Factory <S,T>{

    Loader<S> createLoader();
    Converter<S,T> createConverter();


}
