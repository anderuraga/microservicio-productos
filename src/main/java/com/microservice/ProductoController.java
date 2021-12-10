package com.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/producto")
public class ProductoController {

		@Autowired
		ProductoRepository productoRepository;
		
		@RequestMapping( method = RequestMethod.GET )
		public ResponseEntity<List<Producto>> getAll() {
			
			ResponseEntity<List<Producto>> response = null;
			
			List<Producto> productos = productoRepository.findAll();
			
			if (productos.isEmpty()) {
				response = ResponseEntity.noContent().build(); // 204
			}else {
				response = ResponseEntity.ok(productos); // 200
			}
			
			return response;
			
		}
	
}
