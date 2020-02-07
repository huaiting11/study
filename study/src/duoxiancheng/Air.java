package duoxiancheng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Air {
    public int temperature;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public  void dec()  {
        lock.lock();
        try{
            // 判断  等待的条件，注意要用 while ，不然会产生虚假唤醒，因为 if语句，会直接 执行从等待的代码 往下执行，就
            // 执行了干活的代码，导致程序多加一， 所以用while 重新检查，
            while (temperature == 0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+temperature);
            temperature--;
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void inc(){
        lock.lock();
        try {
            while(temperature != 0 ){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+temperature);
            temperature++;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    /*public synchronized void dec() throws InterruptedException {
        while (temperature == 0){
            this.wait();
        }

        this.temperature--;
        System.out.println(Thread.currentThread().getName()+temperature);
        this.notifyAll();

    }
    public synchronized void inc() throws InterruptedException {
        if(temperature != 0){
            this.wait();
        }
        this.temperature++;
        System.out.println(Thread.currentThread().getName()+temperature);
        this.notifyAll();
    }
*/
}
