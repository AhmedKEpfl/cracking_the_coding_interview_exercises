package dynamic_programming_recursion;

import java.util.ArrayList;
import java.util.List;

public class Parens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> parens3 = parens(3);
		System.out.println(parens3);
	}
	
	public static List<String> parens(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("n should be 0 or greater !");
		}
		List<List<String>> dynParens = new ArrayList<List<String>>();
		for(int i = 0; i < n + 1; i++) {
			dynParens.add(new ArrayList<String>());
		}
		return parensRec(n, dynParens);
	}
	
	public static List<String> parensRec(int n, List<List<String>> dynParens) {
		List<String> result = new ArrayList<String>();
		if(dynParens.get(n).size() > 0) {
			return dynParens.get(n);
		} else if(n == 0) {
			result.add("");
		} else if(n == 1) {
			result.add("()");
		} else {
			for(int i = 0; i < n; i++) {
				List<String> insideParens = parensRec(i, dynParens);
				List<String> outsideParens = parensRec(n - i - 1, dynParens);
				for(int j = 0; j < insideParens.size(); j++) {
					for(int k = 0; k <  outsideParens.size(); k++) {
						result.add("(" + insideParens.get(j) + ")" + outsideParens.get(k));
					}
				}
			}
		}
		dynParens.set(n, result);
		return result;
	}
}
