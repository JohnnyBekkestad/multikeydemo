package se.bekkestad.demo.multikey;

public enum Specialities {
	JAVA("Java"), 
	DOTNET(".Net"), 
	SQL("SQL"), 
	NOSQL("NoSQL"), 
	MONGODB("MongoDB"),
	JAVASCRIPT("JavaScript"),
	NODEJS("NodeJS"),
	WEBSOCKETS("WebSockets"),
	SPRING("Spring");
	
	private String speciality;
	
	private Specialities(String speciality){
		this.speciality = speciality;
	}
	
	public String getSpeciality(){
		return this.speciality;
	}
}
