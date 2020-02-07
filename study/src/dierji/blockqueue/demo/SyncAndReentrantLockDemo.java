package dierji.blockqueue.demo;

/**
 * synchronized 和 lock 有什么区别，用新的lock 有什么好处，你举例说一说
 * 1.原始构成：
 *     synchronized 是关键字 属于jvm 层面
 *     monitorenter（底层是通过monitor对象来完成，其实wait / notify 等方法也依赖于monitor 对象
 *     只有在同步块或方法中才能调用）
 *     monitorexit 正常退出 monitorexit 异常退出 两次
 *     lock 是具体类（java.util.concurrent.locks.lock） 是api 层面的锁
 * 2 使用方法
 *  synchronize 不需要用户手动释放锁，当synchronize 代码执行完后系统会自动让线程释放对锁的占用
 *  ReetrantLock 则需要用户去手动释放锁 若没有主动释放锁，就有可能导致出现死锁现象
 *  需要lock() 和unlock() 方法配合try finally 语句来完成
 *  3 等待是否可中断
 *  synchronize 不可以中断，除非抛出异常 或者正常运行完成
 *  ReetrantLock 可以中断，1 设置超时方法 trylock
 *                        2. lockInterruptibly 放代码块中，调用interrupt 方法可中断
 * 4 加锁是否公平
 *   synchronize 非公平锁
 *   ReentrantLock 两者都可以，默认是非公平锁，构造方法可以传入boolean值，true 为公平锁，false为
 *   非公平锁
 *
 *5 锁绑定多个条件 condition
 * synchronize 没有
 * ReetrantLock 用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不像synchronize 要么随机
 * 唤醒一个线程要么 唤醒全部线程
 * ==========================================================================================================================
 * ================================================================================================================
 * =============================================================================================================
 * 题目：多线程之间按顺序调用，实现A-》B——》 c 三个线启动
 * AA 打印5次  BB 打印 10次 CC 打印 15次
 * 紧接着
 *  AA 打印5次  BB 打印 10次 CC 打印 15次
 *  来10 轮
 */
public class SyncAndReentrantLockDemo {
}
