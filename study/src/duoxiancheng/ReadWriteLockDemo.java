package duoxiancheng;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 已经有lock 了，lock 已经抢占了资源，所有的线程的都得等着，
 * 读写锁
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行，
 * 但是，
 * 如果有一个线程想去写共享资源类，就不应该再有其他线程进行对该资源类进行读或者写
 *  总结：
 *   读 - 读能共存
 *   读-写不能共存
 *   写-写不能共存
 *
 *   如果我们深入分析ReadWriteLock，会发现它有个潜在的问题：如果有线程正在读，
 *   写线程需要等待读线程释放锁后才能获取写锁，即读的过程中不允许写，这是一种悲观的读锁。
 *
 */
class MyCash{
    private  Map<String,Object> map = new HashMap<>();
    //Lock lock =  new ReentrantLock();
    ReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key,String v){
        lock.writeLock().lock();
        //lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"写入数据");
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,v);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
            //lock.unlock();
        }
    }
    public void get(String key){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"读取数据");
            TimeUnit.MILLISECONDS.sleep(300);
            Object res = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取成功"+res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }

    }
}

public class ReadWriteLockDemo{
    public static void main(String[] args) {
        MyCash cash = new MyCash();
        for (int i = 0; i < 5; i++) {
             final  int num = i;
             new Thread(()->{
                 cash.put(num+"",num+""); },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final  int num = i;
            new Thread(()->{
                cash.get(num+""); },String.valueOf(i)).start();
        }

    }
}
