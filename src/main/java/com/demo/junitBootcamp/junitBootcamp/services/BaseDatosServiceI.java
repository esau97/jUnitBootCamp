package com.demo.junitBootcamp.junitBootcamp.services;

import com.demo.junitBootcamp.junitBootcamp.model.Articulo;

public interface BaseDatosServiceI {
    public void initBBDD();
    public Articulo findArticuloById(Integer id);

    public Integer insertarArticulo(Articulo articulo);

}
