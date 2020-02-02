package stackqueue;

/**
 *循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，
 * 即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 *

 */
public class Q622 {
    private int front;
    private int rear;
    private int capacity;
    private int[] arr;
    public Q622(int k) {
        capacity= k+1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        //插入元素的时候，先赋值，后索引 +1（注意取模）
    }
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        arr[rear] = value;
        rear = (rear+1 ) % capacity;
        return  true;
    }
    public boolean isEmpty(){
        return  front == rear;
    }
    private boolean isFull(){
        return (rear+1) % capacity == front;
    }
    public boolean deQueue(){
        if(isEmpty()) return  false;
        front = (front+1) % capacity;
        return  false;
    }
    int Front() {
        if(isEmpty()){
            return  -1;
        }
        return arr[front];
    }
    int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }
}
