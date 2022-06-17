package com.example.demo_omada.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class CandidateHR extends BasicWebPage {

    @FindBy(how = How.CSS, using = "#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement cookieAcceptButton;

    public void isSiteLoaded() {
        cookieAcceptButton.click();
        ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
    }
}
