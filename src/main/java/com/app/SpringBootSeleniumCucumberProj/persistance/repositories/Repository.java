package com.app.SpringBootSeleniumCucumberProj.persistance.repositories;

public interface Repository<T> {
    T findByIndex(int index);
}
