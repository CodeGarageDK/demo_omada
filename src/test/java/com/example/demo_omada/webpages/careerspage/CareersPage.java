package com.example.demo_omada.webpages.careerspage;

import com.example.demo_omada.webpages.BasicWebPage;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@Getter
public class CareersPage extends BasicWebPage {


    @Value("${prepath:src/test/resources/validation_texts/}")
    private String pathBegin;

    @FindBy(how = How.CSS, using = "body > section.m-text-image.pt-venti.pb-grande.bg-lightblue1.section-wide > div > div > div.col-xs-12.col-sm-6.col-content > div > p.button-wrapper > a > span")
    private WebElement searchJobOpeningsButton;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.u-heading-block > div > div > h2")
    private WebElement meetOmadiansHeader;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.u-modal-overlay-slide.slide.is-active > div.modal-wrapper > div > div > div > div > p:nth-child(1)")
    private WebElement omadianText;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.u-modal-overlay > span.icon-close.js-modal-close > img")
    private WebElement clickClosePerson;


    public void closePerson() {
        clickClosePerson.click();
    }

    public void clickSearchJobOpeningsButton() {
        searchJobOpeningsButton.click();
    }

    public void clickOmadian(WebElement omadian) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", omadian);
        Thread.sleep(500);
        omadian.click();
    }

    public boolean isOmadianTextEqual(String path) throws IOException {
        String expectedText = Files.readString(Path.of(pathBegin + path));
        wait.until(ExpectedConditions.visibilityOf(omadianText));
        return expectedText.equals(omadianText.getText());
    }

}
