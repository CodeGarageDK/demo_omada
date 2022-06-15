package com.example.demo_omada.webpages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FrontPage extends BasicWebPage {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriverWait wait;

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

    public void openPage() {
        webDriver.get(mainUrl);
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equals("complete");
    }

    public void clickAcceptAllCookies() {
        allowCookies.click();
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
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
/*        try {
            ((JavascriptExecutor) webDriver).executeAsyncScript("arguments[0].scrollIntoView(true);", omadaItentityCloudBottom);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

/*        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", omadaItentityCloudBottom);*/
        wait.until(ExpectedConditions.elementToBeClickable(omadaItentityCloudBottom));
        omadaItentityCloudBottom.click();
    }

    public void clickHeaderMenuCompanyCareers() {
        company.click();
        wait.until(ExpectedConditions.elementToBeClickable(careers));
        careers.click();
    }
}
