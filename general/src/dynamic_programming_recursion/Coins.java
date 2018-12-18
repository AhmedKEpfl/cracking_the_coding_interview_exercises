package dynamic_programming_recursion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Coins {
	
	public static final int[] LIST_PIECES = new int[]{1, 5, 10, 25};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nbWays(13));
	}
	
	public static List<Combination> waysRec(int n, Combination comb) {
		List<Combination> allWays = new ArrayList<Combination>();
		if(n < 0) {
			return allWays;
		} else if(n < 5) {
			allWays.add(new Combination(comb, 0, n));
			return allWays;
		} else {
			for(int i = 0; i < LIST_PIECES.length; i++) {
				int remainder = n - LIST_PIECES[i];
				Combination newComb = new Combination(comb, i);
				List<Combination> ways = waysRec(remainder, newComb);
				allWays.addAll(ways);
			}
			return allWays;
		}
	}
	
	public static int nbWays(int n) {
		Combination comb = new Combination();
		List<Combination> ways = waysRec(n, comb);
		Set<Combination> waysNoDup = new HashSet<Combination>();
		
		System.out.println(ways.toString());
		
		for(int i = 0; i < ways.size(); i++) {
			waysNoDup.add(ways.get(i));
		}
		return waysNoDup.size();
	}

}
