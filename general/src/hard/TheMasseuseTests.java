package hard;

import static org.junit.Assert.*;

import org.junit.Test;

public class TheMasseuseTests {

	@Test
	public void testAFewCases() {
		assertEquals(180, TheMasseuse_17_16.theMasseuse(new int[]{30, 15, 60, 75, 45, 15, 15, 45}));
		assertEquals(330, TheMasseuse_17_16.theMasseuse(new int[]{ 75, 105, 120, 75, 90, 135 }));
		assertEquals(90, TheMasseuse_17_16.theMasseuse(new int[]{ 45, 60, 45, 15 }));
	}

}
