import java.util.*;

public class LLNode {
	int data;
	LLNode next;
	public LLNode(int data){
		this.data = data;
	}
	public LLNode(int data, LLNode next){
		this.data = data;
		this.next = next;
	}
	public void addNode(int data){
		LLNode curr = this;
		while (curr.next!=null){
			curr = curr.next;
		}
		curr.next = new LLNode(data);
	}
	public static void addNode(LLNode head, int data){
		LLNode curr = head;
		while (curr.next!=null){
			curr=curr.next;
		}
		curr.next = new LLNode(data);
	}
	public void print(){
		LLNode curr = this;
		while (curr!=null){
			System.out.println(curr.data);
			curr=curr.next;
		}
	}
	public static void print(LLNode head){
		LLNode curr = head;
		while (curr!=null){
			System.out.println(curr.data);
			curr=curr.next;
		}
	}
	public void removeNode(LLNode node){
		LLNode prev = this;
		LLNode curr = this.next;
		while (curr!=null){
			if (curr==node){
				prev.next = curr.next;
				return;
			} else {
				prev = prev.next;
			}
			curr = curr.next;
		}
		System.out.println("Node not found");
	}
	public static void removeDups(LLNode head){
		HashSet<Integer> dataSet = new HashSet<Integer>();
		LLNode curr = head;
		LLNode prev = null;
		while (curr!=null){
			if (dataSet.contains(curr.data)){
				prev.next = curr.next;
			} else {
				dataSet.add(curr.data);
				prev = curr;
			}
			curr=curr.next;
		}
	}
	public static LLNode addLists(LLNode head1, LLNode head2){
		return addListsHelper(head1, head2, 0);
	}
	public static LLNode addListsHelper(LLNode head1, LLNode head2, int carry){
		if (head1==null&&head2==null&&carry==0){
			return null;
		}
		LLNode result = new LLNode(0);
		int value = carry;
		if (head1!=null){
			carry+=head1.data;
		}
		if (head2!=null){
			carry+=head2.data;
		}
		result.data = carry%10;
		result.next = addListsHelper(head1==null ? null : head1.next, head2==null ? null : head2.next, carry/10);
		return result;
	}

	public static LLNode addListsIterative(LLNode node1, LLNode node2) {
		//O(n) time where n is the length of the larger number. O(log N) time where N is the value of the larger number
		// O(log N) space
		LLNode curr= null;
		LLNode head = null;
		int n = 0;
		while (node1 != null || node2 != null) {
			LLNode result = new LLNode(0);
			if (node1 != null) {
				n += node1.data;
				node1 = node1.next;
			}
			if (node2 != null) {
				n += node2.data;
				node2 = node2.next;
			}
			result.data = n % 10;
			if (curr == null) {
				 head = curr = result;
			} else {
				curr.next = result;
				curr = result;
			}
			n = n / 10;
		}
		return head;
	}
	public static LLNode addListsIterative2(LLNode node1, LLNode node2){
		int len1 = length(node1);
		int len2 = length(node2);
		LLNode head = null;
		if (len1<len2){
			node1 = padZeros(node1, len2-len1);
		} else {
			node2 = padZeros(node2, len1-len2);
		}
		print(node1);
		System.out.println("----");
		print(node2);
		Stack<Integer> node1Stack = new Stack<Integer>();
		Stack<Integer> node2Stack = new Stack<Integer>();
		while (node1!=null){
			node1Stack.push(node1.data);
			node1=node1.next;
		}
		while(node2!=null){
			node2Stack.push(node2.data);
			node2=node2.next;
		}
		System.out.println("True or False? node1Stack size == node2Stack size");
		System.out.println(node1Stack.size()==node1Stack.size());
		int n = 0;
		while(!node1Stack.empty()){
			int node1Data = node1Stack.pop();
			int node2Data = node2Stack.pop();
			n+=(node1Data+node2Data);
			LLNode digit = new LLNode(n%10);
			head = insertBefore(head, digit);
			n=n/10;
		}
		if (n>0){
			head = insertBefore(head, new LLNode(n));
		}
		return head;
	}
	public static LLNode insertBefore(LLNode head, LLNode digit){
		if (digit!=null){
			digit.next = head;
		}
		return digit;
	}
	public static LLNode padZeros(LLNode node, int numZeros){
		LLNode head = node;
		for (int i=0; i<numZeros; i++){
			head = insertBefore(head, new LLNode(0));
		}
		return head;
	}
	public static int length(LLNode node){
		int length = 0;
		while (node!=null){
			length+=1;
			node=node.next;
		}
		return length;
	}
	public static LLNode findKthToLast(LLNode head, int k){
		LLNode p1 = head;
		LLNode p2 = head;
		for (int i=0; i<k; i++){
			if (p1==null){
				return null;
			}
			p1=p1.next;
		}
		while (p1!=null){
			p2=p2.next;
			p1=p1.next;
		}
		return p2;
	}
	public static boolean isPalindrome(LLNode head){
		int length = length(head);
		System.out.println(length);
		if (length==1){return true;}
		int i=0;
		Stack<Integer> numStack = new Stack<Integer>();
		while(i<length/2){
			numStack.push(head.data);
			i++;
			head=head.next;	
		}
		if (length%2==1){
			head=head.next;
		}
		while(head!=null){
			if (numStack.pop()!=head.data){
				return false;
			}
			head=head.next;
		}
		return true;
	}
	public static void main(String[] args){
		LLNode head = new LLNode(2);
		head.addNode(1);
		// head.addNode(9);
		addNode(head, 1);
		addNode(head, 2);
		head.print();
		// removeDups(head);
		print(head);
		LLNode head1 = new LLNode(7);
		head1.addNode(1);
		head1.addNode(6);
		LLNode head2 = new LLNode(5);
		head2.addNode(9);
		head2.addNode(2);
		System.out.println("-----");
		print(addListsIterative2(head1, head2));
		System.out.println("-----");
		// System.out.println(isPalindrome(head1));
		System.out.println(isPalindrome(head));
	}
}