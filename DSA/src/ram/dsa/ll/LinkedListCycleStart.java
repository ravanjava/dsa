package ram.dsa.ll;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(null!=fast && null!=fast.next){

            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)
                break;
        }

        System.out.println("slow: "+slow.value);
        ListNode point1 = head;
        ListNode point2 = slow;

        while(null!=point1){

            point1 = point1.next;
            point2 = point2.next;

            if(point1==point2)
                return point1;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        head.next.next.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    }
}
