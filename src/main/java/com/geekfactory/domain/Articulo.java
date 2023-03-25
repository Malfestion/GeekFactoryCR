package com.geekfactory.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


/**
 *
 * @author aledu
 */
@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable{
    private static final long serialVersionUID=1L;//numero en el que inicia el incremental
    //llave primaria de la base de datos:
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//java no genera el numero, lo genera mysql
    @Column(name="id_articulo")
    private long idArticulo;//automaticamente sabe que en mysql es id_cliente
    private String descripcion;
    private double precio;
    private String imagen;
    @JoinColumn(name="id_categoria",referencedColumnName="id_categoria")//relacion
    @ManyToOne//Tipo de relacion
    private Categoria categoria;
    @JoinColumn(name="id_tematica",referencedColumnName="id_tematica")//relacion
    @ManyToOne//Tipo de relacion
    private Tematica tematica;
    public Articulo() {
    }

    public Articulo(String descripcion, double precio, String imagen, Categoria categoria, Tematica tematica) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        //this.categoria = categoria;
       // this.tematica = tematica;
    }



    
}