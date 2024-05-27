package com.app.SpringBootSeleniumCucumberProj.persistance.data.loader;

import java.util.List;

public interface Loader<T> {
    T load(String path);
}
