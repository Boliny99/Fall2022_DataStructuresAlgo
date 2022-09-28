public class splitListToParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode l1 = head;
        int n = 0;
        while (l1 != null) {
            l1 = l1.next;
            n++;
        }
        ListNode[] res = new ListNode[k];
        if (n <= k) {
            if (n == 0) {
                for (int i = 0;i < n;i++) {
                    res[i] = null;
                }
            } else {
                l1 = head;
                for (int i = 0;i < n;i++){
                    res[i] = new ListNode(l1.val);
                    l1 = l1.next;
                }
                for (int i = n;i < k;i++){
                    res[i] = null;
                }
            }
        } else {
            int p = n/k;
            int q = n % k;
            l1 = head;
            for (int i = 0;i < q;i++) {
                ListNode dummy = new ListNode(0);
                ListNode write = dummy;
                for (int j = 0;j < p+1;j++) {
                    write = write.next = new ListNode(l1.val);
                    if (l1 != null) l1 = l1.next;
                }
                res[i] = dummy.next;
            }
            for (int i = q;i < k;i++) {
                ListNode dummy = new ListNode(0);
                ListNode write = dummy;
                for (int j = 0;j < p;j++) {
                    write = write.next = new ListNode(l1.val);
                    if (l1 != null) l1 = l1.next;
                }
                res[i] = dummy.next;
            }

        }



        return res;

    }
}
