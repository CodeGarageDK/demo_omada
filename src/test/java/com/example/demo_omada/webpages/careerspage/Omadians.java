package com.example.demo_omada.webpages.careerspage;

import com.example.demo_omada.webpages.BasicWebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Omadians extends BasicWebPage {

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.leadership-list > div:nth-child(1) > div > img")
    private WebElement gryCollignon;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.leadership-list > div:nth-child(3) > div")
    private WebElement dariaCzajkowska;

    @Bean
    public Map<String, WebElement> getOmadians() {
        Map<String, WebElement> omadians = new HashMap<>();
        omadians.put("Gry Collignon", gryCollignon);
        omadians.put("Daria Czajkowska", dariaCzajkowska);
        return omadians;
    }

}
