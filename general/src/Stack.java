import java.util.EmptyStackException;


public class Stack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	
	public T pop() {
		if(top == null) {
			throw new EmptyStackException();
		}
		
		T result = top.data;
		top = top.next;
		return result;
	}
	
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public void push(T data) {
		StackNode<T> newTop = new StackNode<T>(data);
		newTop.next = top;
		top = newTop;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
