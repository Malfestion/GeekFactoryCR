package com.geekfactory.dao;

import com.geekfactory.domain.Tematica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aledu
 */
public interface TematicaDao extends CrudRepository<Tematica,Long>{
    
}
