package linklist;

public class Q92 {
    ListNode last ;
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
    ListNode reverseN(ListNode head, int n){
        if(n == 1){
            last = head.next;
            return head;
        }
        ListNode res = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = last;
        return res;
    }


}
