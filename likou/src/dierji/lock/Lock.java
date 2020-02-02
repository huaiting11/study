package dierji.lock;

/**
 * 独占锁： 指该锁 一次只能被 一个线程 所持有
 * 对 ReetrantLock 和 Synchronized 而言 都是独占锁
 *
 * 共享锁： 指该锁可以被多个线程所持有
 * 对ReentrantReadWriteLock 其读锁 是共享锁，其写锁 是独占
 * 锁。
 * 读锁的共享锁 可保证并发 读 是非常高效的，读写，写读，写写
 * 的过程是互斥的。
 */
/*
  多个线程同时 读一个资源类 没有任何 问题 ，所以为了满足并发量，读取共享资源应该可以同时进行
  但是，
  如果有一个线程想去写 共享 资源来，就不应该 再有其他线程 可以对该资源进行读或者写
  小总结：
    读读 能共存
    读写 不能共存
    写写 不能共存
 */
public class Lock {
    public static void main(String[] args) {

    }


}
