package se.bekkestad.demo.multikey;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;




public class NKeyHashMap<K, V> implements NKeyMap<K, V> {

	private Map<Set<K>, V> map;
	
	public NKeyHashMap(){
		map = new HashMap<Set<K>, V>();
	}
	
	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean containsKey(K... k) {
		Set<Set<K>> keys =  map.keySet();

		Set<K> pair = addToSet(k);		
		return keys.contains(pair);
	}

	@Override
	public boolean containsValue(V value) {
		return map.containsValue(value);
	}

	@Override
	public V get(K... k) {		
		return map.get(addToSet(k));
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public V put(V value, K... k) {
		return map.put(addToSet(k), value);
	}

	@Override
	public V remove(K... k) {
		return map.remove(addToSet(k));
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public Set<Set<K>> keys() {
		return map.keySet();
	}
	
	private Set<K> addToSet(K... k){
		Set<K> set = new HashSet<K>();
		
		for(K key : k){
			set.add(key);
		}
		
		return set;
	}
}
