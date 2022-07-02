package ar.edu.utn.tplink.tpIntegrador.app.DTO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.tplink.tpIntegrador.model.Producto;


public interface ItemDeCompraDTO {
	
	Integer getId();
	

	Producto getProducto();
	
	int getCantidad();
	
	
}
