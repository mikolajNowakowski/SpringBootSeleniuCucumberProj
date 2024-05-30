package com.app.SpringBootSeleniumCucumberProj.persistance.repositories;

import java.util.List;

public interface Repository<T> {
    T findByIndex(int index);

    List<T> getAll();
}
