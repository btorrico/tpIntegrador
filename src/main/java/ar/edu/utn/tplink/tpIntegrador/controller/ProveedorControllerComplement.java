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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.tplink.tpIntegrador.excepciones.ResourceNotFoundException;
import ar.edu.utn.tplink.tpIntegrador.model.Proveedor;
import ar.edu.utn.tplink.tpIntegrador.repository.IProveedorRepository;



@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class ProveedorControllerComplement {
    
	@Autowired
	private IProveedorRepository repoProveedor;

	//Lista Proveedores
	@Transactional
	@GetMapping("/listar")
	public Iterable<Proveedor> listarTodosLosProveedores() {
		return repoProveedor.findAll();
	}
	

	//Alta Proveedor
	@Transactional
	@PostMapping("/proveedor")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		return repoProveedor.save(proveedor);
	}
    
	//Busqueda proveedor
	@Transactional
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable int id){
			Proveedor proveedor = repoProveedor.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el proveedor con el ID : " + id));
			return ResponseEntity.ok(proveedor);
	}
	
	//Modificacion Proveedor
	@Transactional
	@PutMapping("/proveedores/{id}")
	public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable int id,@RequestBody Proveedor detallesProveedor){
		Proveedor proveedor = repoProveedor.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el proveedor con el ID : " + id));
		
		proveedor.setNombre(detallesProveedor.getNombre());
		proveedor.setDireccion(detallesProveedor.getDireccion());
		proveedor.setTelefono(detallesProveedor.getTelefono());
		proveedor.setMail(detallesProveedor.getMail());
		
		Proveedor proveedorActualizado = repoProveedor.save(proveedor);
		return ResponseEntity.ok(proveedorActualizado);
    }

	//Baja proveedor
	@DeleteMapping("/proveedores/{id}")
	@Transactional
	public ResponseEntity<Map<String,Boolean>> eliminarProveedor(@PathVariable int id){
		Proveedor proveedor = repoProveedor.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el proveedor con el ID : " + id));
		
		repoProveedor.delete(proveedor);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}



