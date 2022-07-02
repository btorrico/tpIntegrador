package ar.edu.utn.tplink.tpIntegrador.app.DTO;


import java.util.Collection;


import ar.edu.utn.tplink.tpIntegrador.model.ItemDeCompra;
import ar.edu.utn.tplink.tpIntegrador.model.Promocion;


public interface CarritoDeCompraDTO {
	
	//@Value("#{target.itemsCarrito")
	Collection<ItemDeCompra> getItemsCarrito();
	
	double getSubtotal();
	
//	@Value("#{target.promociones")
	Collection<Promocion> getPromociones();
	
	
	

}
