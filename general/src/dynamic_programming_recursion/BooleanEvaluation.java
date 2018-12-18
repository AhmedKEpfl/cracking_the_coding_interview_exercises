package dynamic_programming_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooleanEvaluation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countEval("0&0&0&1^1|0", true));
	}
	
	public static int countEval(String expr, boolean val) {
		int index = val ? 1 : 0;
		return booleanEval(expr).get(index);
	}
	
	public static List<Integer> booleanEval(String expr) {
		Map<String, List<Integer>> dynBoolean = new HashMap<String, List<Integer>>();
		List<Integer> ways0 = getTuple(1, 0);
		List<Integer> ways1 = getTuple(0, 1);
		dynBoolean.put("0", ways0);
		dynBoolean.put("1", ways1);
		List<Integer> finalRes = booleanEvalRec(expr, dynBoolean);
		/*
		System.out.println(dynBoolean);
		for(String exprTest: dynBoolean.keySet()) {
			System.out.println(exprTest);
		}
		*/
		return finalRes;
	}
	
	public static List<Integer> booleanEvalRec(String expr, Map<String, List<Integer>> dynBoolean) {
		if(dynBoolean.containsKey(expr)) {
			return dynBoolean.get(expr);
		} else {
			int ways0 = 0, ways1 = 0;
			for(int divPos = 1; divPos < expr.length(); divPos+= 2) {
				List<Integer> leftBooleanEval = booleanEvalRec(expr.substring(0, divPos), dynBoolean);
				List<Integer> rightBooleanEval = booleanEvalRec(expr.substring(divPos + 1), dynBoolean);
				char div = expr.charAt(divPos);
				int leftFalse = leftBooleanEval.get(0);
				int leftTrue = leftBooleanEval.get(1);
				int rightFalse = rightBooleanEval.get(0);
				int rightTrue = rightBooleanEval.get(1);
				/*
				System.out.println(leftFalse);
				System.out.println(leftTrue);
				System.out.println(rightFalse);
				System.out.println(rightTrue);
				*/
				if(div == '^') {
					ways0 += (leftFalse * rightFalse + leftTrue * rightTrue);
					ways1 += (leftFalse * rightTrue + leftTrue * rightFalse);
				} else if(div == '|') {
					ways0 += (leftFalse * rightFalse);
					ways1 += (leftFalse * rightTrue + leftTrue * rightFalse + leftTrue * rightTrue);
				} else {
					ways0 += (leftFalse * rightFalse + leftTrue * rightFalse + leftFalse * rightTrue);
					ways1 += (leftTrue * rightTrue);
				}
			}
			List<Integer> res = getTuple(ways0, ways1);
			dynBoolean.put(expr, res);
			return res;
		}
	}
	
	public static List<Integer> getTuple(int a, int b) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(a);
		result.add(b);
		return result;
	}

}
