package com.example.demo_omada.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@TestComponent
public abstract class BasicWebPage {

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait wait;

    private int timeOut = 10;

    @PostConstruct
    public void init() {
//        PageFactory.initElements(webDriver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, timeOut), this);
    }

/*    public void openPage(){
        webDriver.get("https://omadaidentity.com/");
        System.out.println("Hey");
    }

    @FindBy(how = How.CSS, using = "#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement allowCookies;

    @FindBy(how = How.CSS, using = "#menu-item-727 > a")
    public WebElement products;

    public void allowAllCookies(){
    allowCookies.click();
    }

    public void clickProducts() {
        products.click();
    }*/

/*    public void selectLinkByCss(String css){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
        webDriver.findElement(By.cssSelector(css)).click();
    }

    public boolean isTextEqualToElementText(String css, String text){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
        WebElement webElement = webDriver.findElement(By.cssSelector(css));
        boolean result = text.equals(webElement.getText());
        return result;
    }*/
}
