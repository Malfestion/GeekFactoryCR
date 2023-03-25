
package com.geekfactory.service;

import com.geekfactory.domain.Articulo;
import java.util.List;

/**
 *
 * @author aledu
 */
public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos);
    public Articulo getArticulo(Articulo articulo);
    public void save(Articulo articulo);//inserta y actualiza
    public void delete(Articulo articulo);
}
