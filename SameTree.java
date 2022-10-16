public class SameTree {
    public boolean SameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null) {
            if (p.val = q.val) {
                TreeNode pleft = p.left;
                TreeNode pright = p.right;
                TreeNode qleft = q.left;
                TreeNode qright = q.right;
                return SameTree(pleft,qleft) && SameTree(pright,qright);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
