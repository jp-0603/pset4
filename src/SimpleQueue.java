import java.util.NoSuchElementException;

public class SimpleQueue {
	
	private String[] array;
	private final int capacity;
	private int top;
	private int bottom;
	
	public SimpleQueue(int capacity) { //constructor
		if(capacity <= 0) {
			throw new IllegalArgumentException();
		}
		this.capacity = capacity;
		array = new String[capacity];
		
		top = -1;
		bottom = -1;
	}
	
	public boolean add(String given) {
		if (given == null) {
			throw new NullPointerException();
		}
		if (top + 1 == capacity) {
			throw new IllegalStateException("Queue full");
		}
		top +=1;
		bottom = 0;
		for (int k = top - 1; k >= 0; k--) {
			array[k + 1] = array[k];
		}
		array[0] = given;
		return true;
	}
	
	public void clear() {
		for (int k = 0; k < top + 1; k++) {
			array[k] = null;
			top = -1;
			bottom = -1;
		}
	}
	
	public boolean contains(String input) {
		for (int k = 0; k < top + 1; k++) {
			if(array[k].equals(input)) {
				return true;
			}
		}
		return false;
	}
	
	public String element() {
		if (bottom == -1) {
			throw new NoSuchElementException();
		}
		return array[top];
	}
	
	public boolean offer(String input) {
		if (top + 1 == capacity) {
			return false;
		}
		
		return add(input);
	}
	
	public String peek() {
		if (bottom == -1) {
			return null;
		}
		
		return array[top];
	}
	
	public String poll() {
		if (bottom == -1) {
			return null;
		}
		
		return remove();
	}
	public int remainingCapacity() {
		return capacity - (top + 1);
	}
	
	public String remove() {
		if (bottom == -1) {
			throw new NoSuchElementException();
		}
		String temporary = array[top];
		array[top] = null;
		top--;
		return temporary;
	}
	public boolean remove(String given) {
		int index = -1;
		for (int k = 0; k < top + 1; k++) {
			if(array[k].equals(given)) {
				index = k;
			}
		}
		if (index == -1) {
			return false;
		}
		for (int m = index; m < top + 1; m++) {
			array[m] = array[m+1];
		}
		top--;
		return true;
	}
	public int size() {
		return top+1;
	}
	public String toString() {
		String change = "[";
		
		for (int k = top; k > 0; k--) {
			change += array[k];
			change += ", ";
		}
		
		if (bottom != -1) change += array[0];
		change += "]";
		return change;
	}
}
