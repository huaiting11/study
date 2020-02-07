package duoxiancheng;

public class TestTicket {
    public static void main(String[] args) throws InterruptedException {
        Ticket ticket = new Ticket();
        Thread t = new Thread(() -> {
            for (int i = 0; i <= 30; i++) {
                ticket.sale();
            }

            
        },"淘宝");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i <= 30 ; i++) {
                ticket.sale();
            }
        },"窗口");
        t2.start();
        t.start(); // 启动新线程

        t2.join();
        t.join();
        System.out.println(ticket.ticket);
    }
}
// 线程是线程，资源类是资源类，线程操作资源类。
