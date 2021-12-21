package com.mb.io.connect.frontend.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.mb.io.connect.frontend.mb.MBConnectShopPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class Login {
    public static Performable withCredentials(String user,String pass) throws Exception{
        return Task.where("Logs in with id {0}" + user,
                Enter.theValue(user).into(EMAIL),
                JavaScriptClick.on(CONTINUE_LOGIN),
                WaitUntil.the(WITH_PASSWORD,isVisible()).forNoMoreThan(100).seconds(),
                JavaScriptClick.on(LOGIN_WITH_PASSWORD),
                WaitUntil.the(LoginPage.PASS,isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(pass).into(PASSWORD),
                JavaScriptClick.on(CONTINUE_CONFIRM),
                WaitUntil.the(DEFINE,isVisible()).forNoMoreThan(100).seconds()
        );
    }
    public static Performable intoOC2ConnectShop(String user,String pass) throws Exception{
        return Task.where("Logs in with id {0}" + user,
                Enter.theValue(user).into(EMAIL),
                JavaScriptClick.on(CONTINUE_LOGIN),
                WaitUntil.the(WITH_PASSWORD,isVisible()).forNoMoreThan(100).seconds(),
                JavaScriptClick.on(LOGIN_WITH_PASSWORD),
                WaitUntil.the(LoginPage.PASS,isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(pass).into(PASSWORD),
                JavaScriptClick.on(CONTINUE_CONFIRM)
        );
    }
}
