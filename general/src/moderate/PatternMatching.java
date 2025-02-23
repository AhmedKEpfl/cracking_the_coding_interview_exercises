package moderate;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(patternMatching("bbc", "aab"));
	}
	
	public static boolean patternMatching(String string, String pattern) {
		Map<Character, String> patternDic = new HashMap<Character, String>();
		return patternMatching(string, pattern, patternDic);
	}
	
	private static int getMatchLength(String s, String match) {
		if(s.startsWith(match)) {
			return match.length();
		} else {
			return -1;
		}
	}
	
	public static boolean patternMatching(String string, String pattern, Map<Character, String> patternDic) {
		if(string.length() == 0 && pattern.length() == 0) {
			return true;
		}
		if(string.length() == 0 || pattern.length() == 0) {
			return false;
		}
		
		char nextPatternSymbol = pattern.charAt(0);
		String nextPattern = pattern.substring(1);
		if(patternDic.containsKey(nextPatternSymbol)) {
			int patternLength = getMatchLength(string, patternDic.get(nextPatternSymbol));
			if(patternLength > 0) {
				return patternMatching(string.substring(patternLength), nextPattern, patternDic);
			} else {
				return false;
			}
		} else {
			for(int i = 1; i <= string.length(); i++) {
				String nextString = string.substring(0, i);
				patternDic.put(nextPatternSymbol, nextString);
				if(patternMatching(string.substring(i), nextPattern, patternDic)) {
					return true;
				}
				patternDic.remove(nextPatternSymbol);
			}
			return false;
		}
	}
}
