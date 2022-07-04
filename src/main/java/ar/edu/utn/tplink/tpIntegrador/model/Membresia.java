package ar.edu.utn.tplink.tpIntegrador.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
@DiscriminatorValue("2")
public class Membresia extends Promocion{
	@ManyToMany
	private Collection<Cliente> clientes;
	private Double porcentajeDescuento;
	
	@Override
	public Double aplicar(CarritoDeCompra carritoDeCompra) {
		if(clientes.contains(carritoDeCompra.getCliente())) {
			return carritoDeCompra.calcularPrecioTotalSinPromociones() * porcentajeDescuento;
		}else {
			return 0.0;
		}
		
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Membresia(Collection<Cliente> clientes, Double porcentajeDescuento) {
		super();
		this.clientes = clientes;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Membresia() {
		super();
	}


	
	
}

