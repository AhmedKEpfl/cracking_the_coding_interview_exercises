import java.util.NoSuchElementException;


public class MyQueue<T> {
	private Stack<T>[] stacks;
	private int currentStack;
	
	public MyQueue() {
		stacks = new Stack[2];
		stacks[0] = new Stack<T>();
		stacks[1] = new Stack<T>();
	}
	
	public void add(T item) {
		if(currentStack == 1) {
			restack();
		}
		currentStack = 0;
		stacks[currentStack].push(item);
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		if(currentStack == 0) {
			restack();
		}
		currentStack = 1;
		return stacks[currentStack].peek();
	}
	
	public T remove() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		if(currentStack == 0) {
			restack();
		}
		currentStack = 1;
		return stacks[currentStack].pop();
	}
	
	public boolean isEmpty() {
		return stacks[currentStack].isEmpty();
	}
	
	private void restack() {
		int destinationStack = 1 - currentStack;
		while(!stacks[currentStack].isEmpty()) {
			T item = stacks[currentStack].pop();
			stacks[destinationStack].push(item);
		}
	}
}
