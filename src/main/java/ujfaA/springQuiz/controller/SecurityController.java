package ujfaA.springQuiz.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ujfaA.springQuiz.entities.Role;
import ujfaA.springQuiz.entities.User;
import ujfaA.springQuiz.service.UserService;

@Controller
public class SecurityController {
	
	@Autowired
	private UserService userService;
	@GetMapping("/registration")
	public String registration(ModelMap model) {
		User user = new User();
	    model.addAttribute(user);
	    return "registration";
	}
	@PostMapping("/registration")
	public String addNewUser( @Valid @ModelAttribute("user") User newUser,
							ModelMap model, RedirectAttributes redirectAttributes) {
		try {
			userService.register(newUser);
			redirectAttributes.addFlashAttribute("message", "Compte ajouté");
			return "redirect:/home";
		} catch (Exception e) {
			model.addAttribute("user", newUser);
			model.addAttribute("message", "There is error");
			return "registration";

		}
	}
	@GetMapping("/login")
	public String login(@RequestParam(defaultValue = "false") boolean error, ModelMap model) {
		if (error == true)
			model.addAttribute("message", "Mdp incorrect");
		return "login";
	}
	
}
