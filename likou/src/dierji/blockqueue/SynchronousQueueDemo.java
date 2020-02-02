package dierji.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * SynchronousQueue 是一个不存储元素的BlockingQueue
 * 每一个put 操作必须要等待一个take 操作，否则不能继续添加元素，反之亦然
 *
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
         new Thread(()->{
             try {
                 blockingQueue.put("AA");
                 System.out.println(Thread.currentThread().getName()+"放入元素A\t");
                 blockingQueue.put("bb");
                 System.out.println(Thread.currentThread().getName()+"放入元素b\t");
                 blockingQueue.put("CC");
                 System.out.println(Thread.currentThread().getName()+"放入元素CC\t");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },"AA").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+blockingQueue.take()+"\t");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+blockingQueue.take()+"\t");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+blockingQueue.take()+"\t");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"bb").start();
    }
}
