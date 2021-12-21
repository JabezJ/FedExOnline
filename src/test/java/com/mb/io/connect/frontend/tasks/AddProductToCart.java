package com.mb.io.connect.frontend.tasks;

import com.mb.io.connect.frontend.tasks.waits.WaitFor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static com.mb.io.connect.frontend.mb.MBConnectShopPage.ADD_2_BASKET;
import static com.mb.io.connect.frontend.mb.MBConnectShopPage.PRODUCT_INFO;

public class AddProductToCart {

    public static Performable byName(String item) {
        return Task.where("{0} Select a different vehicle",
                actor -> {
                        actor.attemptsTo(
                                WaitFor.noMoreThan(5).seconds(),
                                JavaScriptClick.on(PRODUCT_INFO.of(item)),
                                WaitFor.noMoreThan(5).seconds(),
                                JavaScriptClick.on(ADD_2_BASKET)
                        );
              }
        );
    }
}


