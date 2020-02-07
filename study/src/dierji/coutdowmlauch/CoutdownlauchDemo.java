package dierji.coutdowmlauch;

/**
 * ctrl+ rlt + m  提取公共代码
 */
/*
  让一些线程阻塞直到另外一些线程 完成 一系列 操作 才被唤醒
  CountDownLatch 主要有两个方法，当一个或者 多个线程 调用 awit 方法时，调用线程 会被阻塞
  其他线程 调用 countdDown 方法会将 计数器 减1 (线程不会阻塞)
  当计数器的值 变为零 时，因调用await 方法被阻塞的线程会被唤醒 ，继续执行

 */

import java.util.concurrent.CountDownLatch;

public class CoutdownlauchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
             new Thread(()->{
                 System.out.println(Thread.currentThread().getName()+"被消灭了");
                 countDownLatch.countDown();
                             },CountryEnum.foreach(i).getRetMessage()).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"秦国统一");
    }

    private static void countdown() {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <=6; i++) {
             new Thread(()->{
                 System.out.println(Thread.currentThread().getName()+"\t上完自行，离开教室");
                 countDownLatch.countDown();
                             },String.valueOf(i)).start();
        }
        try {
            countDownLatch.await(); // 阻塞 等人
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t 班长最后关灯走人");
    }

}
