package bit_manipulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryToStringTest {

	@Test
	public void aFewTest() {
		double number = 0.5;
		assertEquals(BinaryToString.binary(number), "0.1");
		assertEquals(BinaryToString.binary(0.125), "0.001");
		assertEquals(BinaryToString.binary(0.66), "ERROR");
	}

}
