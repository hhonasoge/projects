import java.util.*;

public class Node{
	public int data;
	boolean marked;
	public Node (int data) {
		this.data = data;
		marked = false;
	}
	public ArrayList<Node> adjacent = new ArrayList<Node>();
	public void addNeighbor(Node neighbor) {
		adjacent.add(neighbor);
		neighbor.adjacent.add(this);
	}
}