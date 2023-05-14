package pl.trading.trading.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.trading.trading.entity.User;
import pl.trading.trading.service.UserService;

@Controller
class AuthenticationController {

    private final UserService userService;

    AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/home")
    String home() {
        return "home";
    }
    @GetMapping(path = "/login")
    String login() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "home";
    }
    @GetMapping(path = "/registration")
    String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(path = "/registration")
    String processAddUserForm(@ModelAttribute("user")User user, BindingResult errors) {

        if (errors.hasErrors()) {
            return "registration";
        }
        userService.save(user);


        return "redirect:/login";
    }
}