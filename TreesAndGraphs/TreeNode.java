import java.util.*;

public class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	private int size = 0; 
	public TreeNode(int data){
		this.data = data;
	}
	public void setLeftChild(TreeNode left){
		this.left = left;
		if (left!=null){
			left.parent = this;
		}
	}
	public void setRightChild(TreeNode right){
		this.right = right;
		if (right!=null){
			right.parent = this;
		}
	}
	public void insertInOrderR(int data){
		if (data<=this.data){
			if (left==null){
				setLeftChild(new TreeNode(data));
			} else {
				left.insertInOrderR(data);
			}
		} else {
			if (right==null){
				setRightChild(new TreeNode(data));
			} else {
				right.insertInOrderR(data);
			}
		}
		size++;
	}
	public void insertInOrderI(int data){
		TreeNode curr = this;
		while(curr!=null){
			if (data<=curr.data){
				if (curr.left==null){
					curr.setLeftChild(new TreeNode(data));
					size++;
					return;
				} else {
					curr = curr.left;
				}
			} else {
				if (curr.right==null){
					curr.setRightChild(new TreeNode(data));
					size++;
					return;
				} else {
					curr = curr.right;
				}
			}
		}
		return;
	}
	public int size(){
		return size;
	}
	public static TreeNode createMinimalBST(int[] arr){
		return createMinimalBSTHelper(arr, 0, arr.length-1, null);
	}
	public static TreeNode createMinimalBSTHelper(int[] arr, int start, int end, TreeNode parent){
		if (start>end) return null;
		int mid = (start+end)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.parent = parent;
		node.left = createMinimalBSTHelper(arr, start, mid-1, node);
		node.right = createMinimalBSTHelper(arr, mid+1, end, node);
		return node;
	}
	public static class NodeValue{
		int height;
		TreeNode node;
		public NodeValue(TreeNode node, int height){
			this.node = node;
			this.height = height;
		}
	}
	public static ArrayList<LinkedList<TreeNode>> makeDepthLists(TreeNode root){
		ArrayList<LinkedList<TreeNode>> finalList = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<NodeValue> q = new LinkedList<NodeValue>();
		q.add(new NodeValue(root, 0));
		while(!q.isEmpty()){
			// System.out.println("++++++++++");
			// System.out.println("finalList.size() = " + finalList.size());
			// for (int i=0; i<finalList.size();i++){
				// System.out.println("--------");
				// System.out.println(finalList.get(i).peek().data);
				// System.out.println("--------");
			// }
			NodeValue nodevalue = q.remove();
			int height = nodevalue.height;
			TreeNode node = nodevalue.node;
			LinkedList<TreeNode> newList;
			// System.out.println("height = " + height);
			// System.out.println("node = " + node.data);
			// System.out.println("=====");
			if (finalList.size()-1<height){
				// System.out.println("in the first if");
				newList = new LinkedList<TreeNode>();
				newList.add(node);
			} else {
				newList = finalList.remove(height);
				newList.add(node);
			}
			finalList.add(height, newList);
			if (node.left!=null){
				q.add(new NodeValue(node.left, height+1));
			}
			if (node.right!=null){
				q.add(new NodeValue(node.right, height+1));	
			}
		}
		return finalList;
	}
	public static void printInOrder(TreeNode root){
		if (root==null)return;
		printInOrder(root.left);
		System.out.println(root.data);
		printInOrder(root.right);
	}
	public static void printPreOrder(TreeNode root){
		if (root==null)return;
		System.out.println(root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	public static void printPostOrder(TreeNode root){
		if (root==null)return;
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.println(root.data);
	}	
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	public static boolean isBalanced(TreeNode root){
		if (root==null)return true;
		int leftHeight=root.left.height();
		int rightHeight=root.right.height();
		if(Math.abs(rightHeight-leftHeight)>1)return false;
		return (isBalanced(root.right) && isBalanced(root.left));
	}
	public static boolean isBalanced2(TreeNode root){
		if (checkHeight(root)==-1){
			return false;
		} else {
			return true;
		}
	}
	public static int checkHeight(TreeNode root){
		int leftHeight;
		int rightHeight;
		if (root.left==null){
			leftHeight = 0;
		} else {
			leftHeight = checkHeight(root.left);
		}
		if (root.right==null){
			rightHeight = 0;
		} else {
			rightHeight = checkHeight(root.right);
		}
		if (leftHeight==-1||rightHeight==-1){
			return -1;
		}
		int diff = Math.abs(leftHeight - rightHeight);
		if (diff>1){
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	public static boolean isBST(TreeNode root){
		Integer last_printed = null;
		return isBSTHelper(root, last_printed);
	}
	public static boolean isBSTHelper(TreeNode root, Integer last_printed){
		if (root==null)return true;
		if (!isBSTHelper(root.left, last_printed))return false;
		if (last_printed!=null&&root.data<last_printed)return false;
		last_printed=root.data;
		if (!isBSTHelper(root.right, last_printed))return false;
		return true;
	}
	public static int countPathsWithSum(TreeNode root, int targetSum){
		if (root==null)return 0;
		int sumThis = countPathsFromNode(root, targetSum, 0);
		return sumThis+countPathsWithSum(root.left, targetSum)+countPathsWithSum(root.right, targetSum);
	}
	public static int countPathsFromNode(TreeNode root, int targetSum, int currSum){
		if (root==null)return 0;
		currSum+=root.data;
		int totalPaths = 0;
		if (currSum==targetSum){
			totalPaths+=1;
		}
		return totalPaths + countPathsFromNode(root.left, targetSum, currSum) + countPathsFromNode(root.right, targetSum, currSum);
	}
	public static int countPathsWithSum2(TreeNode root, int targetSum){
		if (root==null)return 0;
		HashMap<Integer, Integer> pathCounts = new HashMap<Integer, Integer>();
		pathCounts.put(0, 1);
		return countPathsWithSum2(root, targetSum, 0, pathCounts);
	}
	public static int countPathsWithSum2(TreeNode root, int targetSum, int runningSum, HashMap<Integer, Integer> pathCounts){
		if (root==null)return 0;
		runningSum+=root.data;
		if (pathCounts.containsKey(runningSum)){
			pathCounts.put(runningSum, pathCounts.get(runningSum)+1);
		} else {
			pathCounts.put(runningSum, 1);
		}
		int totalPaths = 0;
		if (pathCounts.containsKey(runningSum-targetSum)){
			totalPaths+= pathCounts.get(runningSum-targetSum);
		}
		totalPaths+=countPathsWithSum2(root.left, targetSum, runningSum, pathCounts);
		totalPaths+=countPathsWithSum2(root.right, targetSum, runningSum, pathCounts);
		pathCounts.put(runningSum, pathCounts.get(runningSum)-1);
		return totalPaths;
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		for(int i=0;i<10;i++){
			root.insertInOrderI(i);
		}
		printInOrder(root);
		System.out.println(root.size);
		int[] arr = {0, 1, 2, 3, 4};
		System.out.println("===============");
		TreeNode test = createMinimalBST(arr);
		System.out.println("HEIGHT = " + test.height());
		printInOrder(test);
		System.out.println("===============");
		printPostOrder(test);
		System.out.println("===============");
		printPreOrder(test);
		System.out.println("===============");
		ArrayList<LinkedList<TreeNode>> nodeList = makeDepthLists(test);
		System.out.println(nodeList.size());
		for (int i=0;i<nodeList.size();i++){
			LinkedList<TreeNode> list = nodeList.get(i);
			System.out.println("List size = " + list.size());
			while (!list.isEmpty()){
				System.out.println(list.remove().data);
			}
			System.out.println("**************");
		}
	}
	// TreeNode test = createMinimalBST(arr);
}