package ar.edu.utn.tplink.tpIntegrador.controller;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.tplink.tpIntegrador.excepciones.ResourceNotFoundException;
import ar.edu.utn.tplink.tpIntegrador.model.OrdenDeCompra;
import ar.edu.utn.tplink.tpIntegrador.model.Proveedor;
import ar.edu.utn.tplink.tpIntegrador.model.Vendedor;
import ar.edu.utn.tplink.tpIntegrador.repository.IOrdenDeCompraRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrdenDeCompraControllerComplement {

	@Autowired
	IOrdenDeCompraRepository repoOrden;
	
	//Lista Ordenes
	@Transactional
	@GetMapping("/ordenes")
	public Iterable<OrdenDeCompra> listarTodosLosVendedores() {
		return repoOrden.findAll();
	}

	//Busqueda Orden por id
	@Transactional
	@GetMapping("/ordenes/{id}")
	public ResponseEntity<OrdenDeCompra> obtenerOrdenrPorId(@PathVariable int id){
			OrdenDeCompra orden = repoOrden.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe la orden con el ID : " + id));
			return ResponseEntity.ok(orden);
	}
	
	//Baja Orden de compra
	@DeleteMapping("/ordenes/{id}")
	@Transactional
	public ResponseEntity<Map<String,Boolean>> eliminarOrden(@PathVariable int id){
		OrdenDeCompra orden = repoOrden.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la orden con el ID : " + id));
		
		repoOrden.delete(orden);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	
	
}
