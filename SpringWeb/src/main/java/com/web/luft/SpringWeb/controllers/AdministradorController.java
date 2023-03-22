package com.web.luft.SpringWeb.controllers;

import com.web.luft.SpringWeb.models.Administrador;
import com.web.luft.SpringWeb.repository.AdministradoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdministradorController {
    @Autowired
    private AdministradoresRepo repo;
    @GetMapping("administradores")
    public String index (Model model){
        List<Administrador> administradores = (List<Administrador>)repo.findAll();
        model.addAttribute("administradores", administradores);
        return "administradores/index";
    }

    @GetMapping("/administradores/new")
    public String index (){
        return "administradores/new";
    }

    @PostMapping("/administradores/create")
    public String create (@Valid Administrador administrador, BindingResult result){
        if (result.hasErrors()) {
            return "administradores/new";
        }
        repo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}/delete")
    public String delete (@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
    public String find (@PathVariable int id, Model model){
        Optional<Administrador> admin = repo.findById(id);
        try {
            model.addAttribute("administrador", admin.get());
        } catch (Exception err) {
            return "redirect:/administradores";
        }
        return "administradores/edit";
    }

    @PostMapping("/administradores/{id}/update")
    public String update (@PathVariable int id, Administrador administrador){
        if(!repo.existsById(id)) {
            return "redirect:/administradores";
        }
        repo.save(administrador);
        return "redirect:/administradores";
    }
}
