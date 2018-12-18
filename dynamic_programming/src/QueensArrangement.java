import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class QueensArrangement {

	private int[] positions;
	
	public QueensArrangement() {
		positions = new int[8];
		Arrays.fill(positions, -1);
	}
	
	public QueensArrangement(int[] positions) {
		this.positions = positions.clone();
	}
	
	public static boolean aligned(int i1, int i2) {
		int row1 = i1 / 8, col1 = i1 % 8;
		int row2 = i2 / 8, col2 = i2 % 8;
		return row1 == row2 || col1 == col2 ||
				(row2 - row1 == col2 - col1) ||
				(row2 - row1 == col1 - col2);
	}
	
	public boolean isValid() {
		int index = Arrays.asList(positions).indexOf(-1);
		if(index == -1) {
			index = 8;
		}
		for(int i = 0; i < index; i++) {
			for(int j = 0; j < index; j++) {
				if(!aligned(positions[i], positions[j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static Set<Integer> getSet(int[] array) {
		Set<Integer> result = new HashSet<Integer>();
		for(int i = 0; i < array.length; i++) {
			result.add(array[i]);
		}
		return result;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		
		if(!(other instanceof QueensArrangement)) {
			return false;
		}
		
		QueensArrangement that = (QueensArrangement)other;
		Set<Integer> thisSet = getSet(positions);
		Set<Integer> thatSet = getSet(that.positions);
		return thisSet.equals(thatSet);
	}
	
	@Override
	public int hashCode() {
		int sum = 0;
		for(int i = 0; i < positions.length; i++) {
			sum += (positions[i] * positions[i]);
		}
		return sum;
	}
	
	public List<QueensArrangement> addQueen() {
		List<QueensArrangement> result = new ArrayList<QueensArrangement>();
		int index = -1;
		for(int i = 0; i < positions.length; i++) {
			if(positions[i] == -1) {
				index = i;
			}
		}
		if(index == -1) {
			result.add(this);
		} else {
			for(int i = 0; i < 64; i++) {
				QueensArrangement testArr = new QueensArrangement(positions);
				testArr.positions[index] = i;
				if(testArr.isValid()) {
					result.addAll(testArr.addQueen());
				}
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return getSet(positions).toString();
	}
}
