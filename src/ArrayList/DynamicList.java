package ArrayList;

import java.util.Arrays;
import Structures.List;

public class DynamicList<Type> implements List<Type>
{
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;

	public DynamicList()
	{
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0 ? true : false;
	}
	
	public boolean contains(Type t)
	{
		for (int i = 0; i < size; ++i)
			if (elements[i].equals(t))
				return true;
		return false;
	}

	public boolean add(Type t)
	{
		if (size == elements.length)
			renovate();
		elements[size++] = (Type)t;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean remove(int index)
	{
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		slide(index,"L");
		return true;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public boolean remove(Type t)
	{
		int index = indexOf(t);
		if (index == -1) return false;
		slide(index,"L");
		return true;
	}
	
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
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public void print()
	{
		System.out.print("[ ");
		for (int i = 0; i < size; ++i)
			System.out.print(elements[i]+" ");
		System.out.println("]");
	}
	
	public boolean set(int index, Type t)
	{
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		elements[index] = (Type)t;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public Type get(int index)
	{
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		return (Type)elements[index];
	}
	
	public boolean add(int index, Type t)
	{
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		if (size == elements.length)
			renovate();
		slide(index,"R");
		elements[index] = (Type)t;
		return true;
	}
	
	public int indexOf(Type t)
	{
		for (int i = 0; i < size; ++i)
			if (elements[i].equals(t))
				return i;
		return -1;
	}
	
	public int lastIndexOf(Type t)
	{
		for (int i = size-1; i >= 0; --i)
			if (elements[i].equals(t))
				return i;
		return -1;
	}
	
	protected void renovate()
	{
		int newSize = elements.length*2;
		elements = Arrays.copyOf(elements,newSize);
	}
	
	private void slide(int index, String direction)
	{
		if (direction.equals("L"))
		{
			for (int i = index; i < size-1; ++i)
				elements[i] = elements[i+1];
			--size;
		}
		else if (direction.equals("R"))
		{
			for (int i = size; i > index; --i)
				elements[i] = elements[i-1];
			++size;
		}
	}
}
