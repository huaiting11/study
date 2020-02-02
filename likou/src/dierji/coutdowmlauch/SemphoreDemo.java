package dierji.coutdowmlauch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号灯
 * 信号量 主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制
 * 争夺车位
 */
public class SemphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // 模拟3 个停车位
        for (int i = 0; i < 6; i++) {  // 模拟6 部汽车
             new Thread(()->{
                 try {
                     semaphore.acquire();
                     System.out.println(Thread.currentThread().getName()+"抢到车位");
                     TimeUnit.SECONDS.sleep(3);
                     System.out.println(Thread.currentThread().getName()+"离开停车");
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }finally {
                     semaphore.release();

                 }},String.valueOf(i)).start();

        }

    }
}
