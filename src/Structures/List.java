package Structures;

public interface List<Type> extends Structures<Type>
{
	
	//default methods of Structures interface
	public int size();
	public boolean isEmpty();
	public boolean contains(Type t);	
	public boolean add(Type t);
	public boolean remove(int index);
	public boolean remove(Type t);
	public boolean removeAll(Type t);
	public void clear();
	public void print();
	
	//new methods of List interface
	public boolean set(int index, Type t);
	public Type get(int index);
	public boolean add(int index, Type t);
	public int indexOf(Type t);
	public int lastIndexOf(Type t);
}
