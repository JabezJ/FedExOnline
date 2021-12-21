package com.mb.io.connect.frontend.tasks;

import com.mb.io.connect.frontend.login.WaitUntilElement;
import com.mb.io.connect.frontend.tasks.waits.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import java.util.List;

import static com.mb.io.connect.frontend.mb.MBConnectShopPage.*;

public class CheckOutOC2Cart {

    public static Performable items() {
        return Task.where("{0} checkout all the items of Shopping Cart",
                actor -> {

                    List<WebElementFacade> cart = OC2_CART.resolveAllFor(actor);
                    if (cart.size() >= 1) {
                        actor.attemptsTo(
                                WaitFor.noMoreThan(5).seconds(),
                                JavaScriptClick.on(OC2_CART),
                                WaitFor.noMoreThan(2).seconds(),
                                JavaScriptClick.on(OC2_GO_TO_BASKET)
                        );

                        actor.attemptsTo(
                                JavaScriptClick.on(OC2_CHECKOUT)
                        );
                        WaitUntilElement.visible(OC2_CHECK_ORDER.resolveFor(actor));

                        actor.attemptsTo(
                                JavaScriptClick.on(OC2_CHECK_ORDER)
                        );


                    }
                }
        );
    }

}


