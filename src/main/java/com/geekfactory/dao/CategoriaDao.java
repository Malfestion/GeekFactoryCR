package com.geekfactory.dao;

import com.geekfactory.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aledu
 */
public interface CategoriaDao extends CrudRepository<Categoria,Long>{
    
}
