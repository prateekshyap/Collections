package Structures;

public interface Structures<Type>
{
	public int size();
	public boolean isEmpty();
	public boolean contains(Type t);	
	public boolean add(Type t);
	public boolean remove(int index);
	public boolean remove(Type t);
	public boolean removeAll(Type t);
	public void clear();
	public void print();
}
