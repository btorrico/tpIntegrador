package ar.edu.utn.tplink.tpIntegrador.app.DTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.tplink.tpIntegrador.model.Producto;
import ar.edu.utn.tplink.tpIntegrador.model.Proveedor;


public interface VendedorDTO {
String getNombre();
	
	List<Proveedor> getProveedores();
	
	List<Producto> getProductos();
	
	@Value("#{target.nombre} #{target.apellido}")
	String getNombreCompleto();
	

}