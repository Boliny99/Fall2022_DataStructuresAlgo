public class Main {


    public static void main(String[] args) {
        Node<Integer> node1 = getNode1();
        Node<Integer> node2 = getNode2();
        Node<Integer> sorted = mergeSortedNodes(node1,node2);
        System.out.println(sorted);
    }

    public static Node<Integer> getNode1() {
        Node<Integer> node = new Node<>(1);
        node.next = new Node<>(3);
        node.next.next = new Node<>(7);
        node.next.next = new Node<>(7);
        node.next.next.next = new Node<>(8);
        return node;
    }

    public static Node<Integer> getNode2() {
        Node<Integer> node = new Node<>(2);
        node.next = new Node<>(3);
        node.next.next = new Node<>(4);
        node.next.next = new Node<>(6);
        node.next.next.next = new Node<>(8);
        return node;
    }

    private static Node<Integer> mergeSortedNodes(Node<Integer> node1, Node<Integer> node2) {
        Node<Integer> res = new Node<>(null);
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.data < node2.data) {
            res = node1;
            res.next = mergeSortedNodes(node1.next, node2);
        } else {
            res = node2;
            res.next = mergeSortedNodes(node1,node2.next);
        }
        return res;
    }
}