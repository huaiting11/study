package dierji.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *  GC 回收时间过长会抛出OutOfMemroyError 。过长的定义是，超过98%的时间用来做GC并且回收
 *  了不到2%的堆内存，连续多次GC 都只回收了不到2%的极端情况下才会抛出，假如不抛出
 *  GC overhead limit 错误会发生什么情况呢？ CPU 使用一直是100%，而GC 却没有任何成果
 *   java.lang.OutOfMemoryError: GC overhead limit exceeded
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i =  0;
        List<String>  list = new ArrayList<>();
        while (true){
            list.add(String.valueOf(++i).intern());
        }
    }
}
