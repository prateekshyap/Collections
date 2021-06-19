package Structures.QueueExtensions;

import Structures.Queue;

public interface Dequeue<Type> extends Queue<Type>
{
	public void addFirst(Type t);
	public void addLast(Type t);
	public boolean offerFirst(Type t);
	public boolean offerLast(Type t);
	public Type removeFirst();
	public Type removeLast();
	public Type pollFirst();
	public Type pollLast();
	public Type getFirst();
	public Type getLast();
	public Type peekFirst();
	public Type peekLast();
	public boolean removeFirstOccurrence(Type t);
	public boolean removeLastOccurrence(Type t);
	public boolean add(Type t);
	public boolean offer(Type t);
	public Type remove();
	public Type poll();
	public Type element();
	public Type peek();
	public void push(Type t);
	public Type pop();
	public boolean remove(Type t);
	public boolean contains(Type t);
	public int size();
}
