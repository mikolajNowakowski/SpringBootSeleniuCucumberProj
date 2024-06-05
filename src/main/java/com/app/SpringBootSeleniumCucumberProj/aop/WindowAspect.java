package com.app.SpringBootSeleniumCucumberProj.aop;

import com.app.SpringBootSeleniumCucumberProj.annotation.Window;
import com.app.SpringBootSeleniumCucumberProj.utils.WindowsSwitchService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowsSwitchService windowsSwitchService;

    @Before("@target(window) && within(com.app.SpringBootSeleniumCucumberProj..*)")
    public void before(Window window) {
        windowsSwitchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.app.SpringBootSeleniumCucumberProj..*)")
    public void after(Window window) {
        windowsSwitchService.switchByIdx(0);
    }

}
