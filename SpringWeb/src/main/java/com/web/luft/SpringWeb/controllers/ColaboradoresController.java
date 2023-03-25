package com.web.luft.SpringWeb.controllers;

import com.web.luft.SpringWeb.models.Colaborador;
import com.web.luft.SpringWeb.repository.ColaboradoresRepo;
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
public class ColaboradoresController {
    @Autowired
    private ColaboradoresRepo repo;
    @GetMapping("colaboradores")
    public String index (Model model){
        List<Colaborador> colabodores = (List<Colaborador>)repo.findAll();
        model.addAttribute("colaboradores", colabodores);
        return "colaboradores/index";
    }

    @GetMapping("/colaboradores/new")
    public String newColaborador (){
        return "colaboradores/new";
    }

    @PostMapping("/colaboradores/create")
    public String create (@Valid Colaborador colaborador, BindingResult result){
        if (result.hasErrors()) {
            return "colaboradores/new";
        }
        repo.save(colaborador);
        return "redirect:/colaboradores";
    }

    @GetMapping("/colaboradores/{id}/delete")
    public String delete (@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/colaboradores";
    }

    @GetMapping("/colaboradores/{id}")
    public String find (@PathVariable int id, Model model){
        Optional<Colaborador> colaboradores = repo.findById(id);
        try {
            model.addAttribute("colaboradores", colaboradores.get());
        } catch (Exception err) {
            return "redirect:/colaboradores";
        }
        return "colaboradores/edit";
    }

    @PostMapping("/colaboradores/{id}/update")
    public String update (@PathVariable int id, Colaborador colaborador){
        if(!repo.existsById(id)) {
            return "redirect:/colaboradores";
        }
        repo.save(colaborador);
        return "redirect:/colaboradores";
    }
}
