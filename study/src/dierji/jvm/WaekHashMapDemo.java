package dierji.jvm;

import jvm.HeapDemo;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WaekHashMapDemo {
    public static void main(String[] args) {
        myHashmap();
        System.out.println("================================");
        myWeakHashmap();
    }
    public static void myWeakHashmap(){
        WeakHashMap<Integer,String> hashMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        hashMap.put(key,"1");
        System.out.println(hashMap);
        key = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);
        System.out.println(hashMap.size());
    }
    public static void myHashmap(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        Integer key = new Integer(1);
        hashMap.put(key,"1");
        System.out.println(hashMap);
        key = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);
        System.out.println(hashMap.size());
    }

}
