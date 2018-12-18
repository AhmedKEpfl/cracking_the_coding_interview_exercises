import java.util.NoSuchElementException;


public class Queue<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item) {
		QueueNode<T> newNode = new QueueNode<T>(item);
		if(last != null) {
			last.next = newNode;
		}
		last = newNode;
		if(first == null) {
			first = newNode;
		}
	}
	
	public void remove() {
		if(first == null) {
			throw new NoSuchElementException();
		} else if(first == last) {
			first = null;
			last = null;
		} else {
			QueueNode<T> next = first.next;
			first = next;
		}
	}
	
	public boolean isEmpty() {
		return first != null;
	}
}
