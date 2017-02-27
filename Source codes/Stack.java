public class Stack<T>
{
	private Node<T> first;
	
	public Stack()
	{
		first = null;
	}
	
	public T top()
	{
		return first.getValue();
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public void push(T value)
	{
		first = new Node<T>(value, first);
	}
	
	public T pop()
	{
		if(isEmpty()) return null;
		T temp = top();
		first = first.getNext();
		return temp;
	}
	
	public String toString()
	{
		String s = "[";
		Node<T> pos = first;
		while(pos!=null){
			if (pos.hasNext()) s+=pos.getValue()+", ";
			else s+=pos.getValue();
			pos = pos.getNext();
		}
		return s+"]";
	}
}