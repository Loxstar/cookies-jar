package com.theironyard.charlotte.cookiesjar.controllers;


import com.theironyard.charlotte.cookiesjar.models.Cookie;
import com.theironyard.charlotte.cookiesjar.repositories.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookieJarController {

    @Autowired
    CookieRepository cookiesRepo;


    @GetMapping("/")
//    GetMapping("/") is identical to the annotation below
//    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("cookies", cookiesRepo.findAll());
        return "index";
    }

    @PostMapping("/add-cookie")
    public String addCookie(Cookie cookie) {
        cookiesRepo.save(cookie);
        return "redirect:/";
    }
}
