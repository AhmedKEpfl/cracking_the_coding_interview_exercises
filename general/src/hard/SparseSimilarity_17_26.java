package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SparseSimilarity_17_26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Map<Pair<Integer>, Double> getSimilarities(Map<Integer, Set<Integer>> documents) {
		Map<Integer, List<Integer>> inverseList = new HashMap<Integer, List<Integer>>();
		for(Entry<Integer, Set<Integer>> entry: documents.entrySet()) {
			for(int word: entry.getValue()) {
				if(!inverseList.containsKey(word)) {
					inverseList.put(word, new ArrayList<Integer>());
				}
				
				inverseList.get(word).add(entry.getKey());
			}
		}
		
		Map<Pair<Integer>, Integer> similarities = new HashMap<Pair<Integer>, Integer>();
		
		for(Entry<Integer, List<Integer>> entry: inverseList.entrySet()) {
			List<Integer> matchingocuments = entry.getValue();
			for(int i = 0; i < matchingocuments.size(); i++) {
				for(int j = i + 1; j < matchingocuments.size(); j++) {
					Pair<Integer> pair = new Pair<Integer>(matchingocuments.get(i), matchingocuments.get(j));
					if(!(similarities.containsKey(pair))) {
						similarities.put(pair, 0);
					}
					
					similarities.put(pair, similarities.get(pair) + 1);
				}
			}
		}
		
		Map<Pair<Integer>, Double> result = new HashMap<Pair<Integer>, Double>();
		
		for(Entry<Pair<Integer>, Integer> entry: similarities.entrySet()) {
			double nbOccurrences = entry.getValue();
			Pair<Integer> documentIndices = entry.getKey();
			int size0 = documents.get(documentIndices.get(0)).size();
			int size1 = documents.get(documentIndices.get(1)).size();
			double similarity = nbOccurrences / (size0 + size1 - nbOccurrences);
			result.put(documentIndices, similarity);
		}
		
		return result;
	}

}
