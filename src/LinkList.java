public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void insert(Integer data,Node head){
        // Insert in sorted manner

        Node dummy = new Node(0);
        dummy.next = head;
        if (head == null) {
            dummy.next = new Node(data);
        }
        Node h1 = dummy;
        Node h2 = head;
        while (h1 != null && h2 != null) {
            if (h1.data < data && data < h2.data) {
                Node node = new Node(data);
                h1.next = node;
                node.next = h2;
                return;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        if (h2 == null && h1 != null) {
            h1.next = new Node(data);
            return;
        }


    }
}
