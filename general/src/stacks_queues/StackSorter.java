package stacks_queues;

import java.util.Stack;

public class StackSorter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<Integer>();
		
		boolean sorted = false;
		
		while(!sorted) {
			sorted = true;
			while(!stack.isEmpty()) {
				int item = stack.pop();
				if(tempStack.isEmpty()) {
					tempStack.push(item);
				} else {
					int topTemp = tempStack.pop();
					if(item < topTemp) {
						tempStack.push(item);
						tempStack.push(topTemp);
						sorted = false;
					} else {
						tempStack.push(topTemp);
						tempStack.push(item);
					}
				}
			}
			
			restack(stack, tempStack);
		}
	}
	
	public static void restack(Stack<Integer> dest, Stack<Integer> source) {
		while(!source.isEmpty()) {
			int item = source.pop();
			dest.push(item);
		}
	}

}
