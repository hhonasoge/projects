public class FunWithLinkedLists {
	public static void printList(Node start) {
		Node curr = start;
		while (curr!=null) {
			System.out.println(curr.value);
			curr=curr.next;
		}
		return;
	}
	// public static void printList(NodeDouble start) {
	// 	NodeDouble curr = start;
	// 	while (curr!=null) {
	// 		System.out.println(curr.value);
	// 		curr=curr.next;
	// 	}
	// 	return;
	// }
	public static NodeDouble reverseList(NodeDouble start) {
		NodeDouble curr = start;
		NodeDouble tmp;
		while (curr.next != null) {
			tmp = (NodeDouble) curr.next;
			curr.next = curr.pre;
			curr.pre = tmp;
			curr=tmp;
		}
		curr.next = curr.pre;
		curr.pre = null;
		return curr;
	}
	public static void main (String[] args) {
		NodeDouble x = new NodeDouble(5);
		NodeDouble y = new NodeDouble(6);
		NodeDouble z = new NodeDouble(7);
		try {
			y.addNode(z);
			x.addNode(y);
			NodeDouble a = reverseList(x);
			printList(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}