package com.demo.junitBootcamp.junitBootcamp.services;

import com.demo.junitBootcamp.junitBootcamp.model.Articulo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BaseDatosServiceImpl implements BaseDatosServiceI{

    private Map<Integer,Articulo> storage = new HashMap<Integer, Articulo>();

    @Override
    public void initBBDD() {
        storage.put(1,new Articulo("Camiseta",30D));
        storage.put(2,new Articulo("Cama",450.00));
        storage.put(3,new Articulo("Silla",50.00));
    }

    @Override
    public Articulo findArticuloById(Integer id) {
        return storage.get(id);
    }

    @Override
    public Integer insertarArticulo(Articulo articulo) {
        storage.put(storage.size()+1,articulo);
        return storage.size();
    }

}
