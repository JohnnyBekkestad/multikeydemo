package se.bekkestad.demo.multikey;

import java.util.Collection;

public class MultiKeySearchTest {
	
	public static void main(String[] args) {
					
		MultiKeySearchTest test = new MultiKeySearchTest();

		//Initialize the Map
		NKeyMap<String, Person> map = test.initializeTheMap();
		
		//This is what we are looking for
		String[] filter = test.getFilter();
		
		//Do the search
		Collection<Person> results = map.values(filter);
		
		//Print the results
		test.printResults(results);		
	}
	
	private NKeyMap<String, Person> initializeTheMap(){
		
		NKeyMap<String, Person> map = new NKeyHashMap<String, Person>();
		
		Person[] persons =  {
				new Person("Johnny", 
					Specialities.JAVA.getSpeciality(), 
					Specialities.JAVASCRIPT.getSpeciality(), 
					Specialities.NODEJS.getSpeciality(),
					Specialities.NOSQL.getSpeciality(),
					Specialities.MONGODB.getSpeciality(),
					Specialities.WEBSOCKETS.getSpeciality(),
					Specialities.SPRING.getSpeciality()),
				new Person("Jane", 
					Specialities.JAVA.getSpeciality(), 
					Specialities.NODEJS.getSpeciality(),
					Specialities.MONGODB.getSpeciality(),
					Specialities.SPRING.getSpeciality()),
				new Person("Wayne", 
					Specialities.JAVA.getSpeciality(), 
					Specialities.SPRING.getSpeciality()),
				new Person("Ann", 
					Specialities.SQL.getSpeciality()),
				new Person("Pam",  
					Specialities.JAVASCRIPT.getSpeciality(),
					Specialities.NOSQL.getSpeciality(),
					Specialities.MONGODB.getSpeciality()),
				new Person("Ruth", 
					Specialities.NOSQL.getSpeciality(),
					Specialities.MONGODB.getSpeciality(),
					Specialities.WEBSOCKETS.getSpeciality())	
			};

		try{
			for(Person person : persons){
				Collection<String> arrayOfSpecialities = person.getKeys();	
				String[] array = (String[])(arrayOfSpecialities.toArray(new String[arrayOfSpecialities.size()]));				
				map.put(person, array);				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return map;
	}
	
	private String[] getFilter(){
		String[] filter = {				 
				Specialities.NOSQL.getSpeciality(),
				Specialities.JAVASCRIPT.getSpeciality(),
				Specialities.SQL.getSpeciality()};
		
		return filter;
	}
	
	private void printResults(Collection<Person> results){
		System.out.println("FOUND " + results.size() + " match" + (results.size()==1?"":"es"));
		
		for(Person person : results){
			System.out.println(person.getName() + " is a " + person.getMatch(getFilter()) + " Match ");
		}
	}
}
