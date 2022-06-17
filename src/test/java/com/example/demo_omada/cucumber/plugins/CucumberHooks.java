package com.example.demo_omada.cucumber.plugins;

import com.example.demo_omada.webpages.FrontPage;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CucumberHooks implements ConcurrentEventListener {

    @Autowired
    private FrontPage frontPage;

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, beforeAll);
        eventPublisher.registerHandlerFor(TestRunFinished.class, afterAll);
    }

    private EventHandler<TestRunStarted> beforeAll = event -> {
        System.out.println("This is something before!");
    };

    private EventHandler<TestRunFinished> afterAll = event -> {
        System.out.println("This is something After!");
    };

}
