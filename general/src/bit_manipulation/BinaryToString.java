package bit_manipulation;

public class BinaryToString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static String binary(double number) {
		if(number < 0 || number >= 1) {
			throw new IllegalArgumentException();
		}
		if(number == 0) {
			return "0";
		}
		
		double currentDivider = 0.5;
		String result = "0.";
		for(int i = 0; i < 32; i++) {
			if(number >= currentDivider) {
				number -= currentDivider;
				result += "1";
			} else {
				result += "0";
			}
			
			currentDivider /= 2;
			
			if(number == 0) {
				return result;
			}
		}
		return "ERROR";
	}

}
