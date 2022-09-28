public class swapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode l1 = head;
        int n = 0,temp = 0;
        while (l1 != null) {
            n++;
            if (n == k) {
                temp = l1.val;
            }
            l1 = l1.next;
        }
        int m = n - k;
        l1 = head;
        while (m > 0) {
            l1 = l1.next;
            m--;
        }
        int t2 = l1.val;
        l1.val = temp;
        l1 = head;
        while (k > 1) {
            l1 = l1.next;
            k--;
        }
        l1.val = t2;
        return head;

    }

}
