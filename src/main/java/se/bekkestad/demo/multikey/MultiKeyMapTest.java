package se.bekkestad.demo.multikey;

public class MultiKeyMapTest {
	
	public static void main(String[] args) {
	
		NKeyMap<String, String> map = new NKeyHashMap<String, String>();
		
		for(int i = 0; i < 1000; i++){
			Double key1 = Math.random();
			String key2 = ""+Math.random();
			String value = "I am multi key value K1: '" + key1 + 
					"' and K2: '" + key2 + "' with value: '" + 
					System.currentTimeMillis() + "'";
			
			map.put(value, ""+key1, key2);
		}
		
		for( String value : map.values()){
			System.out.println(value);
		}
	}
}
