package com.example.demo_omada.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OmadaIdentityCloudPage extends BasicWebPage{

    @Autowired
    private WebDriver webDriver;

    @Autowired
    protected WebDriverWait wait;

    @FindBy(how = How.CSS, using = "body > section.m-hero-cta.bg-lightblue > div.container > div > div > div > p.button-wrapper > a > span")
    private WebElement bookADemo;

    @FindBy(how = How.CSS, using="body > footer > div > div.wrapper-links > div > div:nth-child(4) > div > span")
    private WebElement companyHeaderInBottomMenu;

    public boolean isBookADemoButtonClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(bookADemo));
        return true;
    }

    public boolean isBookADemoButtonTextPresent(){
        return !bookADemo.getText().equals("");
    }

    public boolean isCompanyHeaderTextInBottomMenyPresent(){
        return !companyHeaderInBottomMenu.getText().equals("");
    }
}
