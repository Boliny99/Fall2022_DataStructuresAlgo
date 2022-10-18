public class FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> v = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        while (!v.contains(root)) {         // search by round
            List<Integer> leaves = new ArrayList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null ||
                        v.contains(node.left) && v.contains(node.right) ||
                        node.left == null && v.contains(node.right) ||
                        node.right == null && v.contains(node.left)) {

                    leaves.add(node.val);
                    v.add(node);

                }
                if (node.right != null && !v.contains(node.right))
                    q.offer(node.right);
                if (node.left != null && !v.contains(node.left))
                    q.offer(node.left);
            }
            res.add(leaves);
        }

        return res;
    }
}


