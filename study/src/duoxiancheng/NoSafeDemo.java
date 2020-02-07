package duoxiancheng;

/**
 * 请举例说 集合 线程不安全
 * 1. 故障现象
 * ConcurrentModificationException
 * 2.导致原因
 * 为什么ArrayList 出错
 * 并发修改异常 同时满足  dir。
 *
 *
 * 3.解决方案
 * 3.1 Vector
 * 3.2 Collections.synchronizedList(new ArrayList<></>)
 * 3.3 CopyOnWriteArrayList
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/***
 * HashSet 底层是HashMap
 */
public class NoSafeDemo {
    public static void main(String[] args) {
        Map<String,String> map =  new ConcurrentHashMap();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,8),"ssss");
                System.out.println(map);
                    },String.valueOf(i));
        }
    }
    public void listNoSafe(){
        List<String> list1= new Vector<>();
        list1.get(0);
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },"ss").start();
        }
    }
    public void setNoSafe(){
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

}
/**
 * public boolean add(E e) {
 *         final ReentrantLock lock = this.lock;
 *         lock.lock();
 *         try {
 *             Object[] elements = getArray();
 *             int len = elements.length;
 *             Object[] newElements = Arrays.copyOf(elements, len + 1);
 *             newElements[len] = e;
 *             setArray(newElements);
 *             return true;
 *         } finally {
 *             lock.unlock();
 *         }
 *     }
 *     写时复制
 *     CopyOnWrite 容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object【】
 *     添加，而是先将当前Object[] 进行copy， 复制一个新的容器Object[] newElements ，然后
 *     在新的容器Object[] newElements里添加元素，添加完元素之后，再将原来的容器的引用，指向新的容器
 *     这样做的好处是可以对CopyOnWrite 容器进行并发的读，而不需要加锁，因为当前容器不会添加
 *     任何元素，所以CopyOnWrite 容器也是读写分离的思想，读和写 不同的容器。
 *
 *
 *
 *
 *
 *
 */
