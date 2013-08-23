package se.bekkestad.demo.multikey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
	@SuppressWarnings("unchecked") 
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
	@SuppressWarnings("unchecked") 
	public V get(K... k) {		
		return map.get(addToSet(k));
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	@SuppressWarnings("unchecked") 
	public V put(V value, K... k) {
		return map.put(addToSet(k), value);
	}

	@Override
	@SuppressWarnings("unchecked") 
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

	@SuppressWarnings("unchecked") 
	@Override
	public Collection<V> values(K... k) {
								
		Set<V> retValue = new HashSet<V>();
		
		//Check if exact match
		//TODO: THIS DOES NOT WORK CORRECTLY
		//This should be per person not per record...
		//If one person has 100% hit then next record will be skipped
		//We should be able to return a collection of result, with varying stats.
		//there might be a few persons who are a direct match, and some other might
		//be less than direct match. 
		if(containsKey(k)){		
			retValue.add(get(k));			
			return retValue;
		} else{
			Map<K, List<Set<K>>> unwrapped = unwrapKeys();			
			for(K key : k){	
				if(unwrapped.containsKey(key)){
					List<Set<K>> list = unwrapped.get(key);
					for(Set<K> match : list){
						if(map.containsKey(match)){
							V object = map.get(match);
							retValue.add(object);
						} else {
							//TODO: this is where i would like to handle 
							//statistics on V instead of inside the V class itself
						}	
					}
				}
			}			
			return retValue; 
		}
		
	}
	
	@Override
	public Set<Set<K>> keySet() {
		return map.keySet();
	}
	
	@SuppressWarnings("unchecked") 
	private Set<K> addToSet(K... k){
		Set<K> set = new HashSet<K>();		
		for(K key : k){
			set.add(key);
		}		
		return set;
	}
	
	private Map<K, List<Set<K>>> unwrapKeys(){		
		Set<Set<K>> keys = keySet();	
		
		System.out.println("KEYSET: " + keys.toString());
		
		Map<K, List<Set<K>>> inner = new HashMap<K, List<Set<K>>>();		
		for(Set<K> set : keys){			
			for(K k : set){				
				if(!inner.containsKey(k)){					
					List<Set<K>> t = new ArrayList<Set<K>>();
					t.add(set);
					inner.put(k, t);					
				}else{
					List<Set<K>> t = inner.get(k);
					t.add(set);
					inner.put(k, t);
				}
			}						
		}						
		return inner;
	}
}
