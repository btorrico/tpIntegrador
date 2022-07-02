package ar.edu.utn.tplink.tpIntegrador.excepciones;

import ar.edu.utn.tplink.tpIntegrador.model.Producto;

public class ProductoRepetidoException extends Exception {
	private Producto producto;

	public ProductoRepetidoException(Producto producto) {
		super();
		this.producto = producto;
	}
	
}
