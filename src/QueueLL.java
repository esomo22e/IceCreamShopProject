/*
 * FIFO -First In First Out  which would remove the first thing that we have.
 */
public class QueueLL<T> implements Queue<T>{
	//create an instance of a linked list
	private LinkedList<T> list = new LinkedList<T>();
	
	@Override
	public void enqueue(T data) {
		// TODO Auto-generated method stub
		//insert the last 
		list.insertLast(data);
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		//the data is null
		T data = null;
		//if the queue is not empty
		if(!isEmpty())
		{
			//data will equal the get the first because you are peeking at the top of the stack
			 data = list.getFirst();
			 //delete from the list
			list.deleteFirst();
		}
		//return the data
		return data;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		//the data is null 
		T data = null;
		//if the queue is not empty
		if(!isEmpty()){
			//peek from the top of stack
		 data = list.getFirst();
		}
		//return the data
		return data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		//return the size
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//return the empty
		return list.isEmpty();
	}

}
