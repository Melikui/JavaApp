package example;

public class MyThread extends Thread {
    @Override
    public void run(){
        // 线程要执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+" --- Hello World");
        }
    }
}
