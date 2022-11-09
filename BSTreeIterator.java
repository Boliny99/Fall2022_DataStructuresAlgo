public class BSTreeIterator {

    ArrayList<Integer> nodeSorted;
    int index;

    public BSTIterator(TreeNode root) {

        this.nodeSorted = new ArrayList<Integer>();
        this.index = -1;
        this._inorder(root);

    }

    private void _inorder(TreeNode root){

        if(root == null) return;

        this._inorder(root.left);
        this.nodeSorted.add(root.val);
        this._inorder(root.right);
    }

    public int next() {
        return this.nodeSorted.get(++this.index);

    }

    public boolean hasNext() {
        return this.index+1 < this.nodeSorted.size();

    }
}
