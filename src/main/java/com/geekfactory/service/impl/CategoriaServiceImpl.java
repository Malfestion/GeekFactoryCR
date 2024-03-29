/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.geekfactory.service.impl;

import com.geekfactory.dao.CategoriaDao;
import com.geekfactory.domain.Categoria;
import com.geekfactory.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aledu
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired//Debe haber 1 solo objeto CategoriaDao, si ya existe se usa y si no existe se crea automaticamente sin usar new.
    private CategoriaDao categoriaDao;
   
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>)categoriaDao.findAll();
        return lista;
    }
    
    @Transactional(readOnly=true)
    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
}
