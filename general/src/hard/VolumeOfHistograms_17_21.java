package hard;

import java.util.Stack;

public class VolumeOfHistograms_17_21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static int volumeOfHistograms(int[] histograms) {
		int volume = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < histograms.length; i++) {
			int curr = histograms[i];
			if(curr > 0) {
				int toRemove = -1;
				while(!stack.isEmpty() && curr > histograms[stack.peek()]) {
					toRemove = stack.pop();
					if(!stack.isEmpty()) {
						volume -= histograms[toRemove] * (toRemove - stack.peek());
					} else {
						volume += histograms[toRemove] * (i - toRemove - 1);
					}
				}
				if(!stack.isEmpty()) {
					volume += (i - stack.peek() - 1) * curr;
				}
				stack.push(i);
			}
		}
		return volume;
	}
}
