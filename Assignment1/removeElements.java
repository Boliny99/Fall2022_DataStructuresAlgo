public class removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        else {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            while(prev.next != null ) {
                if (prev.next.val == val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return dummy.next;
        }

    }
}
