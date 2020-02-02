package duoxiancheng;

import java.util.concurrent.*;

/**
 * 例子：
 *
 * 线程池的优势：
 * 线程池做的工作主要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建启动这些任务，
 * 如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务执行
 * 它的主要特点：线程复用，控制最大并发数量，管理线程
 * 第一：降低资源消耗，通过重复利用已经已经创建的线程降低线程创建和销毁造成的消耗‘
 * 第二：提高响应速度，当任务到达时，任务可以不需要等待线程创建就能立即执行
 * 第三：提高线程的可管理性，线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低
 * 系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
 */

/**
 *   // ExecutorService ex = Executors.newFixedThreadPool(6); // 一池5个工作线程，类似一个银行5个创类
 *         //ExecutorService ex = Executors.newSingleThreadExecutor();
 *         ExecutorService ex = Executors.newCachedThreadPool();
 * ThreadPoolExecutor 线程池 底层都是这个类
 */

/**
 * ThreadPoolExecutor 这个类有七个参数
 *
 *public ThreadPoolExecutor(int corePoolSize,    线程中的常驻核心线程数
 *                               int maximumPoolSize,  线程中能够容纳同时执行的最大线程数，此值大于1
 *                               long keepAliveTime,  多余的空闲线程的存活时间，
 *                               TimeUnit unit,   keepAliveTime 的单位
 *                               BlockingQueue<Runnable> workQueue,  任务队列 ，被提交但是未被执行的队列
 *                               ThreadFactory threadFactory, 表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认的即可
 *                               RejectedExecutionHandler handler) { 拒绝策略，表示当队列满了，并且工作线程大于maximumPoolSize
 *                               时如何拒绝请求执行的runnable 的策略
 *         if (corePoolSize < 0 ||
 *             maximumPoolSize <= 0 ||
 *             maximumPoolSize < corePoolSize ||
 *             keepAliveTime < 0)
 *             throw new IllegalArgumentException();
 *         if (workQueue == null || threadFactory == null || handler == null)
 *             throw new NullPointerException();
 *         this.corePoolSize = corePoolSize;
 *         this.maximumPoolSize = maximumPoolSize;
 *         this.workQueue = workQueue;
 *         this.keepAliveTime = unit.toNanos(keepAliveTime);
 *         this.threadFactory = threadFactory;
 *         this.handler = handler;
 *     }
 */

/**
 *
 */
public class Pool {
    public static void main(String[] args) {
       ExecutorService ex = Executors.newFixedThreadPool(6); // 一池5个工作线程，类似一个银行5个创类
        //ExecutorService ex = Executors.newSingleThreadExecutor();
        //ExecutorService ex = Executors.newCachedThreadPool();
        ExecutorService ex1 = new ThreadPoolExecutor(1,
                4,1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 12; i++) {
            ex1.execute(()->{
                System.out.println(Thread.currentThread().getName()+"办理业务");
            });
        }
    }
}
