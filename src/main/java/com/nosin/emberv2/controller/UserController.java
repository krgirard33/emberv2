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
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "adduser", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("title", "Create Account");
        model.addAttribute("user", new User());
        return "user/adduser";
    }

    @RequestMapping(value = "adduser", method = RequestMethod.POST())
    public  String addUser(Model model, @ModelAttribute @Valid User user,
                           Errors errors, String confirm, HttpServletResponse response) {
        List<User>  uList = userDao.findByUsername(user.getUsername());
        if(uList.isEmpty()){
            model.addAttribute("message", "Invalid Username");
            model.addAttribute("title", "Login");
            return "users/login";
        }

        User loggedIn = uList.get(0);
        if(loggedIn.getPassword().equals(user.getPassword())){
            Cookie chip = new Cookie("user", user.getUsername());
            chip.setPath("/");
            response.addCookie(chip);
            return "redirect:/home";
        } else {
            model.addAttribute("message", "Invalid Password");
            model.addAttribute("title", "Login");
            return "user/login";
        }
    }
}
