package se.bekkestad.demo.multikey;

import java.util.Arrays;
import java.util.Collection;

public class Person {
	private String[]keys;
	private String name;
	private Double match = 1.0D;
	
	public Person(String name, String... keys){				
		this.keys = keys;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Collection<String> getKeys(){		
		return Arrays.asList(keys);
	}
	
	public Double getMatch(String... searchForKeys){	
		
		for(String searchForKey : searchForKeys){			
			int found = 0;
			for(String key : keys){
				if(searchForKey.equalsIgnoreCase(key)){
					found++;
				}
			}
			
			if(found == 0){
				match -= (1.0/searchForKeys.length);
			}
		}				
		return (double)Math.round((this.match)*100);
	}
}