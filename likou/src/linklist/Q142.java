package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q142 {
    //方法 1：哈希表
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode cur = head;
        while (cur != null){
            if(set.contains(cur)){
                return  cur;
            }else {
                set.add(cur);
                cur= cur.next;
            }
        }
        return null;

    }
    // 双指针 快慢问题
    public ListNode detectCycle01(ListNode head) {
        ListNode fast = head,slow = head;
        while(true){
            if(fast == null || fast.next ==null)return  null;
            fast = fast.next.next;
            slow= slow.next;
            if(slow == fast) break;
        }
        fast = head;
        if(fast!=slow){
            fast= fast.next;
            slow = slow.next;
        }
        return  slow;

    }
    //双指针，另一种写法
    public ListNode detectCycle02(ListNode head) {
        return  null;
    }

}
