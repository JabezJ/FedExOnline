package com.mb.io.connect.frontend.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogsIn {
    public static Performable withCredentials(String user,String pass) throws Exception{
        return Task.where("Logs in with id {0}" + user,
                Enter.theValue(user).into(LoginPage.LOGIN_EMAIL),
                JavaScriptClick.on(LoginPage.LOGIN_LOAD),
                WaitUntil.the(LoginPage.LOGIN_USR,isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(user).into(LoginPage.LOGIN_USR),
                JavaScriptClick.on(LoginPage.LOGIN_SUBMIT),
                WaitUntil.the(LoginPage.LOGIN_PASS,isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(pass).into(LoginPage.LOGIN_PASS),
                JavaScriptClick.on(LoginPage.LOGIN_SUBMIT)
        );
    }
}
