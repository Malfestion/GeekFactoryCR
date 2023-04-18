/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.geekfactory.service.impl;

import com.geekfactory.dao.TematicaDao;
import com.geekfactory.domain.Tematica;
import com.geekfactory.service.TematicaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aledu
 */
@Service
public class TematicaServiceImpl implements TematicaService{

    @Autowired//Debe haber 1 solo objeto TematicaDao, si ya existe se usa y si no existe se crea automaticamente sin usar new.
    private TematicaDao tematicaDao;
   
    @Override
    @Transactional(readOnly=true)
    public List<Tematica> getTematicas(boolean activos) {
        var lista = (List<Tematica>)tematicaDao.findAll();
        return lista;
    }
    
    @Transactional(readOnly=true)
    @Override
    public Tematica getTematica(Tematica tematica) {
        return tematicaDao.findById(tematica.getIdTematica()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tematica tematica) {
        tematicaDao.save(tematica);
    }

    @Override
    @Transactional
    public void delete(Tematica tematica) {
        tematicaDao.delete(tematica);
    }
}
