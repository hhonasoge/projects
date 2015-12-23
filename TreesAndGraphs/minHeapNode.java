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
            while(true){
                if (newNode.data<traverse.data){
                    if (traverse.left==null){
                        traverse.left = newNode;
                        newNode.parent = traverse;
                        break;
                    } else {
                        traverse = traverse.left;
                    }
                } else {
                    if (traverse.right==null){
                        traverse.right = newNode;
                        newNode.parent = traverse;
                        break;
                    } else {
                        traverse = traverse.right;
                    } 
                }
            }
            while(newNode.data>newNode.parent.data){
                int tmp = newNode.data;
                newNode.data = newNode.parent.data;
                newNode.parent.data=tmp;
            }
            // bottom.right = newNode;
            // bottom = newNode;
            // minHeapNode curr = bottom;
            // while(curr.parent.data>curr.data){
            //  swap(curr, parent);
            // }
        }
    }
}