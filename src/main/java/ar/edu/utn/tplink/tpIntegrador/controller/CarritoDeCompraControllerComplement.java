/*package ar.edu.utn.tplink.tpIntegrador.controller;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.tplink.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.tplink.tpIntegrador.model.Cliente;
import ar.edu.utn.tplink.tpIntegrador.repository.ICarritoDeCompraRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IClienteRepository;




@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class CarritoDeCompraControllerComplement {
	
	@Autowired
	private ICarritoDeCompraRepository repoCarritoDeCompra;
	@Autowired
	private IClienteRepository repoCliente;
	
	
	
    // Lista De Carritos
	 
    @Transactional
    @GetMapping("/carritoDeCompras")
    public Iterable<CarritoDeCompra> listaCarritos(){
        return repoCarritoDeCompra.findAll();
    }
  
	
	@GetMapping("/carritoDeCompras/{idCliente}")
	public CarritoDeCompra get(@PathVariable("idCliente") Long idCliente) {
		
		Optional<Cliente> opcionalCliente= repoCliente.findById(idCliente);
		
		Cliente cliente= opcionalCliente.get();
		
		Optional<CarritoDeCompra> carrito= repoCarritoDeCompra.findByCliente(cliente);
		
		CarritoDeCompra carritoDeCompra= carrito.get();
		
		return carritoDeCompra;
	}
	*/




	//-------------------------------------------------------------------
	//package ar.edu.utn.link.integrador.app;
	//
	//import java.util.Optional;
	//
	//import javax.transaction.Transactional;
	//
	//import org.springframework.beans.factory.annotation.Autowired;
	//import org.springframework.data.rest.webmvc.RepositoryRestController;
	//import org.springframework.web.bind.annotation.CrossOrigin;
	//import org.springframework.web.bind.annotation.PathVariable;
	//import org.springframework.web.bind.annotation.RequestBody;
	//import org.springframework.web.bind.annotation.RequestMapping;
	//import org.springframework.web.bind.annotation.RequestMethod;
	//import org.springframework.web.bind.annotation.ResponseBody;
	//
	//import ar.edu.utn.link.integrador.model.Carrito;
	//import ar.edu.utn.link.integrador.model.Cliente;
	//import ar.edu.utn.link.integrador.model.ItemCarrito;
	//import ar.edu.utn.link.integrador.model.NoHayStockException;
	//
	//
	//@CrossOrigin(origins = "*")
	//@RepositoryRestController
	//public class CarritoControllerComplement {
	//	
//		@Autowired
//		RepoCarrito repoCarrito;
	//	
//		@Autowired
//		RepoCliente repoCliente;
	//	
//		@Autowired
//		RepoItemCarrito repoItem;
	//	
//		@Transactional
//		@RequestMapping(method = RequestMethod.POST, value="/carrito/{clienteId}/agregarItem")
//		public @ResponseBody String inscribir(@PathVariable("clienteId") Integer clienteId, 
//				@RequestBody Integer itemId) {
//			
//			Optional<Cliente> opcionalCliente = repoCliente.findById(clienteId);
//			if(opcionalCliente.isEmpty()) {
//				return "cliente no encontrado";
//			}
//			
//			Cliente cliente = opcionalCliente.get();
//			
	//	
//			Optional<Carrito> opcionalCarrito = repoCarrito.findByCliente(cliente);
//			if(opcionalCarrito.isEmpty()) {
//				return "carrito no encontrado";
//			}
//			
//			Carrito carrito = opcionalCarrito.get();
//			
//			
//			
//			Optional<ItemCarrito> opcionalItem = repoItem.findById(itemId);
//			if(opcionalItem.isEmpty()) {
//				return "Item no encontrado";
//			}
//			
//			ItemCarrito item = opcionalItem.get();
//			
//			//------------------------------
//			try
//			{
//			carrito.agregarProducto(item);
//			} catch(NoHayStockException ex) {
//				return "no hay stock del item seleccionado";
//			}
//			//-------------------------------
//			return "ok";
//		}
	//}
	//

//}
