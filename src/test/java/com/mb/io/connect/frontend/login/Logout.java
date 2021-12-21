package com.mb.io.connect.frontend.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.mb.io.connect.frontend.mb.MBConnectShopPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Logout {
    public static Performable ofConnect() throws Exception{
        return Task.where("Logs out of the account " ,
                JavaScriptClick.on(ACCOUNT),
                WaitUntil.the(LOGOUT_ACCOUNT,isVisible()).forNoMoreThan(100).seconds(),
                JavaScriptClick.on(LOGOUT),
                WaitUntil.the(LOGIN_ACCOUNT,isVisible()).forNoMoreThan(100).seconds()
        );
    }
    public static Performable ofOC2ConnectShop() throws Exception{
        return Task.where("Logs out of OC2 connect shop account " ,
                JavaScriptClick.on(OC2_USER),
                JavaScriptClick.on(OC2_LOGOUT),
                WaitUntil.the(OC2_USER,isVisible()).forNoMoreThan(10).seconds()
        );

    }
}
