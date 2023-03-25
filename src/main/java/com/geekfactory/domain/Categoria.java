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
@Table(name="categoria")
public class Categoria implements Serializable{
    private static final long serialVersionUID=1L;//numero en el que inicia el incremental
    //llave primaria de la base de datos:
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//java no genera el numero, lo genera mysql
    @Column(name="id_categoria")//dentro de la clase se llama idCredito pero dentro de la tabla se llama id_credito
    private long idCategoria;//automaticamente sabe que en mysql es id_cliente
    private String nombre;
    

    public Categoria() {
    }

    public Categoria(String nombre, boolean activo) {
        this.nombre = nombre;
    }

    


}