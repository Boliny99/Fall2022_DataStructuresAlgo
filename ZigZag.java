public class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        Boolean leftToRight = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            leftToRight = !leftToRight;
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                TreeNode node  = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (leftToRight) {
                    level.add(node.val);
                } else if (!leftToRight) {
                    level.add(0,node.val);
                }
            }
            res.add(level);
        }
        return res;

    }
}