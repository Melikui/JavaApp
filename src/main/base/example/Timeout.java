package example;

import interfaces.Callback;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timeout
 * 稍微封装一下
 */
public class Timeout {

    private Timer timer;

    public Timeout() {
    }

    public Timeout(Callback callback, long delay) {
        timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                callback.run();
                // 执行完就退出
                timer.cancel();
            }
        };
        timer.schedule(timerTask, delay);
    }

    public void cancel() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
