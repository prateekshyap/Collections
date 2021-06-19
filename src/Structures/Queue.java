package Structures;

public interface Queue<Type> extends Structures<Type>
{
	//default methods of Structures interface
	public int size();
	public boolean isEmpty();	
	public boolean add(Type t);
	public void print();
		
	//new methods of Queue interface
	public boolean offer(Type t);
	public Type remove();
	public Type poll();
	public Type element();
	public Type peek();
}