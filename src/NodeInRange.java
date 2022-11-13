import java.util.ArrayList;

public class NodeInRange {
    public static List<Integer> NodeInRange(Node root, int[2] range) {
        List<Integer> res = new ArrayList<>();
        int min = range[0];
        int max = range[1];
        if (root == null) return res;
        if (root.val >= min && root.val <= max) {
            res.add(root.val);
        }
        List<Integer> l1 = NodeInRange(root.left);
        List<Integer> l2 = NodeInRange(root.right);
        res.add(l1);
        res.add(l2);
        return res;


    }
}
