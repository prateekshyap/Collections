package Structures;

public interface Set<Type>
{
	public int size();
	public boolean isEmpty();
	public boolean contains(Type t);
	public Object[] toArray();
	public boolean add(Type t);
	public boolean remove(Type t);
	public void clear();
}
