package hard;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void correctPairEquality() {
		Pair<Integer> pair1 = new Pair<Integer>(4, 6);
		Pair<Integer> pair2 = new Pair<Integer>(4, 6);
		Pair<Integer> pair3 = new Pair<Integer>(4, 7);
		Pair<Integer> pair4 = new Pair<Integer>(6, 4);
		
		assertEquals(pair1, pair1);
		assertEquals(pair1, pair2);
		assertEquals(pair1, pair4);
		assertNotEquals(pair1, pair3);
		
		assertTrue(pair1.get(0) == 4);
		assertTrue(pair1.get(1) == 6);
	}

}
