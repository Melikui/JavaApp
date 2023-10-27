package example;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 线程要执行的代码
        for (int i = 0; i < 100; i++) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "---Hello World~");
        }
    }
}
