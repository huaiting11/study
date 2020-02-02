package dierji;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo { // ABA 问题的解决
    static AtomicReference<Integer> atomicReference  = new AtomicReference<>();
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("================以下是ABA问题的产生==================");
         new Thread(()->{
             atomicReference.compareAndSet(100,101);
             atomicReference.compareAndSet(101,100);
                         },"t1").start();
          new Thread(()->{
              try {
                  TimeUnit.SECONDS.sleep(1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println(
                      atomicReference.compareAndSet(100,2017)+"\t"+
                      atomicReference.get());
          },"t2").start();
          // 暂停一会儿线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==================ABA 问题解决");
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次版本号"+stamp);
            // 暂停3秒钟，t3 线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次版本号"+stamp);
            // 暂停3秒钟，t4 线程，保证上面的t3 线程 完成了一次ABA 操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t4").start();
    }

}
