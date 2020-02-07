package dierji.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 *
 * jvm 垃圾回收的时候如何确定垃圾，是否知道什么是GC Root
 *
 * 1. 什么是垃圾
 * 简单来说 就是没有任何变量引用的实例就是垃圾
 * 2.要进行垃圾回收，如何确定是垃圾
 *  2.1引用计数法
 *     难以解决对象之间相互循环引用的问题，所以jvm 不适用这个方法
 *  2.2可达性分析算法 枚举根节点做可达性分析（根搜索路劲）
 * 为了解决引用计数法的循环引用问题，java使用了可达性分析的方法
 *    1)所谓GC root 或者 tracing GC 的 根  集合，就是一组必须活跃的引用
 * 基本思路：就是通过一系列名为GC root 的对象作为起点，也就是说给定一个集合的引用作为根出发，通
 * 通过引用关系遍历对象图，能被遍历到的（可达性的） 对象就被判定为存活;没有被遍历到的就自然判定死亡
 *   2)哪些对象可以作为GCRoot
 * 1.虚拟机栈（栈帧中的局部变量区，也叫做局部变脸表）中的引用对象
 * 2 方法区中的类静态属性引用的对象
 * 3 方法区中常量引用的对象
 * 4 本地方法栈中JNI(一般说的native 方法)引用的对象
 *
 * 你说你做过jvm 调优和参数配置，请问如何盘点查看jvm 系统默认值
    1. jvm 参数类型
      1.1 标配参数   -version -help java -showversion
      1.2 X参数      -Xint 解释执行  -Xcomp 第一次适用就编译成本地代码  -Xmixed 混合模式
      1.3xx 参数
         Boolean 类型
            公式： -XX:+ 或者 - 某个属性值   -XX:-PrintGCDetails
                + 表示 开启 - 表示关闭
            case ： 是否打印GC 收集细节 1） -XX:-PrintGCDetails 2) -XX:+PrintGCDetails
                   是否使用串行垃圾回收器：
        kV 设置类型：
         公式： -XX:属性key=属性值value
         case ：-XX:MetaspaceSize=128m
               -XX:MaxTenuringThreshold=15
     jinfo 举例，如何查看当前运行程序的配置：
      如何查看一个正在运行中的java 程序，它的某个jvm 参数是否开启，具体值是多少
      jps -l 查看进行进程编号
      jinfo -flag 配置项 进程编号
      jinfo -flag PrintGCDetails 7328
      jinfo -flags

     坑题: 两个经典参数：-Xms 和 -Xmx
           这个你如何解释：  -Xms  等价于 -XX:InitialHeapSize  -Xmx 等价于：-XX:MaxHeapSize
     -XX:+PrintGCDetails -Xmx3550m -Xms3550m


   2.如何盘底家底
     2.1
      jps
      jinfo -flag 具体参数  java进程编号
      jnfo -flags
     2.2
      java -XX:+PrintFlagsInitial  主要才查看官方默认
      java -XX:+printFlagsFinal  主要查看修改
     有冒号： 是修改参数
 你使用哪些jvm 参数有哪些
 -Xms  初始堆内存大小，默认为物理内存的 1/64  等价于-XX:InitialHeapSize
 -Xmx  最大分配内存，默认为物理内存的1/4   等价于-XX:MaxHeapSize
 -Xss  设置单个线程栈的大小 一般默认为512K - 1024K  等价于 -XX:ThreadStackSize
 -Xmn  设置年轻代大小
 -XX:MetaspaceSize 设置元空间
 -XX:+PrintGCDetails
 -XX:SurvivorRatio 设置新生代中 eden 和 S0/S1空间的比例
       默认：-XX:SurvivorRatio=8,Eden:S0:S1=8:1:1
       假如: -XX:SurvivorRatio= 4 ,Eden:S0:S1=4:1:1
 -XX:NewRatio    配置年轻代与老年代咋堆结构的占比
      默认：-XX:newRatio=2 新生代占1,老年代2 ，老年代占整个堆的1/3
     newRatio 值就是设置老年代的占比，剩下的1 给新生代
 -XX:MaxTenuringThreshold:设置垃圾最大年龄
  强引用 软引用 弱引用 虚引用分别是什么
        java.lang.ref.Reference
 SoftReference,WeakReference,PhantomReference
 当内存不足，JVM 开始垃圾回收，对于强引用的对象，就算是出现OOM 也不会对该对象进行回收，

 强引用是我们最常见的普通对象引用，只要还有强引用指向一个对象，就能表明对象还活着，垃圾
 收集器不会碰这种对象，在java中最常见的及时强引用，把一个对象赋给一个引用变量
 这个引用变量就是一个强引用，当一个对象被强引用变量引用时，它处于可达转太，
 它是不能被垃圾收集机制回收的，即使该对象以后永远都不会被用到jVM也不会回收
 ，因此强引用时造成java内存泄漏的主要原因之一
 对于一个普通的对象，如果没有其他的引用关系，只要超过了引用的作用域或者

 软引用 gc 垃圾回收机制运行 内存够 不回收，内存不够 回收
 弱引用： gc 垃圾回收机制运行， 不关内存够不够 都要回收
  WeakHashMap

 软引用和弱引用的场景：
   假如有一个应用需要读取大量的本地图片
     如果每次读取图片都从硬盘读取则会严重影响性能
     如果一次性全部加载到内存中又有可能造成内存溢出
 此时使用软引用可以解决这个问题
   设计思路，用一个HashMap 来保存图片的路径和相应图片对象关联的软引用之前的映射关系，在内存不足时，
   jvm 会自动回收这些缓存图片对象所占用的空间，从而有效地避免了OOM 的问题
   MAP<String,SoftReference<>> re = new HashMap<>();
 虚拟引用：
   顾名思义：就是形同虚设，与其他几种引用都不同，虚引用并不会决定对象的生命周期
    如果对一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收，它不能单独使用
 也不能通过它访问对象，虚引用必须和引用队列ReferenceQueue 联合使用
   java 技术 允许使用finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作
 */
public class JvmDemo {
    public static void main(String[] args) throws InterruptedException {

        //soft();
        //soft_not();
        weakEn();
        weakNotEn();
    }
    // 内存够用
    public static void soft(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference);
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());

    }
    /**
     * JVM 配置，故意产生大对象并配置小的内存，让它内存不够用OOM 看
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    // 内存不够用

    public static void soft_not(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference);
        o1 = null;
        try {
            byte[] i = new byte[30*1024*1024];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }
    public static void weakEn(){
        Object o1 = new Object();
        WeakReference<Object> softReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference);
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());

    }
    public static void weakNotEn(){
        Object o1 = new Object();
        WeakReference<Object> softReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference);
        o1 = null;
        try {
            byte[] i = new byte[30*1024*1024];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }
}
