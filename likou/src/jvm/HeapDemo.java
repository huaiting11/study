package jvm;

import java.util.Random;

/**
 * -Xms 设置初始分配大小，默认为物理内存的 1/ 64
 * -Xmx 最大分配内存，默认为物理内训的 1/4 2 g
 *  生产环境 一般把这两者 设置成一样大， 避免忽高忽低
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx:Max_Memory ="
                + maxMemory+"(字节)"+ (maxMemory/(double)1024/1024)+"MB");
        System.out.println("-Xms:totalMemory ="
                + totalMemory+"(字节)"+ (totalMemory/(double)1024/1024)+"MB");
        String str ="宝贝哥哥";
        while (true) {
            str += "str"+new Random().nextInt(888888888)+new
                    Random().nextInt(999999999);
        }
        //byte[] bytes = new byte[40 * 1024 * 1024];
    }
}
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
/** gc 工作了
 * [GC (Allocation Failure)  内存分配失败
 *    gc类型   内存占用
 * [PSYoungGen: 512K->504K(1024K)] 512K->512K(1536K), 0.0006524 secs]
 * [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure)
 * [PSYoungGen: 1016K->504K(1024K)] 1024K->620K(1536K), 0.0009458 secs]
 * [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure)
 * [PSYoungGen: 1015K->504K(1024K)] 1131K->676K(1536K), 0.0008713 secs]
 * [Times: user=0.00 sys=0.00
 *
 * [Full GC (Ergonomics) [PSYoungGen: 1005K->285K(1024K)]
 * [ParOldGen: 508K->405K(512K)] 1513K->690K(1536K),
 * [Metaspace: 3313K->3313K(1056768K)], 0.0045927 secs]
 * [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 796K->273K(1024K)]
 * [ParOldGen: 405K->416K(512K)] 1202K->
 **/