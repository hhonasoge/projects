import java.util.*;

public class minHeap{
    private static class minHeapNode{
        private int data;
        private minHeapNode left;
        private minHeapNode right;
        private minHeapNode parent;
        private int height;
        public minHeapNode(int data){
            this.data = data;
        }
    }
    public minHeapNode root;
    public void insert(int data){
        if (root==null){
            root = new minHeapNode(data);
        } else {
            minHeapNode newNode = new minHeapNode(data);
            minHeapNode traverse = root;
            // System.out.println("ROOT = "+ root.data);
            while(true){
                if (newNode.data<traverse.data){
                    if (traverse.left==null){
                        traverse.left = newNode;
                        newNode.parent = traverse;
						// System.out.println("PARENT LEFT "+newNode.parent.data);
                    	// System.out.println("CHILD LEFT " + newNode.data);
                        break;
                    } else {
                        traverse = traverse.left;
                    }
                } else {
                    if (traverse.right==null){
                        traverse.right = newNode;
                        newNode.parent = traverse;
                    	// System.out.println("PARENT RIGHT " + newNode.parent.data);
                    	// System.out.println("CHILD RIGHT " + newNode.data);
                        break;
                    } else {
                        traverse = traverse.right;
                    } 
                }
            }
            while(newNode!=null&&newNode.parent!=null&&newNode.data<newNode.parent.data){
                int tmp = newNode.data;
                newNode.data = newNode.parent.data;
                newNode.parent.data=tmp;
                newNode = newNode.parent;
                // System.out.println("DATA " + newNode.data);
                if (newNode.parent!=null){
                	// System.out.println("PARENT DATA " + newNode.parent.data);
                }
            }
        }
    }

    public static class KeyValue {
    	int depth;
    	minHeapNode node;
    	public KeyValue(int depth, minHeapNode node) {
    		this.depth = depth;
    		this.node = node;
    	}
    };

    public KeyValue getBottomNode(int depth, minHeapNode current) {
    	KeyValue left = (current.left != null) ? getBottomNode(depth+1, current.left) : 
    	new KeyValue(depth, current);
    	KeyValue right = (current.right != null) ? getBottomNode(depth+1, current.right) :
    	new KeyValue(depth, current);

    	if (left.depth > right.depth) return left; else return right;
    }
    public minHeapNode getBottomIter(minHeapNode root){
    	LinkedList<minHeapNode> q = new LinkedList<minHeapNode>();
    	q.add(root);
    	minHeapNode value=null;
    	while(!q.isEmpty()){
			value = q.remove();
    		if (value.left!=null) q.add(value.left);
    		if (value.right!=null) q.add(value.right);
    	}
    	return value;
    }
    public int extractMin(){
    	minHeapNode bottomRight = getBottomIter(this.root);
    	// System.out.println("bottomRight = " + bottomRight.data);
    	int rv = root.data;
    	root.data = bottomRight.data;
    	if (bottomRight.parent!=null){
    		if (bottomRight.parent.left==bottomRight){
    			bottomRight.parent.left = null;
    		} else {
    			bottomRight.parent.right = null;
    		}
    	} else {
    		root = null;
    		return rv;
    	}
    	minHeapNode curr = root;
    	while(curr!=null&&(curr.right!=null||curr.left!=null)){
    		// System.out.println(curr.right!=null);
    		minHeapNode tmp2 = curr;
    		if (curr.left!=null&&curr.right!=null){
    			int min = Math.min(curr.left.data, curr.right.data);
    			if (curr.left.data==min&&curr.data>min){
    				int tmp = curr.data;
	    			curr.data = curr.left.data;
	    			curr.left.data = tmp;
	    			curr = curr.left;
    			} else if (curr.right.data==min&&curr.data>min){
    				int tmp = curr.data;
	    			curr.data = curr.right.data;
	    			curr.right.data = tmp;
	    			curr = curr.right;
    			}
    		}
    		if (curr.left!=null){
    			if (curr.data>curr.left.data){
	    			int tmp = curr.data;
	    			curr.data = curr.left.data;
	    			curr.left.data = tmp;
	    			curr = curr.left;
	    		}
	    	} if (tmp2==curr&&curr.right!=null){
	    		if (curr.data>curr.right.data){
	    			int tmp = curr.data;
	    			curr.data = curr.right.data;
	    			curr.right.data = tmp;
	    			curr = curr.right;
	    		}
	    	}
	    	if (tmp2==curr){
	    		break;
	    	}
    	}
    	return rv;
    }
    public static void print(minHeap heap){
    	if (heap.root==null) return;
    	minHeapNode root = heap.root;
    	LinkedList<minHeapNode> q = new LinkedList<minHeapNode>();
    	q.add(root);
    	minHeapNode value=null;
    	while(!q.isEmpty()){
			value = q.remove();
			System.out.println(value.data);
    		if (value.left!=null) q.add(value.left);
    		if (value.right!=null) q.add(value.right);
    	}
    }
    public static void main(String[] args){
    	minHeap test = new minHeap();
    	test.insert(10);
    	test.insert(2);
    	test.insert(6);
    	test.insert(7);
    	test.insert(4);
    	test.insert(11);
    	print(test);
    	System.out.println("MIN1 " + test.extractMin());
    	System.out.println("MIN2 " + test.extractMin());
    	System.out.println("MIN3 " + test.extractMin());
    	System.out.println("MIN4 " + test.extractMin());
    	System.out.println("MIN5 " + test.extractMin());
    	System.out.println("MIN6 " + test.extractMin());
    	print(test);
    	// System.out.println("MIN " + test.extractMin());
    }
}