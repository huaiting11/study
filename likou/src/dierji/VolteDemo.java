package dierji;

import java.util.concurrent.atomic.AtomicInteger;

class Tic{
    int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addNum(){
        num = 40;
    }
    public void s(){
        atomicInteger.getAndIncrement();
    }
}
/**
 * 线程安全是如何保证的呢
 * 工作内存和主内存同步延迟现象导致的可见性问题
 * 可以使用synchronized 或者 volatile 关键字解决，它们都可以使一个线程修改
 * 后的变量对其他线程可见
 *
 * 对于指令重排导致的可见性问题和有序性问题
 * 可以利用volatile 关键字解决，因为volatile 的另外一个作用就是禁止重排序优化
 */
/**
 * jmm 内存模型
 * 可见性
 * 原子性
 * volatile 代码 演示
 * 有序性
 * 这几个点是保证线程安全获得保证的基础
 *
 * 有序性
 * 计算机在执行程序时，为了提高性能，编译器和处理器常常会对指令做重排，一般分为以下三种
 * 源代码-》编译器优化的重拍-》指令并行的重拍-》内存系统的重排-》 最终执行的指令
 * 单线程环境里面确保程序最终执行结果和代码顺序执行的结果一致
 *
 * 处理器在进行重新排序时必须要考虑 指令之间的数据依懒性
 *
 * 多线程环境中线程交替执行，由于编译器优化重排的存在，两个线程中使用的变量能否保证一致性是
 * 无法确定的，结果无法预测
 *
 */

/**
 * 1.验证volatile 的可见性
 * 1.1 假如int num = 0，num 变量之前根本没有添加volatile 关键字修饰，没有可见性
 * 1.2 添加了 volatile ，可以解决可见性 问题
 *
 * 2 验证volatile 不保证原子性
 * 2.1 原子性指的是什么意思
 * 不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者分割，需要同时成功，要么
 * 同时失败 i++ 虽然是一条指令 但是其实是三个步骤
 *
 * 2.2 volatile 不保证原子性的案例演示
 * 2.3 why
 * 2,4 如果解决原子性
 * 加sync
 * 使用我们juc 下的atomicInteger
 */
class Res{
    int a = 0;
    boolean flage = false;
    public void me(){
        a = 1;  // 语句1
        flage = true; // 语句2-
        //语句1 和语句2 可以交替执行
    }
    //多线程环境中线程交替执行，由于编译器优化重排的存在，两个线程中使用的变量能否保证一致性是
    // * 无法确定的，结果无法预测
    public void me2(){
        if(flage){
            a = a + 5;
            System.out.println("res"+ a);
        }
    }
}
public class VolteDemo {
    public static void main(String[] args) throws InterruptedException {
        Tic tic = new Tic();
        for (int i = 0; i < 20; i++) {
             new Thread(()->{
                 for (int j = 0; j  < 1000; j++) {
                     tic.s();
                 }
                             }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2){

        }
        System.out.println(tic.atomicInteger);
    }
}
