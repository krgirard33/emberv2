package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.User;
import com.nosin.emberv2.model.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserDao userDao;


    @RequestMapping(value = {"", "index"})
    public String index(Model model) {
        model.addAttribute("title", "Ember: Users");
        model.addAttribute("users", userDao.findAll());
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("title", "Create Account");
        model.addAttribute("user", new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute @Valid User user,
                          Errors errors, String confirm, HttpServletResponse response) {
        List<User> sameUsername = userDao.findByUsername(user.getUsername());

        if (!errors.hasErrors() && user.getPassword().equals(confirm) && sameUsername.isEmpty()) {
            model.addAttribute("user", user);
            userDao.save(user);

            Cookie chip = new Cookie("user", user.getUsername());
            chip.setPath("/");
            response.addCookie(chip);
            return "redirect:/home";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("title", "Create User");
            if (!user.getPassword().equals(confirm)) {
                model.addAttribute("message", "Passwords don't match");
                user.setPassword("");
            }
            if (!sameUsername.isEmpty()) {
                model.addAttribute("message", "Username already in use, try a different one.");
            }
            return "user/add";
        }
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login (Model model){
        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        return "user/login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String loginUser(Model model, @ModelAttribute User user, HttpServletResponse response){
        List<User> thisUser = userDao.findByUsername(user.getUsername());
        if(thisUser.isEmpty()){
            model.addAttribute("message", "Invalid Username");
            model.addAttribute("title", "Login");
            return "user/login";
        }

        User loggedIn = thisUser.get(0);
        if(loggedIn.getPassword().equals(user.getPassword())){
            Cookie chip = new Cookie("user", user.getUsername());
            chip.setPath("/");
            response.addCookie(chip);
            return "redirect:/home";
        }else{
            model.addAttribute("message", "Invalid Password");
            model.addAttribute("title", "Login");
            return "user/login";
        }
    }


    @RequestMapping(value ="logout")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie chip : cookies){
                chip.setMaxAge(0);
                chip.setPath("/");
                response.addCookie(chip);
            }
        }
        return "redirect:/user/login";
    }
}
