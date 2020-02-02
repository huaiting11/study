package duoxiancheng;

import java.util.concurrent.TimeUnit;

/**
 * 8 锁
 * 普通同步方法， 锁 this 只能有一个线程进来 访问同步方法
 * 静态同步方法   Lock8.class
 *
 * 1.标准访问，请问先打印发邮件，还是发短信  邮件短信
 * 2.发邮件停 4 秒钟，请问先打印发邮件，还是短信  邮件短信
 * 3.新添加一个hello方法，请问是先打印发邮件，还是hello hello 邮件
 * 4.两部手机，请问先打印发邮件，还是短信  短信邮件
 * 5.两个静态同步方法，同一部手机，请问是先发邮件，还是先发短信   邮件短信
 * 6.两个静态同步方法，两部手机，请问是 先发邮件，还是先发短信   邮件短信
 * 7.一个普通同步方法，一个静态同步方法，同一部，请问是先发邮件，还是先发短信。 短信邮件
 * 8.一个普通同步方法，一个静态同步方法，两部，请问是先发邮件，还是先发短信    短信邮件
 * 3.
 */
public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        Thread t1 = new Thread(()->{
                    phone.sendEmail();
                },"我们");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(()->{
                   // phone.sendMsg();
                   phone.hello();
                   phone2.sendMsg();
                },"他们");
        t2.start();
    }
}
