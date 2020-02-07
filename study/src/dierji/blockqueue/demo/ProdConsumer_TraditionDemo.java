package dierji.blockqueue.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShroData{ // 资源类
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void inc(){
        try {
            lock.lock();
            // 1， 判断
            while(this.num != 0){
                // 等待
                condition.await();
            }
            this.num++;
            // 干活
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            // 通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void dec(){
        try {
            lock.lock();
            // 1， 判断
            // 判断  等待的条件，注意要用 while ，不然会产生虚假唤醒，因为 if语句，会直接 执行从等待的代码 往下执行，就
            // 执行了干活的代码，导致程序多加一， 所以用while 重新检查，
            while(this.num == 0){
                // 等待
                condition.await();
            }
            //2 . 干活
            this.num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            // 通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 题目：一个初始值为0 的变量，两个线程对其交替操作，一个加一 一个减1 ，来 5轮
 * 1 线程  操作 资源类
 * 2 判断  干活  通知
 * 3 虚假唤醒
 *  3.1 错误例子
 *    虚假唤醒
 *   3.2 导致原因
 *    wait 方法 和 notify 属于 object 类
 *
 *   3.3 小总结
 *   要用while 判断
 *
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
         ShroData shroData = new ShroData();
         new Thread(()->{
             for (int i = 0; i < 5; i++) {
                 shroData.inc();
             } },"老包").start();
          new Thread(()->{
              for (int i = 0; i < 5; i++) {
                  shroData.dec();
              } },"小婷").start();
    }
}
