package hard;

import java.util.Arrays;

public class TheMasseuse_17_16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(theMasseuse(new int[]{ 30, 15, 60, 75, 45, 15, 15, 45}));
	}
	
	public static int theMasseuse(int[] requests) {
		if(requests.length == 0) {
			return 0;
		}
		if(requests.length == 1) {
			return requests[0];
		}
		int[] memo = new int[2];
		memo[0] = requests[0];
		memo[1] = Math.max(requests[0], requests[1]);
		for(int i = 2; i < requests.length; i++) {
			int previousResult = requests[i] + memo[0];
			int currentResult = memo[1];
			if(previousResult > currentResult) {
				memo[0] = memo[1];
				memo[1] = previousResult;
			} else {
				memo[0] = currentResult;
				memo[1] = currentResult;
			}
		}
		System.out.println(Arrays.toString(memo));
		return memo[memo.length - 1];
	}
}
