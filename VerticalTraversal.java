public class VerticalTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        if (root == null) return res;
        Pair<TreeNode,Integer> pair = new Pair<>(root,0);
        queue.offer(pair);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                Pair<TreeNode, Integer> p = queue.poll();
                TreeNode node = p.getKey();
                Integer n = p.getValue();
                if (node.left != null) queue.offer(new Pair<>(node.left, n-1));
                if (node.right != null) queue.offer(new Pair<>(node.right, n+1));
                List<Integer> list = map.getOrDefault(n,new ArrayList<>());
                list.add(node.val);
                map.put(n, list);
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int k : keys) {
            List<Integer> li = map.get(k);
            res.add(li);
        }

        return res;

    }



}