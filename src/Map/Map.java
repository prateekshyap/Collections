package Map;

import Structures.Structures;
import Structures.Set;

public interface Map<KeyType,ValueType>
{
	public int size();
	public boolean isEmpty();
	public boolean containsKey(KeyType key);
	public boolean containsValue(ValueType value);
	public ValueType get(KeyType key);
	public ValueType put(KeyType key, ValueType value);
	public ValueType remove(KeyType key);
	public void clear();
	public Set<KeyType> keySet();
	public Structures<ValueType> values();
	public ValueType putIfAbsent(KeyType key, ValueType value);
	public boolean remove(KeyType key, ValueType value);
	public boolean replace(KeyType key, ValueType oldValue, ValueType newValue);
	public ValueType replace(KeyType key, ValueType value);
}