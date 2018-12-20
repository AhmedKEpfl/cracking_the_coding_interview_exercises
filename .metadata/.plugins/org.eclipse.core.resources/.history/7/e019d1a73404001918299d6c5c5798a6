package hard;

import java.util.HashSet;
import java.util.Set;

public class ReSpace_17_13 {
	
	private static class ParseResult{
		private int nbUnrecognized;
		private String parsed;
		public ParseResult(String parsed, int nbUnrecognized) {
			this.parsed = parsed;
			this.nbUnrecognized = nbUnrecognized;
		}
		
		public String getParsed() {
			return parsed;
		}
		
		public int getNbUnrecognized() {
			return nbUnrecognized;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("looked");
		dict.add("like");
		dict.add("her");
		dict.add("brother");
		System.out.println(parsed("jesslookedliketimherbrother", dict));
	}
	
	public static String parsed(String string, Set<String> dict) {
		ParseResult[] memo = new ParseResult[string.length()];
		return split(string, dict, memo, 0, 0).getParsed();
	}
	
	public static ParseResult split(String string, Set<String> dict, ParseResult[] memo, int nbInvalid, int start) {
		System.out.println(start);
		if(start == string.length()) {
			System.out.println("Returning");
			return new ParseResult("", nbInvalid);
		}
		if(memo[start] != null) {
			return memo[start];
		}
		
		ParseResult best = new ParseResult("", Integer.MAX_VALUE);
		for(int i = start + 1; i <= string.length(); i++) {
			String startString = string.substring(start, i);
			int currNbInvalid = nbInvalid;
			if(!dict.contains(startString)) {
				currNbInvalid += (i - start);
			}
			ParseResult curr = split(string, dict, memo, currNbInvalid, i);
			if(curr.getNbUnrecognized() < best.getNbUnrecognized()) {
				best = new ParseResult(startString + " " + curr.getParsed(), curr.getNbUnrecognized());
			}
		}
		memo[start] = best;
		return best;
	}

}
