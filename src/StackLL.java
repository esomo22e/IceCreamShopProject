
public class StackLL<T> implements Stack<T> {

	protected LinkedList<T> list = new LinkedList<T>();
	
	
		
	@Override
	public void push(T data) {
		// TODO Auto-generated method stub
		list.insertFirst(data);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		T data = null;
		if(!isEmpty())
		{
			 data = list.getFirst();
			list.deleteFirst();
		}
		
		return data;
		
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		T data = null;
		if(!isEmpty()){
		 data = list.getFirst();
		}
		return data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	
}
