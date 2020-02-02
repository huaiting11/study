package duoxiancheng;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 * 在多线程领域：所谓阻塞，在某些情况会挂起线程（）; 一旦条件满足
 */

/**
 * 阻塞队列
 * 拥堵不好
 * Interface BlockingQueue
 * 当队列是空的，从队列中获取元素的操作将会被阻塞
 * 当队列是满的，从对列中添加元素的操作将会被阻塞
 */
class Cake{
    public Queue<String> queue = new LinkedList<>();

}
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
    }




}
