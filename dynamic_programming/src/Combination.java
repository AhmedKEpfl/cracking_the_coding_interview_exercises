import java.util.Arrays;


public class Combination {
	private int[] occurrences;
	
	public Combination() {
		occurrences = new int[]{0, 0, 0, 0};
	}
	
	public Combination(Combination source, int indexAdd, int nbAdd) {
		occurrences = (int[])source.occurrences.clone();
		occurrences[indexAdd] += nbAdd;
	}
	
	public Combination(Combination source, int indexAdd) {
		this(source, indexAdd, 1);
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		
		if(!( other instanceof Combination)) {
			return false;
		}
		
		Combination that = (Combination)other;
		return Arrays.equals(occurrences, that.occurrences);
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.occurrences);
	}
	
	@Override
	public int hashCode() {
		int sum = 0;
		for(int i = 0; i < occurrences.length; i++) {
			sum += Math.pow(2, occurrences[i]);
		}
		return sum;
	}
}
