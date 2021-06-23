package LinkedList;

import Structures.List;
import Structures.Queue;

public class LinkedList<Type> implements Queue<Type>, List<Type> {
	class Node
	{
		Node prev;
		Object obj;
		Node next;
		Node(Object ob)
		{
			obj = (Type)ob;
		}
	}

	private int size;
	private	Node head, tail;
	
	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	//common methods
	public int size() { return size; }
	public boolean isEmpty() { return size == 0 ? true : false; }
	public boolean add(Type t) { return addLast(t); }
	
	public void print()
	{
		System.out.print("[");
		Node temp = head;
		for (int i = 0; i < size; ++i)
		{
			System.out.print(temp.obj);
			if (i != size-1) System.out.print("->");
			temp = temp.next;
		}
		System.out.println("]");
	}
	
	//For Queue
	public boolean offer(Type t) { return add(t); }
	
	public boolean offerFirst(Type t)
	{
		addFirst(t);
		return true;
	}
	
	public boolean offerLast(Type t)
	{
		addLast(t);
		return true;
	}
	
	public Type remove()
	{
		if (size == 0)
			throw new NullPointerException("Empty");
		if (size == 1)
		{
			Node returnNode = head;
			head = tail = null;
			size = 0;
			return (Type)returnNode.obj;
		}
		Node returnNode = head;
		head = head.next;
		head.prev = null;
		--size;
		return (Type)returnNode.obj;
	}
	public Type poll()
	{
		if (size == 0)
			return null;
		if (size == 1)
		{
			Node returnNode = head;
			head = tail = null;
			size = 0;
			return (Type)returnNode.obj;
		}
		Node returnNode = head;
		head = head.next;
		head.prev = null;
		--size;
		return (Type)returnNode.obj;
	}
	public Type element()
	{
		if (size == 0) 
			throw new NullPointerException("Empty");
		return (Type)head.obj;
	}
	public Type peek()
	{
		if (size == 0) return null;
		return (Type)head.obj;
	}
	
	//For List
	public boolean contains(Type t)
	{
		Node temp = head;
		for (int i = 0; i < size; ++i)
		{
			if (temp.obj.equals(t)) return true;
			temp = temp.next;
		}
		return false;
	}
	
	public boolean remove(int index)
	{
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("");
		Node node = getNode(index);
		return removeNode(node);
	}
	
	public boolean remove(Type t) { return removeNode(getNode(t)); }
	
	public boolean removeAll(Type t)
	{
		int prev = size;
		while (remove(t));
		if (prev == size)
			return false;
		return true;
	}
	
	public void clear()
	{
		head = tail = null;
		size = 0;
	}
	
	public boolean set(int index, Type t)
	{
		if (index >= size || index < 0) 
			throw new IndexOutOfBoundsException("");
		Node toBeReplaced = getNode(index);
		toBeReplaced.obj = (Type)t;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public Type get(int index)
	{
		if (index >= size || index < 0) 
			throw new IndexOutOfBoundsException("");
		Node toBeReturned = getNode(index);
		return (Type)toBeReturned.obj;
	}
	
	public boolean add(int index, Type t)
	{
		if (index >= size || index < 0) 
			throw new IndexOutOfBoundsException("");
		Node currentIndex = getNode(index);
		System.out.println(currentIndex.obj);
		linkBefore(t,currentIndex);
		return true;
	}
	
	public int indexOf(Type t)
	{
		Node temp = head;
		for (int i = 0; i < size; ++i)
		{
			if (temp.obj.equals(t)) return i;
			temp = temp.next;
		}
		return -1;
	}
	
	public int lastIndexOf(Type t)
	{
		Node temp = tail;
		for (int i = size-1; i >= 0; --i)
		{
			if (temp.obj.equals(t)) return i;
			temp = temp.prev;
		}
		return -1;
	}
	
	//new methods of LinkedList
	public void linkLast(Type t) { addLast(t); }
	
	public void linkBefore(Type t, Node node)
	{
		Node newNode = new Node(t);
		newNode.next = node;
		newNode.prev = node.prev;
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;
		++size;
	}
	
	@SuppressWarnings("unchecked")
	public Type getFirst()
	{
		if (head == null) return null;
		return (Type)head.obj;
	}
	
	@SuppressWarnings("unchecked")
	public Type getLast()
	{
		if (tail == null) return null;
		return (Type)tail.obj;
	}
	
	@SuppressWarnings("unchecked")
	public Type removeFirst()
	{
		if (size == 0)
			throw new NullPointerException("");
		if (size == 1)
		{
			Node returnNode = head;
			head = tail = null;
			size = 0;
			return (Type)returnNode.obj;
		}
		Node returnNode = head;
		head = head.next;
		head.prev = null;
		--size;
		return (Type)returnNode.obj;
	}
	
	@SuppressWarnings("unchecked")
	public Type removeLast()
	{
		if (tail == null)
			throw new NullPointerException("");
		if (size == 1)
		{
			Node returnNode = head;
			head = tail = null;
			size = 0;
			return (Type)returnNode.obj;
		}
		Node returnNode = tail;
		tail = tail.prev;
		tail.next = null;
		--size;
		return (Type)returnNode.obj;
	}
	
	public void addFirst(Type t)
	{
		if (head == null)
		{
			head = new Node(t);
			tail = head;
		}
		else
		{
			Node newNode = new Node(t);
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		++size;
	}
	
	public void addLast(Type t)
	{
		if (tail == null)
		{
			tail = new Node(t);
			head = tail;
		}
		else
		{
			Node newNode = new Node(t);
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		++size;
	}
	
	@SuppressWarnings("unchecked")
	public Type peekFirst()
	{
		if (size == 0) return null;
		return (Type)head.obj;
	}
	
	@SuppressWarnings("unchecked")
	public Type peekLast()
	{
		if (size == 0) return null;
		return (Type)tail.obj;
	}
	
	public Type pollFirst()
	{
		if (size == 0) return null;
		return removeFirst();
	}
	
	public Type pollLast()
	{
		if (size == 0) return null;
		return removeLast();
	}
	
	public boolean removeFirstOccurrence(Type t) { return removeNode(getNode(t)); }
	public boolean removeLastOccurrence(Type t) { return removeNode(getLastNode(t)); }
	
	private Node getNode(int index)
	{
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("");
		Node temp = head;
		for (int i = 0; i < index; ++i)
			temp = temp.next;
		return temp;
	}
	
	private Node getLastNode(Type t)
	{
		Node temp = tail;
		for (int i = size-1; i >= 0; --i)
		{
			if (temp.obj.equals(t)) return temp;
			temp = temp.prev;
		}
		return null;
	}
	
	private Node getNode(Type t)
	{
		Node temp = head;
		for (int i = 0; i < size; ++i)
		{
			if (temp.obj.equals(t)) return temp;
			temp = temp.next;
		}
		return null;
	}
	
	private boolean removeNode(Node toBeRemoved)
	{
		if (toBeRemoved == null) return false;
		if (size == 1)
		{
			head = tail = null;
			size = 0;
			return true;
		}
		if (toBeRemoved == head)
		{
			head = head.next;
			head.prev = null;
		}
		else if (toBeRemoved == tail)
		{
			tail = tail.prev;
			tail.next = null;
		}
		else
		{
			toBeRemoved.prev.next = toBeRemoved.next;
			toBeRemoved.next.prev = toBeRemoved.prev;
			toBeRemoved = null;
		}
		--size;
		return true;
	}
}
