package Stack;

import ArrayList.DynamicList;

public class Stack<Type> extends DynamicList<Type>
{
	private int top = -1;
	
	public Stack()
	{
		super();
	}
	
	public Type push(Type t)
	{
		if (top == super.size()-1) super.renovate();
		super.add(t);
		++top;
		return t;
	}
	
	public Type pop()
	{
		if (top == -1) return null;
		return super.get(top--);
	}
	
	public Type peek()
	{
		if (top == -1) return null;
		return super.get(top);
	}
	
	public boolean isEmpty()
	{
		if (top == -1) return true;
		return false;
	}
	
	public void print()
	{
		super.print();
	}
}
