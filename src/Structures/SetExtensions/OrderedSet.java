package Structures.SetExtensions;

import Structures.Set;

public interface OrderedSet<Type> extends Set<Type> {
	public OrderedSet<Type> subSet(Type t, Type u);
	public OrderedSet<Type> headSet(Type t);
	public OrderedSet<Type> tailSet(Type t);
	public Type first();
	public Type last();
}
