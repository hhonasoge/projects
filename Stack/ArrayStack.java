import java.util.*;

public class ArrayStack{
	private int numStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	public ArrayStack(int stackSize){
		stackCapacity = stackSize;
		values = new int[stackSize*3];
		sizes = new int[numStacks];
	}
	public int indexOfTop(int stackNum){
		int offset = stackNum*stackCapacity;
		int size = sizes[stackNum];
		return offset + size-1;
	}
	public void push(int stackNum, int value){
		if (isFull(stackNum)) throw new EmptyStackException();
		sizes[stackNum]++;
		int topIndex = indexOfTop(stackNum);
		values[topIndex]=value;
	}
	public int pop(int stackNum){
		if (isEmpty(stackNum)) throw new EmptyStackException();
		int topIndex = indexOfTop(stackNum);
		int rv = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return rv;
	}
	public int peek(int stackNum){
		if (isEmpty(stackNum)) throw new EmptyStackException();
		return values[indexOfTop(stackNum)];
	}
	public boolean isFull(int stackNum){
		return sizes[stackNum]==stackCapacity;
	}
	public boolean isEmpty(int stackNum){
		return sizes[stackNum]==0;
	}
	public void print(){
		for (int i=0;i<values.length;i++){
			if (i==stackCapacity||i==stackCapacity*2){
				System.out.println("---------");
			}
			System.out.println(values[i]);
		}
	}
	public static void main(String[] args){
		ArrayStack tripleStack = new ArrayStack(10);
		tripleStack.print();
		System.out.println("~~~~~~~~~");
		for (int i=0; i<10;i++){
			tripleStack.push(0, i);
			tripleStack.push(1, i*i);
			tripleStack.push(2, i*i*i);
		}
		tripleStack.print();
		for (int i=0; i<5;i++){
			System.out.println(tripleStack.pop(0));
			System.out.println(tripleStack.pop(1));
			System.out.println(tripleStack.pop(2));
		}
		System.out.println("=====================");
		tripleStack.print();
	}
}