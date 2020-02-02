package linklist;

public class Test {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        ListNode listNode = myLinkedList.getHead();
        System.out.println(listNode);

    }
}
