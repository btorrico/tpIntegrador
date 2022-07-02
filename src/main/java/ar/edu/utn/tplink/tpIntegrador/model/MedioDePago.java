package ar.edu.utn.tplink.tpIntegrador.model;

import javax.persistence.Entity;

@Entity
public class MedioDePago extends Promocion {

	private MetodoDePago metodo;
	private double descuento;

	public MedioDePago(MetodoDePago metodo, double descuento) {
		super();
		this.metodo = metodo;
		this.descuento = descuento;
	}

	public MetodoDePago getMetodo() {
		return metodo;
	}

	public void setMetodo(MetodoDePago metodo) {
		this.metodo = metodo;
	}
	
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public double descuento() {
		return descuento;
	}
	
}
