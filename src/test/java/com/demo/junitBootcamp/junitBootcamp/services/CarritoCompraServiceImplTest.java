package com.demo.junitBootcamp.junitBootcamp.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.demo.junitBootcamp.junitBootcamp.model.Articulo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CarritoCompraServiceImplTest {

	@Mock
	private BaseDatosServiceI baseDatosServiceI;
	@InjectMocks
	private CarritoCompraServiceImpl carritoService = new CarritoCompraServiceImpl();

	@Test
	void testLimpiarCesta() {
		carritoService.addArticulo(new Articulo("Sofa",298.43));
		carritoService.limpiarCesta();
		assertTrue(carritoService.getArticulos().isEmpty());
		
	}

	@Test
	void testAddArticulo() {
		System.out.println("Añadiendo un artículo");
		assertTrue(carritoService.getArticulos().isEmpty());
		carritoService.addArticulo(new Articulo("Sofa",298.43));
		assertFalse(carritoService.getArticulos().isEmpty());
	}

	@Test
	void testGetNumArticulo() {
		carritoService.addArticulo(new Articulo("Sofa",298.43));
		assertEquals(1,carritoService.getNumArticulo());
	}

	@Test
	void testGetArticulos() {
		Articulo articulo1 = new Articulo("Sofa",298.43);
		Articulo articulo2 = new Articulo("Cama",100.00);
		List<Articulo> listaArticulo = new LinkedList<>();
		carritoService.addArticulo(new Articulo("Sofas",298.43));
		carritoService.addArticulo(articulo2);
		listaArticulo.add(articulo1); listaArticulo.add(articulo2);
		assertEquals(listaArticulo,carritoService.getArticulos());
	}

	@Test
	void testTotalPrice() {
		carritoService.addArticulo(new Articulo("Sofa",298.43));
		carritoService.addArticulo(new Articulo("Cama",100.00));
		assertEquals(398.43,carritoService.totalPrice());
	
	}

	@Test
	void testCalculadorDescuento() {
		carritoService.addArticulo(new Articulo("Sofa",298.43));
		assertEquals(238,73,carritoService.calculadorDescuento(298.43, 20));
	}

	@Test
	void aplicarDescuentoTest(){
		Articulo articulo =new Articulo("Camiseta",30D);
		when(baseDatosServiceI.findArticuloById(2)).thenReturn(articulo);
		when(baseDatosServiceI.findArticuloById(3)).thenReturn(articulo);//Stubbing
		Double resultado =carritoService.aplicarDescuento(10D,3);
		assertEquals(resultado,27D);
		verify(baseDatosServiceI,times(2)).findArticuloById(any());
	}

	@Test
	void insertarArticulo(){
		Articulo articulo = new Articulo("Camiseta",30D);
		when(baseDatosServiceI.insertarArticulo(articulo)).thenReturn(4);
		Integer id = carritoService.insertarArticulo(articulo);
		assertEquals(4,id);
		verify(baseDatosServiceI).insertarArticulo(articulo);
	}

}
