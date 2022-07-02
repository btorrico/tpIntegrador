package ar.edu.utn.tplink.tpIntegrador.app.DTO;

import ar.edu.utn.tplink.tpIntegrador.model.Proveedor;

public interface ProductoDTO {
	String getNombre();
	
	double getPrecio();
	
	Proveedor getProveedor(); 
	
	int getCantStock();
	
	String getImagen();

}
