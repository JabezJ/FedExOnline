package com.mb.io.connect.frontend.tasks;

import com.mb.io.connect.frontend.tasks.waits.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import java.util.List;

import static com.mb.io.connect.frontend.mb.MBConnectShopPage.*;

public class SelectVehicle {

    public static Performable withVIN(String vin) {
        return Task.where("{0} Select a different vehicle",
                actor -> {
                    List<WebElementFacade> vehicle = VEHICLE.of(vin).resolveAllFor(actor);
                    if (vehicle.size() < 1) {
                        actor.attemptsTo(
                                WaitFor.noMoreThan(2).seconds(),
                                JavaScriptClick.on(VEHICLE_SELECT),
                                WaitFor.noMoreThan(2).seconds(),
                                JavaScriptClick.on(VEHICLE.of(vin)),
                                WaitFor.noMoreThan(2).seconds(),
                                JavaScriptClick.on(CLOSE_VEHICLE_SELECT)
                        );
                    }
              }
        );
    }
}


