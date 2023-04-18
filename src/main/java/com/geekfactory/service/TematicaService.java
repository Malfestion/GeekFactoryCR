
package com.geekfactory.service;

import com.geekfactory.domain.Tematica;
import java.util.List;

/**
 *
 * @author aledu
 */
public interface TematicaService {
    public List<Tematica> getTematicas(boolean activos);
    public Tematica getTematica(Tematica tematica);
    public void save(Tematica tematica);//inserta y actualiza
    public void delete(Tematica tematica);
}
