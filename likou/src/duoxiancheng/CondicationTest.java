package duoxiancheng;

public class CondicationTest {

    public static void main(String[] args) {
        // 标志位，精准通知，精准唤醒
       Res res = new Res();
       new Thread(()->{
                   for (int i = 0; i < 10; i++) {
                       res.print(5);
                   }
               },"打印5：").start();
       new Thread(()->{
                   for (int i = 0; i < 10; i++) {
                       res.print(10);
                   }
               },"打印10：").start();
       new Thread(()->{
                   for (int i = 0; i < 10; i++) {
                       res.print(15);
                   }
               },"打印15：").start();
    }
}
