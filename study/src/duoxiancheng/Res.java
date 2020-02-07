package duoxiancheng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Res {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    int num=1;
    public void print(int n)  {
        lock.lock();
        try{
            if(n == 5){
                while (num != 1){
                    condition1.await();
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(i);
                }
                num = 2;
                condition2.signal();
            }else if(n == 10){
                while (num != 2){
                    condition2.await();
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(i);
                }
                num=3;
                condition3.signal();

            }else if(n == 15){
                while (num != 3){
                    condition3.await();
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(i);
                }
                num = 1;
                condition1.signal();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
