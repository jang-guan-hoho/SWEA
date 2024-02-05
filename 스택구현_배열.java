package java_Day_12;

public class 스택구현_배열 {
	
	static int[] stack = new int[5];
	static int top=-1;
	
	public static void push(int i) {
		if(isFull()) {
			System.out.println("추가불가");
			return;
		}
		stack[++top]=i;
	}
	
	public static int pop() {
		if(isEmpty()) {
			System.out.println("nodata");
			return -1;
		}
		return stack[top--];
	}
	public static boolean isEmpty() {
		return top==-1;
	}
	public static boolean isFull() {
		return top==stack.length-1;
	}
	public static void main(String[] args) {
		push(1);
		push(2);push(3);push(4);push(5);
	}
}
