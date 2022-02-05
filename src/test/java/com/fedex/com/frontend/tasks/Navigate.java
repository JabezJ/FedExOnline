package com.fedex.com.frontend.tasks;

import com.fedex.com.frontend.pageObjects.FedexOnlinePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {

    public static Performable toTheOnlinePortal(String baseUrl) {
        return Task.where("{0} navigates to the connect shop",
                actor -> {
                    actor.attemptsTo(
                            Open.browserOn().thePageNamed(baseUrl)
                    );
                  //  WebDriver driver = BrowseTheWeb.as(actor).getDriver();
                    if (!FedexOnlinePage.COOKIE.resolveAllFor(actor).isEmpty()) {
                        actor.attemptsTo(
                                JavaScriptClick.on(FedexOnlinePage.COOKIE)
                        );
                    }

                    if (!FedexOnlinePage.AlertBtn.resolveAllFor(actor).isEmpty()) {
                        actor.attemptsTo(
                                JavaScriptClick.on(FedexOnlinePage.AlertBtn)
                        );
                    }

                }
        );
    }

}


