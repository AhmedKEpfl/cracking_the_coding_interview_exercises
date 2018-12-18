package dynamic_programming_recursion;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class EightQueens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArrangements();
	}
	
	public static void printArrangements() {
		QueensArrangement arr = new QueensArrangement();
		List<QueensArrangement> arrangements = arr.addQueen();
		Set<QueensArrangement> result = new HashSet<QueensArrangement>(arrangements);
		System.out.println(result);
	}

}
