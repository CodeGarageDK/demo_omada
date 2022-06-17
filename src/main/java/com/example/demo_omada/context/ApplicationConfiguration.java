package com.example.demo_omada.context;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.Duration;

@Configuration
public class ApplicationConfiguration {

    private final int waitInSeconds = 10;

    @Bean(destroyMethod = "quit")
    @Scope("singleton")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-bLocking ");
        options.addArguments("profile.cookie_controls_mode", "0");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);

    }

    @Bean(destroyMethod = "quit")
    @Scope("singleton")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Bean(destroyMethod = "quit")
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Scope("singleton")
    public WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    @Bean
    @Scope("singleton")
    public WebDriverWait getWebDriverWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(waitInSeconds));
    }
}
