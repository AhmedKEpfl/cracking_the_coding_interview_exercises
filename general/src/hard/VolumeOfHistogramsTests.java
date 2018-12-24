package hard;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolumeOfHistogramsTests {

	@Test
	public void testAFewCases() {
		assertEquals(26, VolumeOfHistograms_17_21.volumeOfHistograms(new int[]{0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0}));
		assertEquals(46, VolumeOfHistograms_17_21.volumeOfHistograms(new int[]{0,0,4,0,0,6,0,0,3,0,8,0,2,0,5,2,0,3,0,0}));
		assertEquals(15, VolumeOfHistograms_17_21.volumeOfHistograms(new int[]{3, 1, 4, 0, 0, 6, 0, 3, 0, 2}));
	}

}
