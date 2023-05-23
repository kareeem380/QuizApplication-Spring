package ujfaA.springQuiz.entities;


public enum Role {

	USER("Basic"),
	PROFESSOR("Prof"),
	ADMINISTRATOR("Administrator");

	public final String name;
	
	Role(String name) {
		this.name = name;
	}

	public static Role fromShortName(String shortName ) {		
		return switch (shortName) {
			case "Prof"-> PROFESSOR;
			case "Administrator"-> ADMINISTRATOR;
			default -> USER;
		};
	}
}