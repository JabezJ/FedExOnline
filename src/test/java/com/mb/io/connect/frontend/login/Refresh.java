package com.mb.io.connect.frontend.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Refresh {
    public static Performable thePage() {
        return Task.where("{0} refreshes the page",
            actor -> {
                BrowseTheWeb.as(actor).getDriver().navigate().refresh();
            }
        ).withNoReporting();
    }
}
