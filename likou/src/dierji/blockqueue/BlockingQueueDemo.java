package dierji.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue: 是一个基于数组结构的有界阻塞队列，此队列按照FIFO 原则对元素进行排序
 * LinkBlockingQueue: 是一个基于链表阻塞队列，此队列按照FIFO 原则对元素进行排序
 *
 *
 *
 * 1 队列
 * 2 阻塞队列
 *  2.1 阻塞队列有没有好的一面
 *  2.2 不得不阻塞，你如何管理
 *
 *  阻塞队列的思想：
 *  1.当阻塞队列是空时，从队列获取元素的操作将会被阻塞
 *  2 当阻塞队列是满时，往队列添加元素的操作将会被阻塞
 *  试图从空的阻塞队列中获取元素的线程将会被阻塞
 *  知道其他的线程往空的队列插入新的元素
 *  同样
 *  试图往已满的阻塞队列中添加新元素的线程同样也会被阻塞
 *  直到其他线程从列中移除一个或者多个元素或者完全清空
 *  队列后重新变得空闲起来并后续新增
 *
 *  在多线程领域：所谓阻塞，在某些情况下回挂起线程（即阻塞）
 *  一旦条件满足，被挂起的线程又会被自动唤醒
 *  为什么需要BlockingQueue
 *  好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，因为这一切
 *  BlokingQueue 都给你包办了
 *  在concurrent 包发布以前，在多线程环境下，我们每个程序员都必须自己控制
 *  这些细节，尤其还有兼顾效率和线程安全，这会给我们的程序带来不小的复杂度
 *
 * 阻塞队列接口 BlockingQueue
 *
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        /**
         * 当阻塞队列满时，生产者线程继续往队列里面put 元素，队列会一直阻塞生产线程，知道put 数据
         *
         */
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        try {
            blockingQueue.put("q");
            blockingQueue.put("q");
            blockingQueue.put("q");
            //blockingQueue.put("q");
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
            /**
             * 超时 过时不候
             */
            blockingQueue.offer("1",2L, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

    private static void blockDemoTest() {
        //List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        /**抛出异常*/
        blockingQueue.add("b");
        blockingQueue.add("d");
        blockingQueue.add("c");
        // blockingQueue.add("y");
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        //blockingQueue.remove("b"); // 定点清除
        // blockingQueue.remove();
        // blockingQueue.element();  // 查看队首元素
        /**特殊值
         * 插入方法，成功true 失败false 移除方法，成功返回出队列的元素，队列里面没有就返回null
         * **/
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d");
        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.peek(); // 查看队首 元素
    }
}
