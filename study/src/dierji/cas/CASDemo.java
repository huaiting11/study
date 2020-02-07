package dierji.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**cas 是什么，= compareAndSet
 * 比较并交换
 * private volatile int value;
 * Unsafe
 * 是CAS 的核心类，由于Java 方法无法直接访问底层系统。需要通过本地（native） 方法来访问，Unsafe 相当于一个后门
 * 基于该类可以直接操作特定内存的数据。Unsafe 类存在于sun.misc 包中，其内部方法操作可以像c 的指针一样直接操作
 * 内存，因为java cas 操作的执行 依赖于Unsafe 类的方法
 * 注意：Unsafe 类中所有的方法都是native 修饰的，也就是说Unsafe 类中的方法都是直接调用操作系统底层资源执行相应任务
 * 2.变量valueOffset 表示该变量值在内存中的编译地址，因为Unsafe 就是根据内存偏移地址获取数据的。
 * 3变量value 用volatile 修饰，保证了多线程之间的内存可见性。
 * public final int getAndIncrement（）{
 *     return unsafe.getAndAddInt();
 * }
 */

/**
 * CAS 的底层原理
 * CAS 的全称 为 Compare-And-Swap，它是一条cpu 并发原语
 *
 * 它的功能是判断内存某个位置的值是否为预期值，如果是则更改为新的值，这个过程是原子的。
 *
 * CAS 并发原语体现在JAVA语言中就是sun.misc.Unsafe 类中的各个方法。
 * 并且原始的执行必须是连续的，在执行过程中不允许被打断，cas 是一条cpu 的原子指令，不会造成所谓的数据不一致问题
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger as = new AtomicInteger(5);
        // mian do thing
        System.out.println(as.compareAndSet(5,7));
        System.out.println(as.get());
        System.out.println(as.compareAndSet(5,13));
        System.out.println(as.get());
        as.getAndIncrement();
    }
}
/**
 * 1.假设线程a 和 线程b 同时调用getAndAddInt 方法 （分别跑在不同cpu上）
 * 2.线程a 获得 主内存
 *
 * Unsafe
 *
 * synic 保证一致性，并发性下降
 *
 * 循环时间长，开销大。
 * 只能对一个共享变量的原子操作
 * 引出来ABA 问题
 */
/**
 * 原子类AtomicInteger 的ABA 问题 谈谈，原子更新引用知道吗？
 * CAS -- Unsafe - CAS 底层思想 -  ABA - 原子引用更新 - 如何规避ABA问题
 * ABA :狸猫换太子
 * 改过一次 又改回来  ABBBA
 */
