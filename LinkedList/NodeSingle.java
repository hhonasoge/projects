public class NodeSingle extends Node {
	// public int value;
	public NodeSingle next1;
	public NodeSingle(int value) {
		this.value = value;
	}
	@Override
	public void addNode(Object next) throws Exception {
		if (! (next instanceof NodeSingle)) {
			throw new Exception("Invalid argument");
		}
		if (next == this) {
			throw new Exception("Cannot add same Node");
		}
		try {
			NodeSingle d = (NodeSingle) next;
			this.next = d;
		} catch(Exception ex) {
			System.out.println("Error: must provide NodeSingle " + ex.getMessage());
		}
	}
}