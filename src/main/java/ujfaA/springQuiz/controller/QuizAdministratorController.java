package ujfaA.springQuiz.controller;


import java.security.Principal;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ujfaA.springQuiz.dto.QuestionDTO;
import ujfaA.springQuiz.entities.Question;
import ujfaA.springQuiz.service.QuestionService;
import ujfaA.springQuiz.service.QuizService;
import ujfaA.springQuiz.service.UserService;

@Controller
public class QuizAdministratorController {
		
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuizService quizService;
	@GetMapping("/questions")
	public String getQuestions(ModelMap model) {		
		model.addAttribute("questions", questionService.listAll());
		return "questions";
	}
	@GetMapping("/questions/new")
	public String newQuestion(
			@ModelAttribute Question question,
			ModelMap model) {
		return "newQuestion";
	}
	@PostMapping("/questions/new")
	public String addQuestion(@Valid Question question, BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttrs) {
			questionService.save(question);
		return "redirect:/questions";
	}
	@PostMapping("/questions/delete")
	public String removeQuestion(@RequestParam long qId) {
			quizService.removeQuestion(qId);
		return "redirect:/questions" ;
	}
	@GetMapping("/users")
	public String getUsersInfo(ModelMap model) {
		model.addAttribute("users", userService.getUsersInfo());
		return "usersInfo";
	}
}
