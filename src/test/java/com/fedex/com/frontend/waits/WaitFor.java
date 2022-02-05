package com.fedex.com.frontend.waits;

public class WaitFor{

    public static TimedWaitFor noMoreThan(long timeout) {
        return new TimedWaitFor(timeout);
    }

}
