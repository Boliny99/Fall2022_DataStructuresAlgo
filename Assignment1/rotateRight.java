public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode l1 = head;
        int n = 0;
        while (l1 != null) {
            n++;
            l1 = l1.next;
        }
        if (n == 0 || n == 1 || k == 0 ) return head;
        int m = k % n;
        if (m == 0) return head;
        int k0 = n - m;
        l1 = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (k0 > 0) {
            k0--;
            l1 = l1.next;
            dummy = dummy.next;

        }

        dummy.next = null;
        ListNode l2 = l1;
        while ( m > 1) {
            m--;
            l2 = l2.next;
        }
        l2.next = head;
        return l1;
    }
}
