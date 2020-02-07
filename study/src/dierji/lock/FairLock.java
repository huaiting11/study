package dierji.lock;

/**
 * 公平锁 是指多个线程按照申请锁的顺序来获取锁，类似排队打饭，先来后到
 *
 * 非公平锁， 是指多个线程获取锁的顺序并不是按照申请锁的顺序，
 * 有可能后申请的线程比先申请的线程优先获取锁
 * 在高并发的情况下，有可能会造成优先级反转 或者饥饿现象
 *
 * 公平锁/ 非公平锁
 * 并发包中ReentrantLock 的创建 可以指定构造函数的boolean 类型来得到公平锁
 * 或者非公平锁，默认是非公平锁
 *
 * 公平锁： 就是很公平，在并发环境中，每个线程在获取锁时会先查看此锁维护的等待队列
 * ，如果为空，或者当前线程是等待队列的第一个，就占有锁，否则就加入等待队列中
 *
 * 非公平
 * 尝试 获得锁，没有获得，按照公平锁
 *
 * 非公平锁的优点 在于 吞吐量 比 公平锁大
 *
 * 对于Synchronized 而言，是非公平锁
 *
 */

/**
 * 可重入锁，（递归锁） 防止死锁
 * 指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获得该锁的代码，
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 * 也就是说，线程可以进入任何一个它已经 拥有的锁 所同步着的代码块
 *synchronized 和 ReentrantLock 都是可重入锁
 * 代码
 * 小总结
 */

/**
 * 自旋锁
 * 是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去获取锁
 * 这样的好处是减少线程上下文切换的消耗，缺点是循环会消耗cpu
 *
 *
 *
 *
 */
class Ticket{
    int num = 0;
    public synchronized  void  m1(){
        System.out.println(Thread.currentThread().getName()+"m1");
        this.num++;
        m2();
    }
    public synchronized  int  m2(){
        System.out.println(Thread.currentThread().getName()+"m2");
        return this.num;
    }
}

public class FairLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
         new Thread(()->{
             ticket.m1();
                         },"t1").start();
        new Thread(()->{
            ticket.m1();
        },"t2").start();
    }
}
