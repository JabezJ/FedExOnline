package com.fedex.com.frontend.tasks;

import com.fedex.com.frontend.pageObjects.FedexOnlinePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class Logout {
    public static Performable ofFedExOnline() throws Exception{
        return Task.where("Logs out of FedEx Online account " ,
                JavaScriptClick.on(FedexOnlinePage.LogInMenu),
                JavaScriptClick.on(FedexOnlinePage.SignOut)
        );
    }
}
