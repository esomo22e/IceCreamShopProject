
public interface Queue<T> {
	/*
	 * Adds the given item to the top of the stack.
	 */
	public void enqueue(T data);
	
	/*
	 *  Removes the top item from the stack and returns it.
	 */
	public T dequeue();
	
	/*
	 * Return the top item from the stack without popping it.
	 */
	public T peek();
	
	/*
	 * Returns the number of items currently in the stack.
	 */
	public int size();
	
	/*
	 * Returns whether the stack is empty or not. 
	 */
	public boolean isEmpty();
	
}
