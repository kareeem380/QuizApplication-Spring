package ujfaA.springQuiz.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import ujfaA.springQuiz.dto.UserDTO;
import ujfaA.springQuiz.entities.User;

public interface UserRepository extends ListCrudRepository<User, Long> {
	public Boolean existsUserByUsername(String username);
	public boolean existsUserByEmail(String email);
	public Optional<User> findByUsername(String username);
	@Query("SELECT NEW ujfaA.springQuiz.dto.UserDTO(u.username, u.email, u.firstName, u.lastName, u.role, u.lastActive)"
			+ " FROM User u")
	public Set<UserDTO> getUsersInfo();
	public int countCorrectAnswers(String username);
	@Modifying
	@Query(nativeQuery = true,
		value = "DELETE FROM users_answers WHERE question_id = ?1")
	public void removeFromUsersAnswers(long questionId);
}