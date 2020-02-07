package duoxiancheng;
 // new 以一个对象的时候 分三步走

/**
 * 1. memory = allocate() 1.分配对象内存空间
 * 2.instance(memory) 2 初始化对象， 赋初始值
 * 3.instance = memory 3 设置 instance 指向
 *
 * 由于步骤2 和 步骤 3 不存在数据 依赖关系 ，可以进行 步骤的对调  变成3 2  此时多线程 的时候 就会出问题
 */
public class SingleDemo {
    // 禁止指令重排
    private volatile  SingleDemo instance;
    private SingleDemo(){
        System.out.println("被访问一次了");
    }
    //双端检查
    public SingleDemo getIntance(){
        if(instance == null){
            synchronized (SingleDemo.class){
                if(instance == null){
                    instance = new SingleDemo();
                }
            }
        }
        return instance;
    }
    public synchronized SingleDemo getIntance01(){
        if(instance == null){
            instance = new SingleDemo();
        }
        return instance;
    }
}
