package example;

public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        // 线程要执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+" --- Hello World");
        }
    }
}

