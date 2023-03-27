package com.geekfactory.controller;


import com.geekfactory.domain.Articulo;
import com.geekfactory.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aledu
 */
@Controller
@RequestMapping("/tematicas")
public class TematicaController {
    
    @Autowired//esta etiqueta se da cuenta de que ArticuloService es una interface, entonces busca que clase usa
    private ArticuloService articuloService;
    
    @GetMapping("/inicio")
    public String inicio(Model model){
        return "/tematicas/inicio";
    }

}
