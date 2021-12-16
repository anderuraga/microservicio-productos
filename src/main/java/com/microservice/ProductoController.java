package com.microservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("producto")
public class ProductoController {

	@Autowired
	ProductoRepository productoRepository;

	@Operation(summary = "Listado de Productos")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Productos encontrados"),
			@ApiResponse(responseCode = "204", description = "No existen Productos") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> listar() {

		List<Producto> productos = productoRepository.findAll();

		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build(); // 204
		} else {
			return ResponseEntity.ok(productos); // 200
		}

	}

	@Operation(summary = "Obtener un Producto por su identificador")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Producto es encontrado"),
			@ApiResponse(responseCode = "404", description = "No existe producto por su identificador solicitado") })
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Producto> detalle(@PathVariable("id") int id) {

		Producto p = productoRepository.findById(id).orElse(null);

		if (p == null) {
			return ResponseEntity.notFound().build(); // 404
		} else {
			return ResponseEntity.ok(p); // 200
		}

	}

	@Operation(summary = "Eliminar un Producto por su identificador")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Producto eliminado"),
			@ApiResponse(responseCode = "404", description = "No existe producto por su identificador solicitado") })
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Producto> eliminar(@PathVariable("id") int id) {

		Producto p = productoRepository.findById(id).orElse(null);

		if (p == null) {
			return ResponseEntity.notFound().build(); // 404
		} else {
			productoRepository.deleteById(id);
			return ResponseEntity.ok(p); // 200
		}

	}

	@Operation(summary = "Crear un nuevo Producto y asignar un identificador")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Producto Creado") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Producto p) {

		productoRepository.save(p);
		URI uri = URI.create(String.format("/producto/%s", p.getId()));
		return ResponseEntity.created(uri).build(); // 201

	}

}
