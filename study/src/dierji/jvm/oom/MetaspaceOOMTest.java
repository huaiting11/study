package dierji.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM参数
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 * Java 8之后的版本使用Metaspace来替代永久代
 * Metaspace 是方法区在HotSpot 中的实现，它与永久代最大的区别在于：
 * Metaspace 并不在虚拟机内存中而是使用本地内存
 * 也即在java8中，classe metadata，被存储在叫做Metaspce 的natice memory
 *
 *  永久代（Metaspace） 存放以下信息：
 *    虚拟机加载的类信息
 *    常量池
 *    静态变量
 *    即时编译后的代码
 */
public class MetaspaceOOMTest {
    public static void main(String[] args) {
        // -XX:PermSize=10m -XX:MaxPermSize=10m
        List<String> list = new ArrayList<>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
