package com.mb.io.connect.frontend.mb;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Renew {
    public static Performable withTheDetails( String number, String date, String ref) {
        return Task.where("Renewal details are entered {0}",
                WaitUntil.the(MBConnectShopPage.NUMBER_TO_RENEW,isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(number).into(MBConnectShopPage.NUMBER_TO_RENEW),
                Enter.theValue(date).into(MBConnectShopPage.FORM_FILING_DATE),
                Enter.theValue(ref).into(MBConnectShopPage.CUSTOMER_REF),
                JavaScriptClick.on(MBConnectShopPage.CONTINUE)
        );
    }
}
