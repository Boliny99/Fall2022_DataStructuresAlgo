public class LevelOrderTraversal {
    public List<List<Integer>> LevelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0;i < size;i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
                level.add(node.val);
            }
            res.add(level);
        }
        return res;
    }
}