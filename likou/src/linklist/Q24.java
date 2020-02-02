package linklist;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */

/**
 * 递归写法要观察本级递归的解决过程，形成抽象模型，因为递归本质就是不断重复相同的事情，而不是去思考完整
 * 的调用栈，一级又一级，无从下手。如图所示，我们应该关注一级调用小单元的情况，就是单个f（x）
 */
public class Q24 {
    //递归解法
    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next==null)return head ;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return head;
    }
    //非递归解法

}

