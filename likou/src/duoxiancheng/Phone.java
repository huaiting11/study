package duoxiancheng;

import java.util.concurrent.TimeUnit;

public class Phone {
    public synchronized void sendEmail(){
        TimeUnit t = TimeUnit.SECONDS;
        try {
            t.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }
    public static synchronized void sendMsg(){
        System.out.println("sendMsg");
    }
    public void hello(){
        System.out.println("hello");
    }
}
