package duoxiancheng;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {
    public int ticket=30;
    private final Lock lock = new ReentrantLock(); // 可重入锁;
    //synchronized
    /*public  synchronized  void sale(){
        if(ticket > 0 ){
            System.out.println(Thread.currentThread().getName()+ticket);
            ticket--;
        }
    }*/
    //ReentrantLock是可重入锁，它和synchronized一样，一个线程可以多次获取同一个锁。
    public void sale(){
        lock.lock();
        try {
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+ticket);
                ticket--;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    // wait 会释放锁，sleep 释放锁。 .start 并不是立即启动线程，而是等到cpu 执行

    // java 程序入口，就是由jvm 启动mian 线程，main 线程又可以启动其他线程。
}
