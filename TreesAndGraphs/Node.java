import java.util.*;
// import java.lang.*;

public class Node{
	public int data;
	public Node[] adjacent;
	public int adjacent_count;
	public boolean isVisited;
	public Node(int data){
		this.data = data;
		// @SuppressWarnings("unchecked")
		adjacent = new Node[30];
		adjacent_count = 0;
	}
	public void addAdjacent(Node x){
		if (adjacent_count==30){
			System.out.println("Full adjacent count. Cannot add more nodes");
			return;
		} else {
			adjacent[adjacent_count] = x;
			adjacent_count++;
		}
	}
	public void addAdjacent(int x){
		if (adjacent_count==30){
			System.out.println("Full adjacent count. Cannot add more nodes");
			return;
		} else {
			// @SuppressWarnings("unchecked")
			adjacent[adjacent_count] = new Node(x);
			adjacent_count++;
		}
	}
	public void print(){
		System.out.println(data);
		for (int i=0; i<adjacent_count;i++){
			System.out.println("adjacent["+i+"]="+ adjacent[i]);
		}
	}
	public static void main(String[] args){
		Node testNode = new Node(2);
		testNode.addAdjacent(new Node(4));
		testNode.print();
	}
}