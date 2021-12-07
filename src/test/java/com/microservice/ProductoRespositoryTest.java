package com.microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductoRespositoryTest {

	@Autowired
	ProductoRepository productoRepository;
	
	@Test
	void testFindAll() {
		
		ArrayList<Producto> productos = (ArrayList<Producto>) productoRepository.findAll();
		assertTrue( 3 == productos.size() );		
		
	}
	
	@Test
	void testFindById() {
		
		Producto p = productoRepository.findById(3).orElse(null);
		assertEquals("portatil", p.getNombre() );
		assertEquals(3, p.getId() );
				
		
	}

}



