package com.geekfactory.controller;

import com.geekfactory.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Service
@Controller
@Slf4j
public class IndexController {
    @Autowired//esta etiqueta se da cuenta de que ArticuloService es una interface, entonces busca que clase usa
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var articulos=articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "index";
    }
    @GetMapping("/personaliza/inicio")
    public String personaliza(Model model){
        return "/personaliza/inicio";
    }
    @GetMapping("/promociones/inicio")
    public String promociones(Model model){
        var articulos=articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/promociones/inicio";
    }


}
