package ar.edu.utn.tplink.tpIntegrador.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ar.edu.utn.tplink.tpIntegrador.excepciones.NoSePuedeAplicarCuponException;


@Entity
public class Membresia extends Promocion{
	
	@ManyToMany
	private Collection<Cliente> clientes;
	private double descuento;



	public Membresia(Collection<Cliente> clientes, double descuento) {
		super();
		this.clientes = clientes;
		this.descuento = descuento;
	}


	public Collection<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}


	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	@Override
	public double descuento() throws NoSePuedeAplicarCuponException {
		// TODO Auto-generated method stub
		return 0;
	}
}
