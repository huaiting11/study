package stackqueue;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class Q155 {

}

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> data ;
    Stack<Integer> help;
    public MinStack() {
        data =new Stack<>();
        help = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(help.isEmpty() || x<= help.peek()){
            help.add(x);
        }else{
            help.add(help.peek());
        }

    }

    public void pop() {
        if(!data.isEmpty()){
            data.pop();
            help.pop();
        }

    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");

    }

    public int getMin() {
        if(!help.isEmpty()){
            return help.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");

    }
    //方法一：辅助栈和数据栈同步
    //出栈时，最小值出栈才同步；入栈时，最小值入栈才同步。
    //方法二：辅助栈和数据栈不同步
}
//方法二：辅助栈和数据栈不同步

class MinStack02 {

    /** initialize your data structure here. */
    Stack<Integer> data ;
    Stack<Integer> help;
    public MinStack02() {
        data =new Stack<>();
        help = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        //这里“等于”要考虑进去，因为出栈的时候，连续的、相等的并且是最小值的元素要同步出栈；
        if(help.isEmpty() || x < help.peek()){
            help.add(x);
        }

    }

    public void pop() {
        if(!data.isEmpty()){
            int top = data.pop();
            if(top == help.peek()){
                help.pop();
            }
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!help.isEmpty()){
            return help.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

}

