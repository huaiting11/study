package stackqueue;
//循环双端队列
//能够从前面添加元素，从后面添加元素
public class Q641_2 {
    private int front;
    private int rear;
    private int capacity;
    private int[] arr;
    public Q641_2(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }
    public boolean insertFront(int value) {
        if(isFull()){
            return  false;
        }
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;

    }
    public boolean insertLast(int value) {
        if(isFull()){
            return  false;
        }
        arr[rear] = value;
        rear = (rear +1 ) % capacity;
        return true;
    }
    public boolean deleteFront() {
        if(isEmpty()){
            return  false;
        }
        front = (front + 1) % capacity;
        return  true;
    }
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = (rear -1 + capacity) % capacity;
        return true;
    }
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(rear -1 + capacity) % capacity];
    }
    boolean isFull(){
        return  (rear+1) % capacity== front;
    }
    boolean isEmpty(){
        return  rear == front;
    }
}

