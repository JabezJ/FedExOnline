package com.mb.io.connect.frontend.tasks.waits;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class TimedWaitFor {
    private long timeout;

    public TimedWaitFor (long timeout) {
        this.timeout = timeout;
    }

    public Performable seconds() {
        return new TimedWaitFor(timeout *1000).milliseconds();
    }

    public Performable milliseconds() {
        return Task.where("wait for "+ timeout + "ms",
                actor -> {
                    try {
                        Thread.sleep(timeout);
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

        ).withNoReporting();
    }
}
