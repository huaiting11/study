package linklist;
public class MyLinkedList {
    ListNode head = null;
    public void addNode(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    public ListNode getHead(){
        return this.head;
    }
    public ListNode reverseList02() {
        ListNode prev = null;
        ListNode cur = this.head;
        while (cur.next != null){
            ListNode nextTemp = cur.next;
            cur.next =prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;

    }
    public void print(){
        ListNode cur = this.head;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
