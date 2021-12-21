package com.mb.io.connect.frontend.tasks;

import com.mb.io.connect.frontend.login.WaitUntilElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.mb.io.connect.frontend.mb.MBConnectShopPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DeleteCart {

    public static Performable items() {
        return Task.where("{0} delete all the items of Shopping Cart",
                actor -> {
                    actor.attemptsTo(
                            JavaScriptClick.on(OPEN_CART_ICON)
                    );
                    List<WebElementFacade> emptyCart = EMPTY_CART.resolveAllFor(actor);
                    if (emptyCart.isEmpty()) {
                        WaitUntilElement.visible(GOTO_SHOPPING_CART);
                        actor.attemptsTo(
                                JavaScriptClick.on(GOTO_SHOPPING_CART),
                                WaitUntil.the(CONTINUE_SHIPPING,isVisible())
                        );
                       // WaitUntilElement.visible(CONTINUE_SHIPPING);
                        List<WebElementFacade> deleteItem = DELETE_PRODUCT.resolveAllFor(actor);
                        if (deleteItem.size() >= 1) {
                            for(int i=0;i<deleteItem.size();i++) {
                                actor.attemptsTo(
                                        JavaScriptClick.on(DELETE_PRODUCT),
                                        WaitUntil.the(DELETE_CART_ITEM,isVisible())
                                );
                               // WaitUntilElement.visible(DELETE_CART_ITEM.resolveFor(actor));
                                actor.attemptsTo(
                                        JavaScriptClick.on(DELETE_CART_ITEM),
                                        WaitUntil.the(HOME_PAGE,isVisible())
                                );
                              //  WaitUntilElement.visible(HOME_PAGE.resolveFor(actor));
                            }
                        }
                        //Back to homepage
                        actor.attemptsTo(
                                JavaScriptClick.on(HOME_PAGE)
                        );
                    }else
                    {
                        actor.attemptsTo(
                                JavaScriptClick.on(CLOSE_CART)
                        );
                    }
                }
        );
    }

}


