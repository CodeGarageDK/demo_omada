package com.example.demo_omada.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class CareersPage extends BasicWebPage {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriverWait wait;

    @FindBy(how = How.CSS, using = "body > section.m-text-image.pt-venti.pb-grande.bg-lightblue1.section-wide > div > div > div.col-xs-12.col-sm-6.col-content > div > p.button-wrapper > a > span")
    WebElement searchJobOpeningsButton;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.u-heading-block > div > div > h2")
    WebElement meetOmadiansHeader;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.leadership-list > div:nth-child(1) > div > img")
    WebElement gryCollignon;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.u-modal-overlay-slide.slide.is-active > div.modal-wrapper > div > div > div > div > p:nth-child(1)")
    WebElement omadianText;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.leadership-list > div:nth-child(3) > div")
    WebElement dariaCzajkowska;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.u-modal-overlay > span.icon-close.js-modal-close > img")
    WebElement clickClosePerson;

    public void closePerson() {
        clickClosePerson.click();
    }

    public void clickSearchJobOpeningsButton() {
        searchJobOpeningsButton.click();
    }

    public void clickGryColligon() {
        try {
            ((JavascriptExecutor) webDriver).executeAsyncScript("arguments[0].scrollIntoView(true);", meetOmadiansHeader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        gryCollignon.click();
    }


    public void clickDariaCzajkowska() {
        try {
            ((JavascriptExecutor) webDriver).executeAsyncScript("arguments[0].scrollIntoView(true);", meetOmadiansHeader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dariaCzajkowska.click();
    }

    public boolean isOmadianTextEqual(String path) throws IOException {
        String expectedText = Files.readString(Path.of(path));
        return expectedText.equals(omadianText.getText());
    }

}
