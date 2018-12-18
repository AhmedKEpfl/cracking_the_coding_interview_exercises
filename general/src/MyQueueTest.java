import static org.junit.Assert.*;

import org.junit.Test;


public class MyQueueTest {

	@Test
	public void testMyQueueBasic() {
		MyQueue<Integer> q = new MyQueue<Integer>();
		
		q.add(4);
		q.add(7);
		assertTrue(q.peek() == 4);
		
		assertTrue(q.remove() == 4);
		
		q.add(9);
		q.add(1);
		q.add(2);
		assertFalse(q.isEmpty());
		
		assertTrue(q.remove() == 7);
		assertTrue(q.remove() == 9);
		assertTrue(q.remove() == 1);
		assertTrue(q.remove() == 2);
		assertTrue(q.isEmpty());
	}

}
