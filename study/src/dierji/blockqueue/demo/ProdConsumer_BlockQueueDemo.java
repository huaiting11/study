package dierji.blockqueue.demo;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private AtomicInteger atomicInteger = new AtomicInteger();
    private volatile boolean flag = true ; // 默认 开启，进行生产+ 消费
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProduct() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (flag){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t插入队列成功"+data);
            }else{
                System.out.println(Thread.currentThread().getName()+"\t插入队列失败");
            }
           // TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName()+"\t大老板叫停下来flag = 发色、");
    }
    public void myConsumer() throws InterruptedException {
        String result = null;
        while (flag){
            result  = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(result == null || result.equals("")){
               flag = false;
                System.out.println(Thread.currentThread().getName()+"\t超过2秒钟，消费退出 = 发色、");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t取到值"+result);
        }
    }
    public void stop(){
        this.flag = false;
    }
}
/**
 * volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(1));
         new Thread(()->{
             System.out.println(Thread.currentThread().getName()+"启动了");
             System.out.println();
             System.out.println();
             System.out.println();
             try {
                 myResource.myProduct();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },"生产线程").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"启动了");
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费线程").start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("3秒到了");
        myResource.stop();

    }
}
