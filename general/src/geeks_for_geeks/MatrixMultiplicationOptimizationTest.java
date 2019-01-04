package geeks_for_geeks;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixMultiplicationOptimizationTest {
    @Test
    public void testGetResult() {
        assertEquals("((A(BC))D)", MatrixMultiplicationOptimization.getOptimalParenthesization(new int[] { 4, 2, 3, 1, 3 }));
    }
}
