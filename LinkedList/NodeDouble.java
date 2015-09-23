public class NodeDouble extends Node {
	// public int value;
	public NodeDouble pre;
	// public NodeDouble next;
	public NodeDouble(int value) {
		this.value = value;
	}
	// @Override
	public void addNode(Object next) throws Exception {
		if (! (next instanceof NodeDouble)) {
			throw new Exception("Invalid argument");
		}
		if (next == this) {
			throw new Exception("Cannot add same Node");
		}
		try {
			NodeDouble d = (NodeDouble) next;
			this.next = d;
			d.pre = this;
		} catch(Exception ex) {
			System.out.println("Error: must provide NodeDouble " + ex.getMessage());
		}
	}
	public static void main(String[] args) throws Exception {
		NodeDouble x = new NodeDouble(5);
		String tmp = "Harsha";
		x.addNode(x);
		// printList(x);
	}
}