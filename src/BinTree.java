public class BinTree <T> {
    public Node<T> root;

    public BinTree() {

    }

    public void populateNextLeft(Node root){
        if (root == null) return;
        Node left = root.left;
        Node right = root.right;
        right.nextLeft = left;
        if (right.left != null) {
            right.left.nextLeft = right.nextLeft.right;
        }
        populateNextLeft(right);
        populateNextLeft(left);

    }
}
