package com.demo.junitBootcamp.junitBootcamp.services;

import com.demo.junitBootcamp.junitBootcamp.model.Articulo;

import java.util.List;

public interface CarritoCompraServiceI {
    public void limpiarCesta();
    public void addArticulo(Articulo a);
    public int getNumArticulo();
    public List<Articulo> getArticulos();
    public double totalPrice();
    public double calculadorDescuento(double precio, double porcentajeDescuento);
    public Double aplicarDescuento(Double descuento,Integer id);
    public Integer insertarArticulo(Articulo a);
}
