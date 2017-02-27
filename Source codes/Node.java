public class Node<T>
{
	private T value;
	private Node<T> next;

	public Node(T value)
	{
		this.value = value;
		this.next = null;
	}

	public Node(T value, Node<T> next)
	{
		this. value = value;
		this.next = next;
	}

	public T getValue ()
	{
		return  this.value;
	}

	public boolean hasNext()
	{
		return this.next!=null;
	}

	public void setValue (T value)
	{
		this. value = value;
	}

	public Node<T> getNext()
	{   
		return next;
	}

	public void setNext(Node<T>  next)
	{
		this.next = next;
	}

	public String toString()
	{
		return value + " --> " + next;
	}
	
	/**
	 * Constructs a list with random values
	 * @param listSize- the size of the list
	 * @param numSize- the maximum size of the random values
	 * @return the List
	 */
	public static Node<Integer> buildList(int listSize, int numSize)
	{
		Node<Integer> n= new Node<Integer>((int)(Math.random()*(numSize))+1);
		for(int i=1; i<listSize; i++)
			n= new Node<Integer>((int)(Math.random()*(numSize))+1, n);
		return n;
	}
}
