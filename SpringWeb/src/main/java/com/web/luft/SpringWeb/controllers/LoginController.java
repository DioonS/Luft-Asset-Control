package com.web.luft.SpringWeb.controllers;

import com.web.luft.SpringWeb.models.Administrador;
import com.web.luft.SpringWeb.repository.AdministradoresRepo;
import com.web.luft.SpringWeb.services.CookieService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException{
        Administrador adm = this.repo.findByEmailAndSenha(admParam.getEmail(), admParam.getSenha());
        if(adm != null){
            int tempoLogado = (60*60); // 1 hora de cookie
            if(lembrar != null) tempoLogado = (60*60*24*365); // 1 ano de cookie
            CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }

    /*@PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException{
        Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
        //ArrayList<Administrador> result = this.repo.findByEmailAndSenha(admParam.getEmail(), admParam.getSenha());
        if(!result.isEmpty()){
            Administrador adm = result.get(0);
            int tempoLogado = (60*60); // 1 hora de cookie
            if(lembrar != null) tempoLogado = (60*60*24*365); // 1 ano de cookie
            CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }*/

    /*@PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException{
        System.out.println("Tentando logar com usuário " + admParam.getEmail());
        ArrayList<Administrador> result = this.repo.findByEmailAndSenha(admParam.getEmail(), admParam.getSenha());
        System.out.println("Resultado da busca: " + result);
        if(!result.isEmpty()){
            System.out.println("Usuário encontrado, criando cookies");
            Administrador adm = result.get(0);
            int tempoLogado = (60*60); // 1 hora de cookie
            if(lembrar != null) tempoLogado = (60*60*24*365); // 1 ano de cookie
            CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
            return "redirect:/";
        }
        System.out.println("Usuário ou senha inválidos");
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }*/

    @GetMapping("/logout")
    public String logar(HttpServletResponse response) throws IOException{
        CookieService.setCookie(response, "usuarioId", "", 0);
        return "redirect:/login";
    }
}

