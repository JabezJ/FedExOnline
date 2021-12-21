package com.mb.io.connect.frontend.tasks.waits;

public class WaitFor{

    public static TimedWaitFor noMoreThan(long timeout) {
        return new TimedWaitFor(timeout);
    }

}
