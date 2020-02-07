package duoxiancheng;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 尽管有两个线程在调用，但是tash 里的方法只被调用了一次
 */
public class CallAbleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask tash = new FutureTask(new MyThread());
        Thread t1 = new Thread(tash);
        Thread t2 = new Thread(tash);
        t1.start();
        t2.start();
        System.out.println(tash.get());
    }
}
