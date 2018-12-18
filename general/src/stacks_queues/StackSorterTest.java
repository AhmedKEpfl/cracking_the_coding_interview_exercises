package stacks_queues;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class StackSorterTest {

	@Test
	public void testBasicStackSorter() {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(3);
		stack.push(6);
		stack.push(1);
		stack.push(4);
		
		StackSorter.sortStack(stack);
		
		assertTrue(stack.pop() == 1);
		assertTrue(stack.pop() == 3);
		assertTrue(stack.pop() == 4);
		assertTrue(stack.pop() == 6);
		assertTrue(stack.isEmpty());
	}

}
