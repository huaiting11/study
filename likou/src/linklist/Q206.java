package linklist;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class Q206 {
    //并且根据函数定义，reverse 函数会返回反转之后的头结点，我们用变量 last 接收了。
    //方法一：递归
    public ListNode reverse(ListNode head) {
        if(head == null) return head;
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    //方法一：迭代
    public ListNode reverseList02(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur.next != null){
            ListNode nextTemp = cur.next;
            cur.next =prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;

    }

}

