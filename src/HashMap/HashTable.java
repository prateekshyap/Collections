package HashMap;

import Map.Map;
import Structures.Set;
import Structures.Structures;

import java.util.Arrays;

public class HashTable<KeyType,ValueType> implements Map<KeyType,ValueType> {

	private int size = 0, capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] keys, values;
	private int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719 }; //128 prime numbers
    private int[] status;
    private int probeFactor;
	
	public HashTable()
	{
		keys = new Object[DEFAULT_CAPACITY];
		values = new Object[DEFAULT_CAPACITY];
		status = new int[DEFAULT_CAPACITY];
		probeFactor = (int)(DEFAULT_CAPACITY*0.2);
		capacity = DEFAULT_CAPACITY;
	}
	
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size == 0 ? true : false;
	}
	public boolean containsKey(KeyType key)
	{
		int index = getHash(key);
        if (status[index] == 1 && keys[index].equals(key))
            return true;
        int probe = 2;
        for (int i = 0; i < probeFactor; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && keys[index].equals(key))
                return true;
        }
        while (index < capacity && (status[index] == 1 || status[index] == 2))
        {
            if (status[index] == 1 && keys[index].equals(key))
                return true;
            ++index;
        }
        return false;
	}
	public boolean containsValue(ValueType value)
	{
		return false;
	}
	@SuppressWarnings("unchecked")
	public ValueType get(KeyType key)
	{
		int index = getHash(key);
        if (status[index] == 1 && keys[index].equals(key))
            return (ValueType)values[index];
        int probe = 2;
        for (int i = 0; i < probeFactor; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && keys[index].equals(key))
                return (ValueType)values[index];
        }
        while (index < capacity && (status[index] == 1 || status[index] == 2))
        {
            if (status[index] == 1 && keys[index].equals(key))
                return (ValueType)values[index];
            ++index;
        }
        return null;
	}
	public ValueType put(KeyType key, ValueType value)
	{
		 	remove(key);
		 	if (size == capacity)
				renovate();
	        int index = getHash(key);
	        if (status[index] != 1)
	        {
	            status[index] = 1;
	            keys[index] = (KeyType)key;
	            values[index] = (ValueType)value;
	            ++size;
	            return value;
	        }
	        int probe = 2;
	        for (int i = 0; i < probeFactor; ++i)
	        {
	            index += probe;
	            index %= capacity;
	            probe <<= 1;
	            if (status[index] != 1)
	            {
	                status[index] = 1;
	                keys[index] = (KeyType)key;
	                values[index] = (ValueType)value;
	                ++size;
	                return value;
	            }
	        }
	        while (status[++index] == 1);
	        status[index] = 1;
	        keys[index] = (KeyType)key;
	        values[index] = (ValueType)value;
	        ++size;
	        return value;
	}
	
	@SuppressWarnings("unchecked")
	public ValueType remove(KeyType key)
	{
		int index = getHash(key);
        if (status[index] == 1 && keys[index].equals(key))
        {
            status[index] = 2;
            --size;
            return (ValueType)values[index];
        }
        int probe = 2;
        for (int i = 0; i < probeFactor; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && keys[index].equals(key))
            {
                status[index] = 2;
                --size;
                return (ValueType)values[index];
            }
        }
        while (index < capacity && (status[index] == 1 || status[index] == 2))
        {
            if (keys[index].equals(key))
            {
                status[index] = 2;
                --size;
                return (ValueType)values[index];
            }
            ++index;
        }
        return null;
	}
	public void clear()
	{
		
	}
	public Set<KeyType> keySet()
	{
		return null;
	}
	public Structures<ValueType> values()
	{
		return null;
	}
	public ValueType putIfAbsent(KeyType key, ValueType value)
	{
		return null;
	}
	public boolean remove(KeyType key, ValueType value)
	{
		return false;
	}
	public boolean replace(KeyType key, ValueType oldValue, ValueType newValue)
	{
		return false;
	}
	public ValueType replace(KeyType key, ValueType value)
	{
		return null;
	}
    
    private int getHash(KeyType key)
    {
        String str = String.valueOf(key);
        double sum = 0;
        for (int i = 0; i < str.length(); ++i)
        {
        	int ascii = (int)(str.charAt(i));
            sum += (ascii)*(primes[ascii]);
            sum %= Integer.MAX_VALUE;
        }
        return ((int)sum)%capacity;
    }
    
    protected void renovate()
	{
		capacity *= 2;
		keys = Arrays.copyOf(keys,capacity);
		values = Arrays.copyOf(values,capacity);
		status = Arrays.copyOf(status,capacity);
	}
}
