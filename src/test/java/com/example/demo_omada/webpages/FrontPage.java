package com.example.demo_omada.webpages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FrontPage extends BasicWebPage {

    @Value("${main.url}")
    private String mainUrl;

    @FindBy(how = How.CSS, using = "#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement allowCookies;

    @FindBy(how = How.CSS, using = "#menu-item-727 > a")
    private WebElement products;

    @FindBy(how = How.CSS, using = "#menu-item-727 > div > div > div.mega-menu-nav > ul > li:nth-child(1) > a")
    private WebElement omadaItentityCloudHeaderMenu;

    @FindBy(how = How.CSS, using = "#menu-item-2263 > a")
    private WebElement omadaItentityCloudBottom;

    @FindBy(how = How.CSS, using = "#menu-item-731 > a")
    private WebElement company;

    @FindBy(how = How.CSS, using = "#menu-item-731 > div > div > div.mega-menu-nav > ul > li:nth-child(2) > a")
    private WebElement careers;

    public void openPageAllowCookies() {
        driver.get(mainUrl);
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.elementToBeClickable(allowCookies));
        allowCookies.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(allowCookies)));
    }


    public void openPage() {
        driver.get(mainUrl);
        wait.until(
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void clickProducts() {
        products.click();
    }

    public void clickHeaderMenuOmadaIdentityCloudPage() {
        wait.until(ExpectedConditions.elementToBeClickable(omadaItentityCloudHeaderMenu));
        omadaItentityCloudHeaderMenu.click();
    }

    public void clickBottomMenuOmadaIdentityCloudPage() {
        wait.until(
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        wait.until(ExpectedConditions.elementToBeClickable(omadaItentityCloudBottom));
        omadaItentityCloudBottom.click();
    }

    public void clickHeaderMenuCompanyCareers() {
        company.click();
        wait.until(ExpectedConditions.elementToBeClickable(careers));
        careers.click();
    }
}
