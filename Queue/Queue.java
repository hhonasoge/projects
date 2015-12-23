import java.util.*;

public class Queue<T>{
	private static class QueueNode<T>{
		private T data;
		private QueueNode<T> next;
		public QueueNode(T data){
			this.data = data;
		}
	}
	private QueueNode<T> bottom;
	private QueueNode<T> top;
	public void push(T data){
		QueueNode<T> newTop = new QueueNode<T>(data);
		if (top==null){
			bottom = newTop;
			top=newTop;
			top.next=null;
		} else {
			top.next=newTop;
			top = newTop;
		}
	}
	public T pop(){
		if (bottom==null) throw new EmptyStackException();
		T rv = bottom.data;
		bottom = bottom.next;
		return rv;
	}
	public T peek(){
		if (bottom==null) throw new EmptyStackException();
		return bottom.data;
	}
	public boolean isEmpty(){
		return bottom==null;
	}
	public static void main(String[] args){
		Queue<Integer> testQueue = new Queue<Integer>();
		for (int i=0; i<10; i++){
			testQueue.push(i);
		}
		while(!testQueue.isEmpty()){
			System.out.println(testQueue.pop());
		}
	}

}