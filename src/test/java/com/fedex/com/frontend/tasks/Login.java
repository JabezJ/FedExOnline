package com.fedex.com.frontend.tasks;

import com.fedex.com.frontend.pageObjects.FedexOnlinePage;
import com.fedex.com.frontend.waits.WaitFor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login {
    public static Performable intoFedExOnline(String user,String pass) throws Exception{
        return Task.where("Logs in with id {0}" + user,
                JavaScriptClick.on(FedexOnlinePage.LogInMenu),
                JavaScriptClick.on(FedexOnlinePage.LogIn),
                WaitUntil.the(FedexOnlinePage.USER,isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(user).into(FedexOnlinePage.USER),
                Enter.theValue(pass).into(FedexOnlinePage.PASS).thenHit(Keys.TAB).thenHit(Keys.TAB).thenHit(Keys.TAB),
                WaitFor.noMoreThan(3).seconds(),
                WaitUntil.the(FedexOnlinePage.LogIn_Btn,isVisible()).forNoMoreThan(5).seconds(),
                JavaScriptClick.on(FedexOnlinePage.LogIn_Btn)
        );
    }

}
