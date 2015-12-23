 // import TreeNode.class;
public class findCommonAncestor {
	public static TreeNode findCommonAncestor (TreeNode a, TreeNode b) {
		if (a==null && b==null) {
			return null;
		}
		if (a==b) {
			return a;
		}
		if (a!=null) {
			if (a.marked){
				return a;
			}
			a.marked = true;
		}
		if (b!=null) {
			if (b.marked){
				return b;
			}
			b.marked = true;
		}
		return findCommonAncestor(a.getParent()!=null ? a.getParent(): null, b.getParent()!=null ? b.getParent(): null);
	}
	public static int findSumList(TreeNode root, int goal){
		int numPaths = 0;
		numPaths = findSumHelper(root, goal, 0, numPaths);
		return numPaths;
	}
	public static int findSumHelper(TreeNode root, int goal, int curSum, int numPaths){
		System.out.println("----------");
		if (root == null) {
			return numPaths;
		}
		if ((curSum + root.getData()) == goal) {
			System.out.println("YAY");
			numPaths++;
		}
		findSumHelper(root.getLeft(), goal, curSum+root.getData(), numPaths);
		// System.out.println("x");
		System.out.println(numPaths);
		findSumHelper(root.getRight(), goal, curSum+root.getData(), numPaths);
		// System.out.println("y");
		// System.out.println(y);
		System.out.println(numPaths);
		// System.out.println(x+y);
		// System.out.println("----------");
		// return x + y;
		return numPaths;
	}
	public static void main(String[] args) {
		// TreeNode a = new TreeNode(5);
		// TreeNode b = new TreeNode(6);
		// TreeNode c = new TreeNode(7);
		// TreeNode d = new TreeNode(8);
		// d.setRight(b);
		// c.setRight(d);
		// c.setLeft(a);
		// TreeNode result = findCommonAncestor(a, b);
		// if (result != null) {
		// 	System.out.println(result.getData());
		// }
		TreeNode x = new TreeNode(4);
		TreeNode y = new TreeNode(3);
		TreeNode z = new TreeNode(2);
		x.setLeft(y);
		x.setRight(z);
		System.out.println(findSumList(x, 7));
		//first common ancestor of a and b is c

	}
}