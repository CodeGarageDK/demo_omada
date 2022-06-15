package com.example.demo_omada.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidateHR extends BasicWebPage {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriverWait wait;

    @FindBy(how = How.CSS, using = "#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement cookieAcceptButton;

/*    @FindBy(how = How.CSS, using = "#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement locationHeader;*/

    public void isSiteLoaded() {
        cookieAcceptButton.click();
        ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equals("complete");
/*        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("return document.readyState").toString().equals("complete");*/
    }
}
