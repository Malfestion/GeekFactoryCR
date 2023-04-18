package com.geekfactory.controller;


import com.geekfactory.domain.Articulo;
import com.geekfactory.domain.Categoria;
import com.geekfactory.domain.Tematica;
import com.geekfactory.service.ArticuloService;
import com.geekfactory.service.CategoriaService;
import com.geekfactory.service.TematicaService;
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
@RequestMapping("/administracion")
public class AdministracionController {
    
    @Autowired//esta etiqueta se da cuenta de que ArticuloService es una interface, entonces busca que clase usa
    private ArticuloService articuloService;
    @Autowired//esta etiqueta se da cuenta de que ArticuloService es una interface, entonces busca que clase usa
    private CategoriaService categoriaService;
    @Autowired//esta etiqueta se da cuenta de que ArticuloService es una interface, entonces busca que clase usa
    private TematicaService tematicaService;
    //--------------------------------------Administracion de articulos-----------------------------------------------
    @GetMapping("/listadoArticulo")
    public String articulos(Model model){
        var articulos=articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        //model.addAttribute("totalArticulos",articulos.size());
        return "/administracion/listadoArticulo";
    }
    @GetMapping("/nuevoArticulo")
    public String articuloNuevo(Articulo articulo){
        return "/administracion/modificaArticulo";
    }
    
    @PostMapping("/guardarArticulo")
    public String articuloGuardar(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/administracion/listadoArticulo";
    }
    
    @GetMapping("/eliminarArticulo/{idArticulo}")
    public String articuloEliminar(Articulo articulo){
        articuloService.delete(articulo);
        return "redirect:/administracion/listadoArticulo";
    }
    
    @GetMapping("/modificaArticulo/{idArticulo}")
    public String articuloModificar(Model model, Articulo articulo){
        articulo=articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/administracion/modificaArticulo";
    }
    //--------------------------------------Administracion de categorias-----------------------------------------------
      @GetMapping("/listadoCategoria")
    public String categorias(Model model){
        var categorias=categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        //model.addAttribute("totalArticulos",articulos.size());
        return "/administracion/listadoCategoria";
    }
    @GetMapping("/nuevoCategoria")
    public String articuloNuevo(Categoria categoria){
        return "/administracion/modificaCategoria";
    }
    
    @PostMapping("/guardarCategoria")
    public String categoriaGuardar(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/administracion/listadoCategoria";
    }
    
    @GetMapping("/eliminarCategoria/{idCategoria}")
    public String categoriaEliminar(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/administracion/listadoCategoria";
    }
    
    @GetMapping("/modificaCategoria/{idCategoria}")
    public String categoriaModificar(Model model, Categoria categoria){
        categoria=categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/administracion/modificaCategoria";
    }
    //--------------------------------------Administracion de tematicas-----------------------------------------------
    @GetMapping("/listadoTematica")
    public String tematicas(Model model){
        var tematicas=tematicaService.getTematicas(false);
        model.addAttribute("tematicas", tematicas);
        //model.addAttribute("totalArticulos",articulos.size());
        return "/administracion/listadoTematica";
    }
    @GetMapping("/nuevoTematica")
    public String articuloNuevo(Tematica tematica){
        return "/administracion/modificaTematica";
    }
    
    @PostMapping("/guardarTematica")
    public String tematicaGuardar(Tematica tematica){
        tematicaService.save(tematica);
        return "redirect:/administracion/listadoTematica";
    }
    
    @GetMapping("/eliminarTematica/{idTematica}")
    public String tematicaEliminar(Tematica tematica){
        tematicaService.delete(tematica);
        return "redirect:/administracion/listadoTematica";
    }
    
    @GetMapping("/modificaTematica/{idTematica}")
    public String tematicaModificar(Model model, Tematica tematica){
        tematica=tematicaService.getTematica(tematica);
        model.addAttribute("tematica", tematica);
        return "/administracion/modificaTematica";
    }
}
