package com.demo.junitBootcamp.junitBootcamp.services;

import com.demo.junitBootcamp.junitBootcamp.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoCompraServiceImpl implements CarritoCompraServiceI{

    @Autowired
    private BaseDatosServiceI baseDatos;
    private List<Articulo> articuloList = new ArrayList<>();

    @Override
    public void limpiarCesta() {
        articuloList.clear();
    }

    @Override
    public void addArticulo(Articulo a) {
        articuloList.add(a);
    }

    @Override
    public int getNumArticulo() {
        return articuloList.size();
    }

    @Override
    public List<Articulo> getArticulos() {

        return articuloList;
    }

    @Override
    public double totalPrice() {
        double totaPrice =0;
        for (Articulo item : articuloList) {
            totaPrice += item.getPrecio();
        }
        return totaPrice;
    }

    @Override
    public double calculadorDescuento(double precio, double porcentajeDescuento) {
        return precio-(precio*(porcentajeDescuento/100));
    }

    @Override
    public Double aplicarDescuento(Double descuento, Integer id) {
        Articulo articulo = baseDatos.findArticuloById(id);
        Articulo articulo2 = baseDatos.findArticuloById(2);
        if (articulo!=null){
            return calculadorDescuento(articulo.getPrecio(),descuento);
        }else
            System.out.println("No se ha encontrado el articulo con el id"+id);

        return null;
    }

    @Override
    public Integer insertarArticulo(Articulo a) {
        Integer id = baseDatos.insertarArticulo(a);
        addArticulo(a);
        return id;
    }


}
