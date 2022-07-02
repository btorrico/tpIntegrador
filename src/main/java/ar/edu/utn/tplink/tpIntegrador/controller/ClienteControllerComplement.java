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
import ar.edu.utn.tplink.tpIntegrador.model.Cliente;
import ar.edu.utn.tplink.tpIntegrador.repository.IClienteRepository;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ClienteControllerComplement {
    @Autowired
    IClienteRepository clienteRepo;
    
    // Lista Clientes
    @Transactional
    @GetMapping("/clientes")
    public Iterable<Cliente> getClientes(){
    	return clienteRepo.findAll();
    }
    
    
    //ALTA Cliente
    @Transactional
    @PostMapping("/clientes")
    public String save(@RequestBody Cliente cliente){ 
//Deberia devolver void pero devuele String para probar
        clienteRepo.save(cliente);
        return "El cliente se guardo satisfactoriamente";
    }
    
	//Busqueda vendedor
	@Transactional
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable int id){
			Cliente cliente = clienteRepo.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
			return ResponseEntity.ok(cliente);
	}
  //Baja cliente
  	@DeleteMapping("/clientes/{id}")
  	@Transactional
  	public ResponseEntity<Map<String,Boolean>> deleteById(@PathVariable int id){
  		Cliente cliente = clienteRepo.findById(id)
  				            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
  		
  		clienteRepo.delete(cliente);
  		Map<String, Boolean> respuesta = new HashMap<>();
  		respuesta.put("eliminar",Boolean.TRUE);
  		return ResponseEntity.ok(respuesta);
      }

    
	//Modificacion Cliente
	@Transactional
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable int id,@RequestBody Cliente detallesCliente){
		Cliente cliente = clienteRepo.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
		//Falta agregar usuario y contrasenia
	//	cliente.setUsuario(detallesCliente.getUsuario());
		//cliente.setContrasenia(detallesCliente.getContrasenia());
		cliente.setNombre(detallesCliente.getNombre());
		cliente.setApellido(detallesCliente.getApellido());
		//cliente.setDireccion(detallesCliente.getDireccion());
		cliente.setDocumento(detallesCliente.getDocumento());
		//cliente.setTelefono(detallesCliente.getTelefono());
		
		Cliente clienteActualizado = clienteRepo.save(cliente);
		return ResponseEntity.ok(clienteActualizado);
    }
	
    
  /*
        // Modificacion Cliente
        @Transactional
    @PutMapping("cliente/modificar/{idClienteOriginal}")
        public Cliente editCliente(@PathVariable Long idClienteOriginal,
                           @RequestParam(required = false, name ="idCliente") Long idClienteNuevo,
                           @RequestParam(required = false, name ="nombre")String nombreNuevo,
                           @RequestParam(required = false, name ="apellido") String apellidoNuevo,
                           @RequestParam(required = false, name ="direccion") String direccionNueva,
                           @RequestParam(required = false, name ="documento") String documentoNuevo,
                           @RequestParam(required = false, name ="telefono") String telefonoNuevo,
                           @RequestParam(required = false, name ="mail") String mailNuevo){
            
         clienteRepo.editCliente(idClienteOriginal, idClienteNuevo, nombreNuevo, apellidoNuevo, direccionNueva, documentoNuevo, telefonoNuevo, mailNuevo);

         Cliente clienteModificado= clienteRepo.findCliente(idClienteNuevo);
        
        return clienteModificado;
        }  

*/
}
   