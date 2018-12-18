package geeks_for_geeks;

public class StockSpanProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] stockSpans(int[] stocks) {
		int[] result = new int[stocks.length];
		result[0] = 1;
		StockSpanStack stack = new StockSpanStack();
		for(int i = stocks.length - 1; i >= 0; i++) {
			if(i > 0) {
				int heightNext = stocks[i] - stocks[i - 1];
				if(heightNext > 0) {
					stack.push(new StockIncrement(heightNext, i));
				}
			}
		}
	}

}
