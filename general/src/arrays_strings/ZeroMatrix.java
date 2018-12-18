package arrays_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] myMatrix = new int[][]{
				{1, 0, 5, 8, 7},
				{1, 2, 3, 4, 5},
				{9, 4, 6, 0, 2},
				{1, 2, 3, 4, 5}
		};
		
		for(int i = 0; i < myMatrix.length; i++) {
			System.out.println(Arrays.toString(myMatrix[i]));
		}
		
		zeroMatrix(myMatrix);
		
		for(int i = 0; i < myMatrix.length; i++) {
			System.out.println(Arrays.toString(myMatrix[i]));
		}
	}

	
	public static void zeroMatrix(int[][] matrix) {
		int height = matrix.length;
		int width = height > 0 ? matrix[0].length : 0;
		
		for(int i = 0; i < height; i++) {
			if(matrix[i].length != width) {
				throw new IllegalArgumentException();
			}
		}
		
		Set<Integer> zeroRows = new HashSet<Integer>();
		Set<Integer> zeroCols = new HashSet<Integer>();
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(matrix[i][j] == 0) {
					zeroRows.add(i);
					zeroCols.add(j);
				}
			}
		}
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(zeroRows.contains(i) || zeroCols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
