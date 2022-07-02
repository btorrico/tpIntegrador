package ar.edu.utn.tplink.tpIntegrador.app.DTO;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.tplink.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.tplink.tpIntegrador.model.OrdenDeCompra;


public interface ClienteDTO {
	
	String getNombre();
	
	CarritoDeCompra getCarritoDeCompras();
	
	@Value("#{target.nombre} #{target.apellido}")
	String getNombreCompleto();

	@Value("#{target.comprasRealizadas}")
	List<OrdenDeCompra> getComprasRealizadas();
}
