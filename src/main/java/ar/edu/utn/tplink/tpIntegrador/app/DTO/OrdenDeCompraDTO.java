package ar.edu.utn.tplink.tpIntegrador.app.DTO;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.tplink.tpIntegrador.model.ItemDeCompra;


public interface OrdenDeCompraDTO {
	LocalDate getFecha();
	
	@Value("#{target.items")
	Collection<ItemDeCompra> getItems();
	
	@Value("#{target.items.size()")
	int cantItems();
	
	double getSubtotal();
	
	double getTotal();
}
