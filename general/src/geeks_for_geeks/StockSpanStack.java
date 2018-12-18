package geeks_for_geeks;

import java.util.Stack;

public class StockSpanStack extends Stack<StockIncrement>{
	private int height;
	
	public StockSpanStack() {
		super();
		height = 0;
	}
	
	public StockIncrement pop() {
		StockIncrement result = super.pop();
		height -= result.getHeight();
		return result;
	}
	
	public StockIncrement push(StockIncrement si) {
		height += si.getHeight();
		return this.push(si);
	}
	
	public int getHeight() {
		return height;
	}
}
