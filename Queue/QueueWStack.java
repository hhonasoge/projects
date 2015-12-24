import java.util.*;

public class QueueWStack<T>{
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2= new Stack<T>();
	public void push(T data){
		stack1.push(data);
	}
	public T pop(){
		T data;
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		data = stack2.pop();
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		return data;
	}
	public T peek(){
		T data;
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		data = stack2.peek();
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		return data;
	}
	public boolean isEmpty(){
		return stack1.isEmpty()&&stack2.isEmpty();
	}
	public static void main(String[] args){
		QueueWStack<Integer> testq = new QueueWStack<Integer>();
		for (int i=0;i<10;i++){
			testq.push(i);
		}
		while(!testq.isEmpty()){
			System.out.println(testq.pop());
		}
	}
}