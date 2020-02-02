package linklist;
/**
 * 链表翻转
 */

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 */
public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if(b == null){
                return  head;
            }
            b = b.next;
        }
        ListNode newNode = res(a,b);
        a.next = reverseKGroup(b.next,k);
        return newNode;

    }
    ListNode res(ListNode a, ListNode b){
        ListNode pre = null, cur = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}
