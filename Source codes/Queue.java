public class Queue<T>
{
    private Node<T> first;
    private Node<T> last;

    public Queue()
    {
        this.first=null;
        this.last=null;
    }

    public boolean isEmpty()
    {
        return this.first==null &&this.last==null;
    }
 
    public void insert(T x)
    {
          Node<T> temp=new Node<T>(x);
          if(first==null)
               first=temp;
          else
               last.setNext(temp);
          last=temp;
}

    public T remove()
    {
        T x =this.first.getValue();
        this.first=this.first.getNext();
        if (this.first==null)
               this.last=null;
        return x;
    }

     public T head()
    {
        return this.first.getValue();
    }

    public String toString()
    {
        String str="[";
        Node<T> pos =this.first;
        while (pos!=null)
        {
                str=str+pos.getValue().toString();
                if (pos.getNext() != null)
                    str=str+",";
                pos=pos.getNext();
       }
       str=str+"]";
       return str;
    }
}