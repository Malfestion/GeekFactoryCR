/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.geekfactory.domain;

import lombok.Data;

@Data
public class Item extends Articulo {
    private int cantidad; //Almacenar la cantidad de items de un articulo

    public Item() {
    }

    public Item(Articulo articulo) {
        super.setIdArticulo(articulo.getIdArticulo());
        super.setCategoria(articulo.getCategoria());
        super.setTematica(articulo.getTematica());
        super.setDescripcion(articulo.getDescripcion());
        super.setPrecio(articulo.getPrecio());
        super.setImagen(articulo.getImagen());
        this.cantidad = 0;
    }
}