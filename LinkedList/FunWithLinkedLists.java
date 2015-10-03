import java.util.*;

public class FunWithLinkedLists {
	public static void printList(NodeSingle start) {
		NodeSingle curr = start;
		while (curr!=null) {
			System.out.println(curr.value);
			curr=curr.next1;
		}
		return;
	}
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
	public static void removeNode(NodeDouble node) {
		if (node==null) {
			return;
		}
		if (node.pre!=null && node.next!=null) {
			NodeDouble next = (NodeDouble) node.next;
			node.pre.next = next;
			next.pre = node.pre;
		} else if (node.pre != null && node.next == null) {
			node.pre.next = null;
		} else if (node.pre == null && node.next != null) {
			NodeDouble next = (NodeDouble) node.next;
			next.pre = null;
		}
		node = null;
	}
	public static void removeDupsWBuffer(NodeSingle node) {
		if (node==null) {
			return;
		}
		ArrayList<Integer> tmpBuff = new ArrayList<Integer>();
		tmpBuff.add(node.value);
		NodeSingle curr = node;
		node=node.next1;
		while (node!=null) {
			System.out.println(tmpBuff);
			if (tmpBuff.contains(node.value)) {
				curr.next1 = node.next1;
			} else {
				tmpBuff.add(node.value);
				curr = node;
			}
			node = node.next1;
		}
	}
	public static void removeDupsNoBuffer(NodeSingle node) {
		while (node!=null) {
			NodeSingle runner = node.next1;
			NodeSingle curr = node;
			while (runner!=null) {
				if (node.value==runner.value) {
					curr.next1 = runner.next1;
				} else {
					curr = runner;
				}
				runner = runner.next1;
			}
			node=node.next1;
		}
		return;
	}
	public static NodeSingle partitionList(NodeSingle start, int partition) {
		NodeSingle lessThan=null;
		NodeSingle greaterThan=null;
		NodeSingle curr = start;
		NodeSingle greaterThanStart=null;
		NodeSingle lessThanStart=null;
		while (curr!=null) {
			if (curr.value<partition) {
				if (lessThan==null) {
					lessThan = new NodeSingle(curr.value);
					lessThanStart = lessThan;
				} else {
					lessThan.next1 = new NodeSingle(curr.value);
					lessThan = lessThan.next1;
				}
			} else {
				if (greaterThan==null) {
					greaterThan = new NodeSingle(curr.value);
					greaterThanStart = greaterThan;
				} else {
					greaterThan.next1 = new NodeSingle(curr.value);
					greaterThan = greaterThan.next1;
				}
			}
			curr = curr.next1;
		}
		lessThan.next1 = greaterThanStart;
		return lessThanStart;

	}
	// public static void isPalindrome(NodeSingle start) {
		// 
	// }
	public static NodeSingle findIntersction(NodeSingle a, NodeSingle b) {
		ArrayList<NodeSingle> seenNodes = new ArrayList<NodeSingle>();
		while (a!=null || b!=null) {
			if (a==b) {
				return a;
			}
			if (seenNodes.contains(a)) {
				return a;
			} else if (seenNodes.contains(b)) {
				return b;
			}
			seenNodes.add(a); 
			seenNodes.add(b);
			a=a.next1;
			b=b.next1;
		}
		return null;
	}
	public static NodeSingle findIntersction2(NodeSingle a, NodeSingle b) {
		int length1 = size(a);
		int length2 = size(b);
		if ((length1-length2)>0){
			for (int i=0; i<length1-length2; i++) {
				a=a.next1;
			}
		} else if ((length1 - length2) < 0){
			for (int i=0; i<length2-length1; i++) {
				b=b.next1;
			}
		}
		while (a!=null && b!=null) {
			if (a==b) {
				return a;
			}
			a=a.next1;
			b=b.next1;
		}
		return null;
	}
	public static int size(NodeSingle a) {
		int size = 0;
		while (a!=null) {
			size++;
			a=a.next1;
		}
		return size;
	}
	public static boolean isSamePattern(char[] pattern, String string) {
		int length1 = pattern.length;
		String[] split = string.split(" ");
		int length2 = split.length;
		if (length1!=length2) { return false;}
		HashMap<Character, String> dict = new HashMap<Character, String>();
		HashMap<String, Character> dict2 = new HashMap<String, Character>();
		for (int i=0; i <length1; i++) {
			char tmp = pattern[i];
			String word = split[i];
			if (dict.containsKey(tmp)){
				if (dict.get(tmp).equals(word)==false){
					return false;
				}
			} else {
				dict.put(tmp, word);
			}
			if (dict2.containsKey(word)){
				if (dict2.get(word).equals(tmp)==false) {
					return false;
				}
			} else {
				dict2.put(word, tmp);
			}
		}
		return true;
	}
	public static void main (String[] args) {
		// NodeDouble x = new NodeDouble(5);
		// // NodeDouble y = new NodeDouble(6);
		// NodeDouble z = new NodeDouble(7);
		// try {
		// 	y.addNode(z);
		// 	x.addNode(y);
		// 	removeNode(y);
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }
		NodeSingle a = new NodeSingle(1);
		NodeSingle a2 = new NodeSingle(1);
		NodeSingle b = new NodeSingle(2);
		NodeSingle c = new NodeSingle(3);
		NodeSingle d = new NodeSingle(2);
		a.next1 = a2;
		a2.next1 = b;	
		b.next1=c;
		c.next1 = d;
		printList(a);
		// removeDupsNoBuffer(a);
		// printList(a);
		System.out.println("+------------------------------+");
		// printList(partitionList(a, 2));
		NodeSingle w = new NodeSingle(1);
		NodeSingle w2 = new NodeSingle(1);
		NodeSingle r = new NodeSingle(2);
		NodeSingle t = new NodeSingle(3);
		NodeSingle y = new NodeSingle(2);
		w.next1 = w2;
		w2.next1 = r;	
		r.next1=t;
		t.next1 = a;
		printList(w);
		System.out.println(findIntersction2(a, w)==a);
		System.out.println("+------------------------------+");
		char[] harsha = {'a', 'b', 'b'};
		System.out.println(isSamePattern(harsha, "cat dog dog"));
		System.out.println("+------------------------------+");
		// System.out.println(harsha.length);
	}
}