package com.web.luft.SpringWeb.controllers;

import com.web.luft.SpringWeb.services.CookieService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.UnsupportedEncodingException;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario"));
        return "home/index";
    }
}
