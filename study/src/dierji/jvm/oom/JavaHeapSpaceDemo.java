package dierji.jvm.oom;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        //java.lang.OutOfMemoryError: Java heap space
        String str = "atguigu";
        while (true){
            str += str + new Random().nextInt(1111111111)+new Random().nextInt(222222222);
            str.intern();
        }
    }
}
