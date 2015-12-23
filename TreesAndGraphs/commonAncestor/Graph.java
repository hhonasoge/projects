import java.util.*;

public class Graph {
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public void print(){
		LinkedList<Node> queue = new LinkedList<Node>();
		for(Node n : nodes) {
			queue.add(n);
		}
		while (!queue.isEmpty()) {
			Node x = queue.remove();
			if (!x.marked){
				System.out.println(x.data);
				for(Node n : x.adjacent) {
					queue.add(n);
				}
				x.marked=true;
			}
		}
	}
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node b1 = new Node(200);
		Node b2 = new Node(201);
		Node b3 = new Node(202);
		a.addNeighbor(b);
		a.addNeighbor(c);
		a.addNeighbor(d);
		a.addNeighbor(e);
		b.addNeighbor(b1);
		b.addNeighbor(b2);
		b.addNeighbor(b3);
		Graph z = new Graph();
		z.nodes.add(a);
		z.nodes.add(b);
		z.nodes.add(c);
		z.nodes.add(d);
		z.nodes.add(e);
		z.print();
	}
}