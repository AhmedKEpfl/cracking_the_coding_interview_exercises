package hard;

public class Pair<T> {
	private T value1, value2;
	
	public Pair(T value1, T value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	@Override
	public int hashCode() {
		return value1.hashCode() + value2.hashCode() * value2.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		
		if(!(other instanceof Pair<?>)) {
			return false;
		}
		
		return this.value1.equals(value1) && this.value2.equals(value2);
	}
}
