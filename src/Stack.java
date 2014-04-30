
/**
	 * @author Eunice Esomonu
	 *A stack interface can determine the size of the stack.
	 *Also dertimine whether that the stack is empty, to push items, and to peek at the top item.
	 * 
	 */
	public interface Stack<T> {

		/*
		 * Adds the given item to the top of the stack.
		 */
		public void push(T data);
		
		/*
		 *  Removes the top item from the stack and returns it.
		 */
		public T pop();
		
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

