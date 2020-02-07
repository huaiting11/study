package duoxiancheng;

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        Air air = new Air();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.inc();
            }
        },"婷婷");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.inc();
            }
        },"老包");
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.dec();
            }
        },"婷婷听");
        Thread t4= new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.dec();
            }
        },"婷婷特");
        t1.start();
        t3.start();
        t4.start();
        t2.start();

    }
}
