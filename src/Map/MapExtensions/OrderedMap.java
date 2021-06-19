package Map.MapExtensions;

import Map.Map;
import Structures.Structures;
import Structures.Set;

public interface OrderedMap<KeyType,ValueType> extends Map<KeyType, ValueType>
{
	public OrderedMap<KeyType, ValueType> subMap(KeyType key1, KeyType key2);
	public OrderedMap<KeyType, ValueType> headMap(KeyType key);
	public OrderedMap<KeyType, ValueType> tailMap(KeyType key);
	public KeyType firstKey();
	public KeyType lastKey();
	public Set<KeyType> keySet();
	public Structures<ValueType> values();
}
