package ar.edu.utn.tplink.tpIntegrador.controller;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.tplink.tpIntegrador.excepciones.SinStockException;
import ar.edu.utn.tplink.tpIntegrador.model.Cliente;
import ar.edu.utn.tplink.tpIntegrador.model.ItemDeCompra;
import ar.edu.utn.tplink.tpIntegrador.repository.ICarritoDeCompraRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IClienteRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IItemDeCompraRepository;




//@CrossOrigin
@RepositoryRestController
public class CarritoDeCompraControllerComplement2 {
	
	@Autowired
	ICarritoDeCompraRepository repoCarrito;
	
	@Autowired
	IClienteRepository repoCliente;
	
	@Autowired
	IItemDeCompraRepository repoItemDeCompra;
	
	//@Transactional
//	@RequestMapping(method = RequestMethod.POST, value="/clientes/{clienteId}/agregarACarrito")
	//public @ResponseBody String agregarACarrito(@PathVariable("clienteId") Integer clienteId, 
//			@RequestBody Integer itemId) {
		
		//Optional<Cliente> opcionalCliente = repoCliente.findById(clienteId);
	//	if(opcionalCliente.isEmpty()) {
		//	return "cliente no encontrado";
	//	}
		
	//	Cliente cliente = opcionalCliente.get();
		
//	
//		Optional<CarritoDeCompra> opcionalCarritoDeCompra = ICarritoDeCompraRepository.findById(cliente);
//		if(opcionalCarritoDeCompra.isEmpty()) {
//			return "carrito no encontrado";
//		}
//		
//		CarritoDeCompra carritoDeCompra = opcionalCarritoDeCompra.get();
//		
		
		
//		Optional<ItemDeCompra> opcionalItemDeCompra = repoItemDeCompra.findById(itemId);
	//	if(opcionalItemDeCompra.isEmpty()) {
		//	return "El item no fue encontrado";
//		}
		
	//	ItemDeCompra itemDeCompra = opcionalItemDeCompra.get();
		
		//------------------------------
//		try
		//{
	//	cliente.agregarACarrito(itemDeCompra);
//		} catch(SinStockException ex) {
	//		return "No contamos con Stock del item seleccionado";
//		}
		//-------------------------------
	//	return "ok";
	//}
}

