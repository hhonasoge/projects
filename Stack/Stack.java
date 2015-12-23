import java.util.*;

public class Stack<T>{
	private static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		public StackNode(T data){
			this.data = data;
		}
	}
	private StackNode<T> top;
	public void push(T data){
		StackNode<T> newTop = new StackNode<T>(data);
		newTop.next = top;
		top = newTop;
	}
	public T peek(){
		if (top==null) throw new EmptyStackException();
		return top.data;
	}
	public T pop(){
		if (top==null) throw new EmptyStackException();
		T rv = top.data;
	 	top=top.next;
	 	return rv;
	}
	public boolean isEmpty(){
		return top==null;
	}
	public static Stack<Integer> sort(Stack<Integer> inputStack){
		Stack<Integer> tmpStack = new Stack<Integer>();
		tmpStack.push(inputStack.pop());
		while(!inputStack.isEmpty()){
			int data = inputStack.pop();
			int counter = 0;
			while(!tmpStack.isEmpty() && data>=tmpStack.peek()){
				inputStack.push(tmpStack.pop());
				counter++;
			}
			tmpStack.push(data);
			while(counter!=0){
				tmpStack.push(inputStack.pop());
				counter--;
			}
		}
		// while(!tmpStack.isEmpty()){
		// 	inputStack.push(tmpStack.pop());
		// }
		return tmpStack;
	}
	public static void main(String[] args){
		Stack<Integer> testStack = new Stack<Integer>();
		for (int i=0; i<10; i++){
			testStack.push(i);
		}
		while(!testStack.isEmpty()){
			System.out.println(testStack.pop());
		}
		Stack<Integer> newStack = new Stack<Integer>();
		newStack.push(1);
		newStack.push(5);
		newStack.push(8);
		newStack.push(3);
		newStack.push(2);
		newStack.push(4);
		newStack.push(3);
		newStack.push(5);
		newStack.push(10);
		newStack.push(0);
		System.out.println("-------");
		newStack = sort(newStack);
		while(!newStack.isEmpty()){
			System.out.println(newStack.pop());
		}
	}
}
