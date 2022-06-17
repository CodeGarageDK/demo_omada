package com.example.demo_omada.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public abstract class BasicWebPage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @Value("${browser}")
    protected String browser;

    private int timeOut = 10;

    @PostConstruct
    public void init() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOut), this);
    }

}
