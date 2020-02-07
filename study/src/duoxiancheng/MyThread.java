package duoxiancheng;

import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("dddd");
        return "1212";
    }
}
