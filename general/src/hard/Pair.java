package hard;

public class Pair<T> {
	private T value1, value2;
	
	public Pair(T value1, T value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public T get(int index) {
		if(index > 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return index == 0 ? value1 : value2;
	}
	
	@Override
	public int hashCode() {
		return value1.hashCode() * value1.hashCode() + value2.hashCode() * value2.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		
		if(!(other instanceof Pair<?>)) {
			return false;
		}
		Pair<T> pairOther = (Pair<T>)other;
		return (this.value1.equals(pairOther.value1) && this.value2.equals(pairOther.value2)) || 
				(this.value1.equals(pairOther.value2) && this.value2.equals(pairOther.value1));
	}
}
