package se.bekkestad.demo.multikey;

import java.util.Collection;
import java.util.Set;

public interface NKeyMap<K, V> {
	public void clear();
	@SuppressWarnings("unchecked")
	public boolean containsKey(K... k);
	public boolean containsValue(V value);
	@SuppressWarnings("unchecked") 
	public V get(K... k);
	public boolean isEmpty();
	@SuppressWarnings("unchecked") 
	public V put(V value, K... k);
	@SuppressWarnings("unchecked") 
	public V remove(K... k);
	public int size();
	public Collection<V> values();
	@SuppressWarnings("unchecked") 
	public Collection<V> values(K... k);
	public Set<Set<K>> keySet();
}