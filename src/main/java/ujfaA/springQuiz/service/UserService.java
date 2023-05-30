package ujfaA.springQuiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ujfaA.springQuiz.entities.User;
import ujfaA.springQuiz.dto.QuestionDTO;
import ujfaA.springQuiz.dto.UserDTO;
import ujfaA.springQuiz.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
    private PasswordEncoder bCryptPasswordEncoder;
	public boolean usernameIsAvaible(String username) {
		return ( ! userRepo.existsUserByUsername(username));
	}
	public boolean emailIsAvaible(String email) {
		return ( ! userRepo.existsUserByEmail(email));
	}
	public User getUser(String username) {
		return userRepo.findByUsername(username).orElseThrow();
	}
	public User register(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	public User update(User user) {
		return userRepo.save(user);
	}
	public Set<UserDTO> getUsersInfo() {
		return userRepo.getUsersInfo();
	}
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	public int getScore(String username) {
		return userRepo.countCorrectAnswers(username);
	}
	public void removeFromUsersAnswers(long questionId) {
		userRepo.removeFromUsersAnswers(questionId);
	}
}
