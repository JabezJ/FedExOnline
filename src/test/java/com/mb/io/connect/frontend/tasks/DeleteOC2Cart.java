package com.mb.io.connect.frontend.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import java.util.List;

import static com.mb.io.connect.frontend.mb.MBConnectShopPage.OC2_CART;
import static com.mb.io.connect.frontend.mb.MBConnectShopPage.OC2_CART_DELETE;

public class DeleteOC2Cart {

    public static Performable items() {
        return Task.where("{0} delete all the items of Shopping Cart",
                actor -> {
                    List<WebElementFacade> cart = OC2_CART.resolveAllFor(actor);
                    if (cart.size() >= 1) {
                        actor.attemptsTo(
                                JavaScriptClick.on(OC2_CART)
                        );

                        // WaitUntilElement.visible(CONTINUE_SHIPPING);
                        List<WebElementFacade> deleteItem = OC2_CART_DELETE.resolveAllFor(actor);
                        if (deleteItem.size() >= 1) {
                            for (int i = 0; i < deleteItem.size(); i++) {
                                actor.attemptsTo(
                                        JavaScriptClick.on(OC2_CART_DELETE)
                                );
                            }
                        }
                    }
                }
        );
    }

}


