package ar.edu.utn.tplink.tpIntegrador.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.tplink.tpIntegrador.model.Producto;
import ar.edu.utn.tplink.tpIntegrador.model.Proveedor;
import ar.edu.utn.tplink.tpIntegrador.repository.IProductoRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IProveedorRepository;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductoControllerComplement {

	@Autowired
	IProductoRepository repoProducto;
	
	@Autowired
	IProveedorRepository repoProveedor;
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> listarProductos() {
		return new ResponseEntity(repoProducto.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/proveedores") 
	public ResponseEntity<List<Proveedor>> listarProveedores() {
		return new ResponseEntity(repoProveedor.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
		return new ResponseEntity(repoProducto.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
		return new ResponseEntity(repoProducto.save(producto), HttpStatus.CREATED);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
		Optional<Producto> productoEncontrado = repoProducto.findById(id);
		if(productoEncontrado == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		try {
			productoEncontrado.get().setNombre(producto.getNombre());
			productoEncontrado.get().setPrecio(producto.getPrecio());
			productoEncontrado.get().setProveedor(producto.getProveedor());
			return new ResponseEntity<>(repoProducto.save(productoEncontrado.get()), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id) {
		repoProducto.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
		



