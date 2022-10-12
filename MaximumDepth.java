public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            return 1 + Math.max(maxDepth(left), maxDepth(right));
        }

    }
}
