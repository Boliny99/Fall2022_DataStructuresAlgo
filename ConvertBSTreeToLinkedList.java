public class ConvertBSTreeToLinkedList {
    Node first = null;
    Node last = null;

    public void helper(Node node) {
        if (node != null) {
            // left
            helper(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            }
            else {
                first = node;
            }
            last = node;
            helper(node.right);
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }
}