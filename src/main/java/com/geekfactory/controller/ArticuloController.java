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
@RequestMapping("/articulo")
public class ArticuloController {
    
    @Autowired//esta etiqueta se da cuenta de que ArticuloService es una interface, entonces busca que clase usa
    private ArticuloService articuloService;
    
    @GetMapping("/camisas")
    public String inicio(Model model){
        var articulos=articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        //model.addAttribute("totalArticulos",articulos.size());
        return "/articulo/camisas";
    }
    @GetMapping("/sueters")
    public String inicio2(Model model){
        var articulos=articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        //model.addAttribute("totalArticulos",articulos.size());
        return "/articulo/sueters";
    }
    @GetMapping("/joggers")
    public String inicio3(Model model){
        var articulos=articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        //model.addAttribute("totalArticulos",articulos.size());
        return "/articulo/joggers";
    }
    @GetMapping("/nuevo")
    public String articuloNuevo(Articulo articulo){
        return "/articulo/modifica";
    }
    
    @PostMapping("/guardar")
    public String articuloGuardar(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/articulo/administracion";
    }
    
    @GetMapping("/eliminar/{idArticulo}")
    public String articuloEliminar(Articulo articulo){
        articuloService.delete(articulo);
        return "redirect:/articulo/administracion";
    }
    
    @GetMapping("/modificar/{idArticulo}")
    public String articuloModificar(Model model, Articulo articulo){
        articulo=articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modifica";
    }
}
