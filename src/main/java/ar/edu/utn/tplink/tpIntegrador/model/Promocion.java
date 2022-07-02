package ar.edu.utn.tplink.tpIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ar.edu.utn.tplink.tpIntegrador.excepciones.NoSePuedeAplicarCuponException;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Promocion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	public abstract double descuento() throws NoSePuedeAplicarCuponException;
	
	public double aplicarPromocion(CarritoDeCompra carritoDeCompra) throws NoSePuedeAplicarCuponException {
		return carritoDeCompra.getSubtotal() * (1 - this.descuento());
	}
}


