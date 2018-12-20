package hard;

import java.util.ArrayList;
import java.util.List;

public class KthMultiple_17_9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getKthMultiple(10));
	}
	
	public static int getKthMultiple(int k) {
		int[] selectedPrimes = new int[]{3, 5, 7};
		List<Integer> result = new ArrayList<Integer>();
		int[] cursors = new int[]{1, 2, 3};
		result.add(1);
		for(int prime: selectedPrimes) {
			result.add(prime);
		}
		int i = 1;
		while(result.size() < k) {
			int multiplier = result.get(i);
			int[] possibilities = new int[3];
			for(int j = 0; j < selectedPrimes.length; j++) {
				int currVal = multiplier * result.get(cursors[j]);
				possibilities[j] = currVal;
			}
			int min = 0, minVal = Integer.MAX_VALUE;
			for(int j = 0; j < possibilities.length; j++) {
				if(possibilities[j] < minVal) {
					min = j;
					minVal = possibilities[j];
				}
			}
			result.add(minVal);
			for(int j = 0; j < possibilities.length; j++) {
				if(possibilities[j] == minVal) {
					cursors[j]++;
				}
			}
		}
		System.out.println(result);
		return result.get(result.size() - 1);
	}

}
