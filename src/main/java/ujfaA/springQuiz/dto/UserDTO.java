package ujfaA.springQuiz.dto;

import java.time.LocalDateTime;

import lombok.Value;
import ujfaA.springQuiz.entities.Role;

@Value
public class UserDTO {

	String username;
	String email;
	String firstName;
	String lastName;
	Role role;
	LocalDateTime lastActive;
	
	
	public UserDTO(String username, String email, String firstName, String lastName, Role role, LocalDateTime lastActive) {
		
		this.username	= username;
		this.email		= email;
		this.firstName	= firstName;
		this.lastName	= lastName;
		this.role 		= role;
		this.lastActive = lastActive;
	}



}