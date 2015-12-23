public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	public boolean marked = false;
	public TreeNode(int data) {
		this.data = data;
	}
	public void setLeft(TreeNode left) {
		this.left=left;
		if (left!=null) {
			left.parent = this;
		}
	}
	public void setRight(TreeNode right) {
		this.right = right;
		if (right!=null) {
			right.parent = this;
		}
	}
	public int getData(){ return data;}
	public TreeNode getParent(){ return parent;}
	public TreeNode getLeft(){ return left;}
	public TreeNode getRight(){ return right;}
}