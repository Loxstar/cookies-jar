package com.theironyard.charlotte.cookiesjar.controllers;


import com.theironyard.charlotte.cookiesjar.models.Cookie;
import com.theironyard.charlotte.cookiesjar.models.CookieSale;
import com.theironyard.charlotte.cookiesjar.models.CookieSalesData;
import com.theironyard.charlotte.cookiesjar.models.Ingredient;
import com.theironyard.charlotte.cookiesjar.repositories.CookieRepository;
import com.theironyard.charlotte.cookiesjar.repositories.CookieSaleRepository;
import com.theironyard.charlotte.cookiesjar.repositories.CookieSalesDataRepository;
import com.theironyard.charlotte.cookiesjar.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieJarController {

    @Autowired
    CookieRepository cookiesRepo;

    @Autowired
    CookieSalesDataRepository cookieSalesDataRepo;

    @Autowired
    CookieSaleRepository cookieSalesRepo;

    @Autowired
    IngredientRepository ingredientsRepo;


    @GetMapping("/")
//    GetMapping("/") is identical to the annotation below
//    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("cookies", cookiesRepo.findAll());
        model.addAttribute("cookieSales", cookieSalesRepo.findAll());
        return "index";
    }

    @PostMapping("/add-cookie")
    public String addCookie(Cookie cookie) {
        CookieSalesData csd = new CookieSalesData();

        csd.setName("Soft Chips Ahoy");
        csd.setPrice(4.99);
        csd.setUpc("abc123456");

        // save our cookie sales data
        cookieSalesDataRepo.save(csd);

        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(ingredientsRepo.findByName("Flour"));
        ingredients.add(ingredientsRepo.findByName("Butter"));
        ingredients.add(ingredientsRepo.findByName("Chocolate Chips"));
        ingredients.add(ingredientsRepo.findByName("Eggs"));
        ingredients.add(ingredientsRepo.findByName("Love"));

        cookie.setIngredients(ingredients);
        cookie.setSalesData(csd);

        // save our cookie
        cookiesRepo.save(cookie);
        return "redirect:/";
    }

    @PostMapping("/buy-cookie")
    public String buyCookie(int id) {
        // once we're here, we can freely
        // add new sales data to the cookies sales list
        CookieSale sale = new CookieSale();
        Cookie cookie = cookiesRepo.findOne(id);

        sale.setCost(cookie.getSalesData().getPrice());
        sale.setDay(Date.from(Instant.now()));
        sale.setCookie(cookie);

        cookieSalesRepo.save(sale);

        return "redirect:/";
    }
}
