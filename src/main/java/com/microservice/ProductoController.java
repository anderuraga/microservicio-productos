package com.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producto")
public class ProductoController {

	@Autowired
	ProductoRepository productoRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> listar() {

		List<Producto> productos = productoRepository.findAll();

		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build(); // 204
		} else {
			return ResponseEntity.ok(productos); // 200
		}

	}

}
