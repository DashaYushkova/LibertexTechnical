package utils;

import java.util.concurrent.TimeUnit;

public class Waiter {

    public static void pause(Integer seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
