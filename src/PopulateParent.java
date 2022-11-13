import java.util.ArrayList;
import java.util.List;

public class PopulateParent {

    public List<Node> PopulateParent(Node root) {
        List<Node> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Node left = root.left;
        Node right = root.right;
        List<Node> res_left = PopulateParent(left);
        List<Node> res_right = PopulateParent(right);
        res.addAll(res_left);
        res.add(null);
        res.addAll(res_right);
        return res;
    }
}
