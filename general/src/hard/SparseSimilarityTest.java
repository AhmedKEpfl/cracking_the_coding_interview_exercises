package hard;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SparseSimilarityTest {

	@Test
	public void test() {
		Map<Integer, Set<Integer>> documents = new HashMap<Integer, Set<Integer>>();
		int[][] words = new int[][]{
				{13, 14, 15, 100, 9, 3},
				{16, 32, 1, 9, 3, 5},
				{19, 15, 29, 2, 6, 8, 7},
				{24, 7, 10}
		};
		for(int[] wordsEntry: words) {
			Set<Integer> wordsCurrent = new HashSet<Integer>();
			for(int i = 1; i < wordsEntry.length; i++) {
				wordsCurrent.add(wordsEntry[i]);
			}
			documents.put(wordsEntry[0], wordsCurrent);
		}
		
		Map<Pair<Integer>, Double> result = SparseSimilarity_17_26.getSimilarities(documents);
		System.out.println(result);
		assertEquals(3, result.size());
		assertTrue(0.25 == result.get(new Pair<Integer>(13, 16)));
	}

}
