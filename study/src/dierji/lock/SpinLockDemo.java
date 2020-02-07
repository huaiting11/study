package dierji.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 题目： 实现一个自旋锁
 * 自旋锁的好处： 循环比较获取直到成功为止，没有类似wait 的阻塞
 * 通过CAS 操作完成 自旋锁 A线程 先进来 调用myLock 方法自己 持有锁
 * 5秒钟，B 随后进来后发现 当前有线程持有 锁，不是null ，所以
 * 只能通过自旋等待，直到A 释放锁 B 随后 抢到
 *
 *
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"come in ");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println("释放锁了");
        atomicReference.compareAndSet(thread,null);
    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
         new Thread(()->{
             spinLockDemo.myLock();
             try {
                 TimeUnit.SECONDS.sleep(5);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             spinLockDemo.unlock();
         },"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         new Thread(()->{
             spinLockDemo.myLock();
             spinLockDemo.unlock();
                         },"t2").start();
    }

}
