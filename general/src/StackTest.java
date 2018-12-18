import static org.junit.Assert.*;

import org.junit.Test;


public class StackTest {
	
	@Test
	public void testStackBasic() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(9);
		
		assertTrue(stack.peek() == 9);
		int top = stack.pop();
		assertTrue(top == 9);
		assertTrue(stack.peek() == 3);
		assertFalse(stack.isEmpty());
		
		stack.pop();
		stack.pop();
		assertTrue(stack.isEmpty());
	}

}
