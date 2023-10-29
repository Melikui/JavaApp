package example;

import interfaces.Callback;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Interval
 */
public class Interval {

    private Timer timer;

    public Interval() {
    }

    public Interval(Callback callback, long period) {
        timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                callback.run();
            }
        };
        timer.schedule(timerTask, 0, period);
    }

    public void cancel() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        final int[] count = {0};
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println(count[0]);
                count[0]++;
            }
        }, 3000, 1000);
    }
}


