package se.bekkestad.demo.multikey;

import java.util.Set;

public class MultiKeyMapTest {
	
	public static void main(String[] args) {
		
		NKeyMap<String, String> map = new NKeyHashMap<String, String>();
		for(int i = 0; i < 3; i++){
			Double longitude = Math.random();
			String latitude = ""+Math.random();
			String height = ""+Math.random();
			
			String value = "I am multi key value longitude: '" + longitude + 
					"' latitude: '" + latitude + "' and height: '" + height + "' with value: '" + 
					System.currentTimeMillis() + "'";
			
			map.put(value, ""+longitude, latitude, height);
		}
		
		for( String value : map.values()){
			System.out.println(value);
		}
						
		for(Set<String> keys : map.keySet()){
			System.out.println("-------------- NEXT PAIR -------------");
			for(String key : keys){
				System.out.println("And my keys are " + key);
			}
			
		}
	}
}
